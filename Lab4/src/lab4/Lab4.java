package lab4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        String first = in.nextLine();
        char[] result = first.toCharArray();
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }
}