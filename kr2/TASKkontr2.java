import java.util.Scanner;

/**
 * Created by Birthright on 06.11.2014.
 */
public class TASKkontr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int s = 0;
        for (int j = n - 1; j >= 0; j = j - 2) {
            for (int i = 0; i < n; i++, s++) {
                a[i][j] = s;
            }
            s = s + n;
        }
        s = n;
        for (int j = n - 2; j >= 0; j = j - 2) {
            for (int i = n - 1; i >= 0; i--, s++) {
                a[i][j] = s;
            }
            s = s + n;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
