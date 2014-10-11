import java.util.Scanner;

/**
 * Created by BirthrightL on 10.10.2014.
 */
public class TASK029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод k ∈ [2; 9)");
        int k = sc.nextInt();
        if (k >= 2 && k <= 9) {
            int n = sc.nextInt();
            int b;
            int g = 0;
            int s = n % 10;
            n = n / 10;
            if (s < k) {
                while (g < k & n > 0) {
                    g = n % 10;
                    n = n / 10;
                    if (g > k) {
                        System.out.println("n не может находится в k-ичной системе счисления");
                        return;
                    } else {
                        b = g * k;
                        s = s + b;
                        k = k * k;
                    }
                }
            }
            System.out.println(s);
        }
    }
}

