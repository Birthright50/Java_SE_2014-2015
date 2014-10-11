import java.util.Scanner;

/**
 * Created by BirthrightL on 10.10.2014.
 */
public class TASK028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод k");
        int k = sc.nextInt();
        System.out.println("Ввод m");
        int m = sc.nextInt();
        int b;
        int n = 0;
        int g;
        if (k > m) {
            b = k - m - 1;
            g = m;
            while (n < b) {
                g = g + 1;
                n++;
                if (g % 3 == 0) {
                    System.out.println(g);
                }
            }
        } else {
            b = m - k - 1;
            g = k;
            while (n < b) {
                g = g + 1;
                n++;
                if (g % 3 == 0) {
                    System.out.println(g);

                }
            }


        }
    }
}
