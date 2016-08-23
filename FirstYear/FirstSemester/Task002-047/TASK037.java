import java.util.Scanner;

/**
 * Created by BirthrightL on 18.10.2014.
 */
public class TASK037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int l = n;
        for (int i = 0; i < n / 2; i++, l--) {
            for (int j = 1 + i; j < n - (i + 1); j++) {
                a[i][j] = 0;
                a[l - 1][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
