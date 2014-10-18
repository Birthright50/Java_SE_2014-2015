import java.util.Scanner;

/**
 * Created by BirthrightL on 18.10.2014.
 */
public class TASK038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                double m = a[j + i + 1][i] / a[i][i];
                for (int g = 0; g < n - i; g++) {
                    a[j + i + 1][g + i] = a[j + i + 1][g + i] - m * a[i][g + i];
                }
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
