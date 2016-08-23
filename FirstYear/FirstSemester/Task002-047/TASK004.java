/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK004 {
    public static void main(String[] args) {
        double x = 3;
        double y = 1;
        double z = 0.0;
        double v = 0.0;
        double s = 0.0;
        z = x * x - 4;
        z = 1 / z;
        v = y + z;
        s = x + y;
        s = s / v;
        z = 2 * x;
        v = y * y;
        z = z + v;
        z = z - s;
        s = 1 + y;
        v = z * s;


        System.out.println(v);
    }


}

