package calculator;

/**
 *
 * @author Admin
 */
public class calculator {

    String Result;
    char operand;
    double Res;

    public calculator(String ResultOperation, char operand) {
        this.Result = ResultOperation;
        this.operand = operand;
    }

    public static double[] getNumbers(String Result) {
        double[] numbers = new double[2];
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < Result.length(); i++) {
            if (Result.charAt(i) != '+' && Result.charAt(i) != '-' && Result.charAt(i) != '*' && Result.charAt(i) != '/') {
                str.append(Result.charAt(i));
            }
            if (Result.charAt(i) == '+' || Result.charAt(i) == '-' || Result.charAt(i) == '*' || Result.charAt(i) == '/') {
                numbers[count] = Double.parseDouble(str.toString());
                count++;
                str.delete(0, str.length());
            }
        }
        numbers[count] = Double.parseDouble(str.toString());
        return numbers;
    }

    public double ResultFunction() {
        double[] Num = getNumbers(Result);
        try {
            if (operand == '+') {
                Res = Num[0] + Num[1];
            }
            if (operand == '-') {
                Res = Num[0] - Num[1];
            }
            if (operand == '*') {
                Res = Num[0] * Num[1];
            }
            if (operand == '/') {
                Res = Num[0] / Num[1];
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректные данные! Повторите снова");
        }
        return Res;
    }
}
