/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK015 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double s = 0;
        if (n != 1) {
            s = x;
        }
        for (int i = n; i >= 2; i--) {
            s = x / (i + s);
        }
        s++;
        System.out.println(s);
    }

}
