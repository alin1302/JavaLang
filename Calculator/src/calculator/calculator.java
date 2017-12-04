package calculator;

/**
 *
 * @author Admin
 */
public class calculator {

    String Result;
    double Res; //итоговый результат

    char[] opers; //массив операций
    double[] numbers; //массив чисел
    int cntOpers = 0;
    int cnt = 0;
    int count;
    int countOpers;

    public calculator(String ResultOperation) {
        this.Result = ResultOperation;
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

        for (int i = 0; i < countOpers + 1; i++) {
            if (opers[i] == '*' || opers[i] == '/') {
                Operation operation = new Operation(numbers[i], numbers[i + 1], opers[i]);
                Res = operation.doCalculation();
                numbers[i] = Res;
                for (int j = i; j < countOpers - 1; j++) {
                    opers[j] = opers[j + 1];
                }
                countOpers--;
                for (int j = i + 1; j < count - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                count--;
            }
        }

        for (int i = 0; i < countOpers + 1; i++) {
            if (opers[i] == '+' || opers[i] == '-') {
                Operation operation = new Operation(numbers[i], numbers[i + 1], opers[i]);
                Res = operation.doCalculation();
                numbers[i] = Res;
                for (int j = i; j < countOpers - 1; j++) {
                    opers[j] = opers[j + 1];
                }
                countOpers--;
                for (int j = i + 1; j < count - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                count--;
            }
        }
        if (countOpers == 0 && count == 1) {
            Res = numbers[0];
        }
        return Res;
    }
}
