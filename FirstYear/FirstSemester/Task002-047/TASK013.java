/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double r = 1;
        for (int i = 1; i <= n; i++) {
            r = r * 2.0 * i / (2 * i - 1) * 2.0 * i / (2 * i + 1);
        }
        System.out.println(r);
    }
}
