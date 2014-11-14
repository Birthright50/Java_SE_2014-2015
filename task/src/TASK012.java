/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double s = 0;
        double k;
        int h = 1;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++, h *= -1) {
            k = 1.0 / ((i * 2 - 1) * (i * 2 - 1));
            k *= h;
            s += k;
        }
        System.out.println(s);
    }
}