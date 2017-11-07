package lab2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int first = Integer.parseInt(in.nextLine());
        System.out.println("Введите второе число:");
        int second = Integer.parseInt(in.nextLine());
        System.out.println("Выберите операцию над числами (+, -, *, /): ");
        char operation = in.nextLine().charAt(0);
        if (operation == '+') {
            System.out.println(first + second);
        }
        if (operation == '-') {
            System.out.println(first - second);
        }
        if (operation == '*') {
            System.out.println(first * second);
        }
        if (operation == '/') {
            System.out.println(first / second);
        }
    }
}
