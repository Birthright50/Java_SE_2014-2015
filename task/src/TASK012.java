/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK012 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double s = 0;
        for (double i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                s = s - 1 / ((i * 2 - 1) * (i * 2 - 1));
            } else {
                s = s + 1 / ((i * 2 - 1) * (i * 2 - 1));
            }
        }
        System.out.println(s);
    }

}
