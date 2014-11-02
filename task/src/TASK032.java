import java.util.Scanner;

/**
 * Created by BirthrightL on 11.10.2014.
 */
public class TASK032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] a = new int[q];
        int j = sc.nextInt();
        int[] b = new int[j];
        for (int i = 0; i < q; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < j; i++) {
            b[i] = sc.nextInt();
        }
        if (q >= j) {
            for (int i = 0; i < j; i++) {
                a[i + q - j] = a[i + q - j] + b[i];
            }
            for (int i = 0; i < q; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            for (int i = 0; i < q; i++) {
                b[i + j - q] = b[i + j - q] + a[i];
            }
            for (int i = 0; i < j; i++) {
                System.out.print(b[i] + " ");


            }
        }
    }
}




