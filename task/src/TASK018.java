import java.util.Scanner;

/**
 * Created by BirthrightL on 23.09.2014.
 */
public class TASK018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            double a = sc.nextDouble();
            System.out.println(a);
            return;
        }
        double x = sc.nextDouble();
        double a = sc.nextDouble();
        double s = a * x;
        a = sc.nextDouble();
        s = s + a;
        for (int i = 1; i <= n - 1; i++) {
            a = sc.nextDouble();
            s = s * x + a;
        }
        System.out.println(s);
    }
}
