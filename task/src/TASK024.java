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
        double numerator = 1;
        double denominator = 9 * (x - 1) * (x - 1);
        double s = 0;
        double z=1;
        double b;
        if (x==1)
            System.out.println("Infinity");
        else {
        for (int i = 2; z > EPS; i++) {
            s = s + numerator / denominator;
            z = numerator / denominator;
            b = i * 9;
            denominator = denominator * b * (x - 1) * (x - 1) / (i - 1);
               }
        System.out.println(s); }

    }
}