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
        double denominator = 4;
        double den1 = 3;
        double s = numerator / (denominator * den1);
        double z = 1;
        if (x == 1)
            System.out.println(0);
        else {
            for (int i = 2; Math.abs(z) > EPS; i++) {
                numerator *= (x - 1);
                den1 *= (3 * i);
                denominator = (den1 * (i * i + 3));
                z = numerator / denominator;
                s = s + z;
            }
            System.out.println(s);
        }
    }
}