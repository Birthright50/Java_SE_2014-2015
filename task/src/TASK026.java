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
        double s = 0;
        double z = 1;
        if (x == 1)
            System.out.println(s);
        else {
            for (int i = 2; Math.abs(z) > EPS; i++) {
                s = s + numerator / denominator;
                z = numerator / denominator;
                numerator = numerator * (x - 1);
                denominator = denominator * 3 * (i * i + 3) * 2 / ((i - 1) * (i - 1) + 3);

            }
            System.out.println(s);
        }
    }
}