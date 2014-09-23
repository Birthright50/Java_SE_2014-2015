/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK013 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double r = 1;
        for (double i = 1; i <= n; i++) {
            r = r * 2 * i / (2 * i - 1) * 2 * i / (2 * i + 1);
        }
        System.out.println(r);
    }
}
