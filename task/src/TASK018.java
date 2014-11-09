import java.util.Scanner;

/**
 * Created by BirthrightL on 23.09.2014.
 */
public class TASK018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x = sc.nextDouble();
        double l = x;
        double sum = 0;
        while (n > 1) {
            x = x * l;
            n--;
        }
        while (x != 1 / l) {
            double a = sc.nextDouble();
            sum = sum + a * x;
            x = x / l;
        }
        System.out.println(sum);
    }
}
