import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK029B {
    public static int interpretation(int k, int g, int n, int s) throws Exception {
        if (g > k) {
            throw new Exception("n не может находится в k-ичной системе счисления");
        }
        if (n == 0) {
            return s;
        }
        g = n % 10;
        n = n / 10;
        s = s + g * k;
        k = l * k;
        return interpretation(k, g, n, s);
    }

    static Scanner sc = new Scanner(System.in);
    static int l = sc.nextInt();

    public static void main(String[] args) throws Exception {
        int k = l;
        if (k >= 2 && k <= 9) {
            int n = sc.nextInt();
            int g = n % 10;
            int s = g;
            n /= 10;
            System.out.println(interpretation(k, g, n, s));
        }
    }
}
