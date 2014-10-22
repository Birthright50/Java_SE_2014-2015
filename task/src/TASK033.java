import java.util.Scanner;

/**
 * Created by BirthrightL on 18.10.2014.
 */
public class TASK033 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        int scal = 0;
        double vect1 = 0;
        double vect2 = 0;
        for (int i = 0; i < n; i++) {
            scal = scal + a[i] * b[i];
            vect1 = vect1 + a[i] * a[i];
            vect2 = vect2 + b[i] * b[i];
        }

        vect1 = Math.pow(vect1, 0.5);
        vect2 = Math.pow(vect2, 0.5);
        double cos = scal / (vect1 * vect2);
        System.out.println("Скалярное произведение = " + scal + ", Косинус = " + cos);
    }
}
