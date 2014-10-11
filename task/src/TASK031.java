import java.util.Scanner;

/**
 * Created by BirthrightL on 11.10.2014.
 */
public class TASK031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод размера массива");
        int n = sc.nextInt();
        System.out.println("Ввод элементов массива");
        int[] a = new int[n];
        boolean q = true;
        int s = 0;
        int p = 1;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }
        for (int i = 2; q && i < n; i = i + 3) {
            if (a[i] % 3 != 0) {
                q = false;
            }
        }
        if (q) {
            for (int i = 0; i < n; i++) {
                if (a[i] > 0) {
                    s = s + a[i];
                }
            }
            System.out.println(s);
        } else {
            for (int i = 0; i < n; i++) {
                if (a[i] > 0) {
                    p = p * a[i];
                }

            }
            System.out.println(p);
        }
    }
}


