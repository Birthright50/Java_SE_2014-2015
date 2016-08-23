import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class RecursiveFunction {
    public static double involution(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * involution(x, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double z = involution(x, n);
        System.out.println(z);

    }
}
