import java.util.Scanner;

/**
 * Created by BirthrightL on 11.10.2014.
 */
public class TASK030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l;
        int even = 0;
        int odd = 0;
        boolean q = false;
        for (int i = 0; even <= 2 && odd <= 2 && i < n; i++) {
            int a = sc.nextInt();
            if ((a >= 100 && a <= 999) || (a >= 10000 && a < 99999) || (a <= -100 && a >= -999) || (a <= -10000 && a >= -99999)) {
                int j = 0;
                int h = 0;
                int g = 0;
                while (a > 0 || a < 0) {
                    l = a % 10;
                    a = a / 10;
                    j++;
                    if (l % 2 == 0) {
                        g++;
                    } else {
                        h++;
                    }
                }
                if (j == g) {
                    even++;
                } else {
                    if (j == h) {
                        odd++;
                    }
                }
            }
            System.out.println(even);
            if (even == 2 || odd == 2) {
                q = true;
            }

        }
        System.out.println(q);
    }
}











