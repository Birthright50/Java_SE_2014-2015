

/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK016 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("ввод n");
        int n = sc.nextInt();
        System.out.println("ввод x");
        double x = sc.nextDouble();
        double s = 0;
        double z = 1;
        for (int i = 1; i <= n; i++) {
            s = s + z * (x + i);
            z = z * (x + i);


        }
        System.out.println(s);

    }
}