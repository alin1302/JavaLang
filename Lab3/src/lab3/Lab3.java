package lab3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab3 {

    int factorial(int i) {
        int result;
        if (i == 1) {
            return 1;
        }

        result = i * factorial(i - 1);
        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        int i = Integer.parseInt(in.nextLine());
        Lab3 arg = new Lab3();
        System.out.println(arg.factorial(i));
    }

}
