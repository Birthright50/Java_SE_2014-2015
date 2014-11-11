import java.util.Scanner;

/**
 * Created by BirthrightL on 28.09.2014.
 */
public class TASK026 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final double EPS = 1e-9;
        System.out.println("Ввод х");
        double x = sc.nextDouble();
        double numerator = x - 1;
        double denominator = 12;
        double s = numerator / denominator;
        double z = 1;
        if (x == 1)
            System.out.println(s);
        else {
            for (int i = 2; Math.abs(z) > EPS; i++) {
                numerator *= (x - 1);
                denominator = denominator * (3 * i) * (i * i + 3) / ((i - 1) * (i - 1) + 3);
                z = numerator / denominator;
                s = s + z;
            }
            System.out.println(s);
        }
    }
}