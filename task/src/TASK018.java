import java.util.Scanner;

/**
 * Created by BirthrightL on 23.09.2014.
 */
public class TASK018 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ввод х");
        double x = sc.nextDouble();
        System.out.println("Ввод n");
        int n = sc.nextInt();
        double sum = 0;
        System.out.println("Ввод a (Кол-во a=n+1)");
        double a[] = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = sc.nextDouble();
            sum = sum + a[i] * Math.pow(x, i);
        }
        System.out.println(sum);

    }

}
