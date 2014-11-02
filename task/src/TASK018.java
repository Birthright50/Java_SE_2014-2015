import java.util.Scanner;

/**
 * Created by BirthrightL on 23.09.2014.
 */
public class TASK018 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double l = x;
        double sum = 0;
        for (int i = 1; i < n; i++) {
            x = x * l;
        }
        System.out.println(x);
        for (int i = n; i >= 0; i--) {
            double a = sc.nextDouble();
            sum = sum + a * x;
            x = x / l;
            if (x < 1) {
                x = 1;
            }
        }
        System.out.println(sum);
    }
}
