/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;


public class TASK010 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ввод х");
        double x = sc.nextDouble();
        double y = (x > 2) ? (x * x - 1) / (x + 2) : (x > 0) ? (x * x - 1) * (x + 2) : x * x * (1 + x * 2);
        System.out.println(y);

    }
}

