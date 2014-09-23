/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK014 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double y = 0;
        for (int i = 1; i <= n; i++) {
            y = Math.cos((x + y));
        }
        System.out.println(y);
    }

}
