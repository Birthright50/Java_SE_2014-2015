import java.util.Scanner;

/**
 * Created by BirthrightL on 23.09.2014.
 */

public class TASK022 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i * i + j * j <= n * n) {
                    System.out.print("0");
                } else {
                    System.out.print("*");
                }
                if (j == 1) {
                    System.out.print("0");
                }
            }
            for (int j = 1; j <= n; j++) {
                if (i * i + j * j <= n * n) {
                    System.out.print("0");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= 2 * n + 1; i++) {
            System.out.print("0");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (i * i + j * j <= n * n) {
                    System.out.print("0");
                } else {
                    System.out.print("*");
                }
                if (j == 1) {
                    System.out.print("0");
                }
            }
            for (int j = 1; j <= n; j++) {
                if (i * i + j * j <= n * n) {
                    System.out.print("0");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}