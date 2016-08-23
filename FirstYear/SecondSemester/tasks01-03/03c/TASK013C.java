import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK013C {
    public static double wallis(int n) {
        if (n == 1) {
            return 4.0 / 3;
        }
        return wallis(n - 1) * 4.0 * n * n / ((2 * n - 1) * (2 * n + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double r = wallis(n);
        System.out.println(r);
    }
}
