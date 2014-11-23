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
            int[] c = new int[q + 1];
            int k = 0;
            for (int i = q - 1; j > 0; i--, j--) {
                int m = a[i] + b[j - 1] + k;
                if (m > 9) {
                    k = 1;
                    c[i + 1] = m % 10;
                } else {
                    k = 0;
                    c[i + 1] = m;
                }
            }
            if (a.length == b.length) {
                c[0] = k;
                if (c[0] > 0) {
                    for (int i = 0; i < c.length; i++) {
                        System.out.print(c[i] + " ");
                    }
                    return;
                } else {
                    for (int i = 1; i < c.length; i++) {
                        System.out.print(c[i] + " ");
                    }
                    return;
                }

            } else {
                c[a.length - b.length - 1] = k;
                for (int i = a.length - b.length - 2; i >= 0; i--) {
                    c[i + 1] = a[i];
                }
            }
            if (c[0] > 0) {
                for (int i = 0; i < c.length; i++) {
                    System.out.print(c[i] + " ");
                }
                return;
            } else {
                for (int i = 1; i < c.length; i++) {
                    System.out.print(c[i] + " ");
                }
                return;
            }

        } else {
            int[] c = new int[j + 1];
            int k = 0;
            for (int i = j - 1; q > 0; i--, q--) {
                int m = a[q - 1] + b[i] + k;
                if (m > 9) {
                    k = 1;
                    c[i + 1] = m % 10;

                } else {
                    k = 0;
                    c[i + 1] = m;

                }
            }

            c[b.length - a.length-1] = k + b[b.length - a.length - 1];
            for (int i = b.length - a.length - 2; i >= 0; i--) {
                c[i + 1] = b[i];
            }
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i] + " ");
            }

        }
    }
}




