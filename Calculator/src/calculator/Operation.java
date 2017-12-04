package calculator;

/**
 *
 * @author Admin
 */
public class Operation {

    double operand1;
    double operand2;
    double result;

    enum Operations {
        DIF, SUM, QUO, PRO
    };
    Operations operations;

    public Operation(double operand1, double operand2, char operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        if (operation == '+') {
            operations = Operations.SUM;
        }
        if (operation == '-') {
            operations = Operations.DIF;
        }
        if (operation == '*') {
            operations = Operations.PRO;
        }
        if (operation == '/') {
            operations = Operations.QUO;
        }
    }

    public double doCalculation() {
        switch (operations) {
            case SUM:
                result = operand1 + operand2;
                break;
            case DIF:
                result = operand1 - operand2;
                break;
            case QUO:
                result = operand1 / operand2;
                break;
            case PRO:
                result = operand1 * operand2;
                break;
            default:
                break;
        }
        return result;
    }

}
