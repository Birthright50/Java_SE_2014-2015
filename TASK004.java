/**
 * Created by BirthrightL on 13.09.2014.
 */

import java.util.Scanner;

public class TASK004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = 5;
        double y = 6.3;
        double z = ((1 + y) * (2 * x + Math.pow(y, 2) - (x + y)) / (y + 1) / Math.pow(x, 2) - 4);
        System.out.println(z);
    }


}
