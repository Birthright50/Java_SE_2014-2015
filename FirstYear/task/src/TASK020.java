/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK020 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ввод n");
        int n = sc.nextInt();
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n - i + 1; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * i - 1; j++)
                System.out.print("0");
            for (int j = 1; j <= n - i + 1; j++)
                System.out.print("*");
            System.out.println();
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            for (int j = 1; j <= 2 * n + 1 - 2 * i; j++)
                System.out.print("0");
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}


