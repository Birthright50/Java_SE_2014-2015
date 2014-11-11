import java.util.Scanner;

/**
 * Created by BirthrightL on 28.09.2014.
 */
public class TASK024 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final double EPS = 1e-9;
        System.out.println("Ввод х");
        double x = sc.nextDouble();
        double denominator = 9 * (x - 1) * (x - 1);
        double s = 1 / denominator;
        double z = 1;
        if (x == 1)
            System.out.println("Infinity");
        else {
            for (int i = 2; z > EPS; i++) {
                denominator = denominator * i * 9 * (x - 1) * (x - 1) / (i - 1);
                z = 1 / denominator;
                s = s + z;
            }
            System.out.println(s);
        }

    }
}