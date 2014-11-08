/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double s = 0.5;
        double fact1 = 1;
        double fact2 = 24;
        for (int i = 2; i <= n; i++) {
            fact1 = fact1 * (i - 1);
            s = s + ((fact1 * fact1) / fact2);
            fact2 = fact2 * (2 * i + 1) * (2 * i + 2);
        }
        System.out.println(s);
    }
}
