import java.util.Scanner;

/**
 * Created by Birthright on 06.11.2014.
 */
public class TASKkontr1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int g = 0;
        int q = 0;
        int fact = 1;
        int factA = 1;
        int stepi = 1;
        for (int i = 0; i < n; i++) {
            double b = Math.sqrt(a[i]);
            if (b % 1.0 == 0 && b % 2 != 0) {
                g++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                fact = fact * j;
                stepi = stepi * 2;
            }
            for (int h = 1; h <= a[i]; h++) {
                factA *= h;
            }
            if (stepi - fact - factA <= 0) {
                q++;
            }
            fact = 1;
            factA = 1;
            stepi = 1;
        }
        System.out.println(g);
        System.out.println(q);
    }

}
