import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK030B {
    static Scanner sc = new Scanner(System.in);

    public static int amount(int a, int j, int h, int g, int unknown) {
        if ((a == 0 && j == h) || (a == 0 && j == g)) {
            unknown++;
            return unknown;
        }
        if (a == 0) {
            return unknown;
        }
        int l = a % 10;
        a = a / 10;
        j++;
        if (l % 2 == 0) {
            g++;
        } else {
            h++;
        }
        return amount(a, j, h, g, unknown);
    }


    public static boolean check(int n, int unknown) {
        if (unknown == 2 && n == 0) {
            return true;
        }
        if (unknown > 2 || n == 0) {
            return false;
        }
        int a = sc.nextInt();
        if ((a >= 100 && a <= 999) || (a >= 10000 && a < 99999) || (a <= -100 && a >= -999) || (a <= -10000 && a >= -99999)) {
            int j = 0;
            int h = 0;
            int g = 0;
            unknown = amount(a, j, h, g, unknown);


        }
        return check(n - 1, unknown);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int unknown = 0;
        boolean q = check(n, unknown);
        System.out.println(q);
    }
}
