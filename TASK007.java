/**
 * Created by BirthrightL on 13.09.2014.
 */

import java.util.Scanner;

public class TASK007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 5;
        int b = 7;
        double c = a + b;
        double d = a - b;
        double e = b - a;
        double f = a * b;
        double g = a / b;
        double h = a % b;
        double i = b / a;
        double j = b % a;
        System.out.println("a+b = " + c);
        System.out.println("a-b=" + d);
        System.out.println("b-a=" + e);
        System.out.println("a*b=" + f);
        System.out.println("a/b=" + g);
        System.out.println("a%b=" + h);
        System.out.println("b/a=" + i);
        System.out.println("b%a=" + j);
    }
}
