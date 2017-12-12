package calculator;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class calculator {

    String Result;
    String ResultLog;
    CacheOperations cache;
    double Res; //итоговый результат

    char[] opers; //массив операций
    double[] numbers; //массив чисел
    int cntOpers = 0;
    int cnt = 0;
    int count;
    int countOpers;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public calculator(String ResultOperation, CacheOperations cache, Socket socket) {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.socket = socket;
        this.Result = ResultOperation;
        this.ResultLog = ResultOperation;
        this.cache = cache;
        getNumbers(Result);
    }

    public double[] getNumbers(String Result) {
        cntOpers = 0;
        for (int i = 0; i < Result.length(); i++) {
            if (Result.charAt(i) == '+' || Result.charAt(i) == '-' || Result.charAt(i) == '*' || Result.charAt(i) == '/') {
                cntOpers++;
            }
        }
        opers = new char[cntOpers];
        cnt = cntOpers + 1;
        numbers = new double[cnt];
        StringBuilder str = new StringBuilder("");
        count = 0;
        countOpers = 0;
        for (int i = 0; i < Result.length(); i++) {
            if (Result.charAt(i) != '+' && Result.charAt(i) != '-' && Result.charAt(i) != '*' && Result.charAt(i) != '/') {
                str.append(Result.charAt(i));
            }
            if (Result.charAt(i) == '+' || Result.charAt(i) == '-' || Result.charAt(i) == '*' || Result.charAt(i) == '/') {
                opers[countOpers] = Result.charAt(i);
                numbers[count] = Double.parseDouble(str.toString());
                count++;
                countOpers++;
                str.delete(0, str.length());
            }
        }
        numbers[count] = Double.parseDouble(str.toString());
        count++;
        return numbers;
    }

    public double PriorityCalculation() {
        /*
        System.out.println("countOpers = " + countOpers);
        System.out.println("count = " + count);
        System.out.println("DEBUG");
        for(int i=0;i<countOpers+1;i++)
        {
            System.out.print(" " + numbers[i]);
        }
        System.out.println("");
        for(int i=0;i<countOpers;i++)
        {
            System.out.print(" " + opers[i]);
        }
        System.out.println("END DEBUG");
         */

        int hightPriorityOperation = 0;
        for (int i = 0; i < countOpers; i++) {
            if (opers[i] == '*' || opers[i] == '/') {
                hightPriorityOperation++;
            }
        }
        int i = 0;
        while (hightPriorityOperation > 0) {
            if (opers[i] == '*' || opers[i] == '/') {
                Operation operation = new Operation(numbers[i], numbers[i + 1], opers[i]);
                if (cache.inLists(operation)) {
                    Res = cache.getOperation(operation);
                } else {
                    cache.Add(operation);
                    try {
                        out.writeBoolean(true);
                        out.writeUTF(ResultLog);
                        out.writeDouble(operation.operand1);
                        out.writeDouble(operation.operand2);
                        switch (operation.operations) {
                            case PRO:
                                out.writeChar('*');
                                break;
                            case QUO:
                                out.writeChar('/');
                                break;
                            default:
                                break;
                        }
                        Res = in.readDouble();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                numbers[i] = Res;
                for (int j = i; j < countOpers - 1; j++) {
                    opers[j] = opers[j + 1];
                }

                for (int j = i + 1; j < countOpers; j++) {
                    numbers[j] = numbers[j + 1];
                }
                countOpers--;
                hightPriorityOperation--;
                i--;
            }
            i++;
        }

        i = 0;
        while (countOpers > 0) {
            if (opers[i] == '+' || opers[i] == '-') {
                Operation operation = new Operation(numbers[i], numbers[i + 1], opers[i]);

                if (cache.inLists(operation)) {
                    Res = cache.getOperation(operation);
                } else {
                    cache.Add(operation);
                    try {
                        out.writeBoolean(true);
                        out.writeUTF(ResultLog);
                        out.writeDouble(operation.operand1);
                        out.writeDouble(operation.operand2);
                        switch (operation.operations) {
                            case SUM:
                                out.writeChar('+');
                                break;
                            case DIF:
                                out.writeChar('/');
                                break;
                            default:
                                break;
                        }
                        Res = in.readDouble();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

                numbers[i] = Res;
                for (int j = i; j < countOpers - 1; j++) {
                    opers[j] = opers[j + 1];
                }
                for (int j = i + 1; j < countOpers; j++) {
                    numbers[j] = numbers[j + 1];
                }
                countOpers--;
                i--;
            }
            i++;
        }
        return numbers[0];
    }
}
