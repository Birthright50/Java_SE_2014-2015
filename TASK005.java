/**
 * Created by BirthrightL on 13.09.2014.
 */

import java.util.Scanner;

public class TASK005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = 5.2;
        double y = -7.99;
        double z = 6.93;
        x = x + 2;
        x = x * y;
        x = x - z;
        x = x / y;
        y = y * z;
        x = x * y;
        System.out.println(x);

    }
}
