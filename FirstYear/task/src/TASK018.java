import java.util.Scanner;

/**
 * Created by BirthrightL on 23.09.2014.
 */
public class TASK018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double a;
        double s = 0.0;
        for (int i = 0; i <= n; i++) {
            a = sc.nextDouble();
            s = s * x + a;
        }
        System.out.println(s);
    }
}
