import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK018B {
    public static double polynomial(int n, double x, double s) {
        if (n == 0) {
            return s;
        }
        s = s * x + sc.nextDouble();
        return polynomial(n - 1, x, s);
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double a = sc.nextDouble();
        double s = a * x;
        a = sc.nextDouble();
        s += a;
        System.out.println(polynomial(n - 1, x, s));

    }
}
