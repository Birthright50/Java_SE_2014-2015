/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK009 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ввод х");
        double x = sc.nextDouble();
        double y = 0;
        if (x > 2) {
            y = (x * x - 1) / (x + 2);
        } else {
            if (x > 0) {
                y = (x * x - 1) * (x + 2);
            } else {
                y = x * x * (1 + 2 * x);
            }
        }
        System.out.println(y);
    }
}
