/**
 * Created by BirthrightL on 13.09.2014.
 */

import java.util.Scanner;

public class TASK006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = 3;
        double y = (Math.pow(x, 5) + 6 * Math.pow(x, 4) + 10 * Math.pow(x, 3) + 25 * Math.pow(x, 2) + 30 * x + 101);
        System.out.println(y);
    }
}
