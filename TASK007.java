/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK007 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ввод a");
        int a = scanner.nextInt();
        System.out.println("ввод b");
        int b = scanner.nextInt();
        System.out.println("a + b =" + (a + b));
        System.out.println("a - b =" + (a - b));
        System.out.println("b - a =" + (b - a));
        System.out.println("a * b =" + (a * b));
        System.out.println("a / b =" + (a / b));
        System.out.println("a % b =" + (a % b));
        System.out.println("b / a =" + (b / a));
        System.out.println("b % a =" + (b % a));
    }

}