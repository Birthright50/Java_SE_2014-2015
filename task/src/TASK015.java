/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double s = n + x;
        for (int i = n - 1; i >= 1; i--) {
            s = 1 / s;
            s = i + x * s;
        }
        System.out.println(s);
    }

}
