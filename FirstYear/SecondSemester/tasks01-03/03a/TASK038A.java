import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK038A {

    static Scanner sc = new Scanner(System.in);

    public static double[][] scanner2(double[][] a, int i, int j, int n) {
        if (j == n) {
            return a;
        }
        a[i][j] = sc.nextDouble();
        return scanner2(a, i, j + 1, n);
    }

    public static double[][] scanner1(double[][] a, int i, int j, int n) {
        if (i == n) {
            return a;
        }
        a = scanner2(a, i, j, n);
        return scanner1(a, i + 1, j, n);
    }

    public static void toString2(double[][] a, int i, int j, int n) {
        if (j == n) {
            return;
        }
        System.out.print(a[i][j] + " ");
        toString2(a, i, j + 1, n);
    }

    public static void toString1(double[][] a, int i, int j, int n) {
        if (i == n) {
            return;
        }
        toString2(a, i, j, n);
        System.out.println();
        toString1(a, i + 1, j, n);
    }

    public static double[][] gauss3(double[][] a, int n, int i, int j, int g, double m) {
        if (g == n - i) {
            return a;
        }
        a[j + i + 1][g + i] = a[j + i + 1][g + i] - m * a[i][g + i];
        return gauss3(a, n, i, j, g + 1, m);
    }

    public static double[][] gauss2(double[][] a, int n, int i, int j, int g) {
        if (j == n - i - 1) {
            return a;
        }
        double m = a[j + i + 1][i] / a[i][i];
        a = gauss3(a, n, i, j, g, m);
        return gauss2(a, n, i, j + 1, g);

    }

    public static double[][] gauss1(double[][] a, int n, int i, int j, int g) {
        if (i == (n - 1)) {
            return a;
        }
        a = gauss2(a, n, i, j, g);
        return gauss1(a, n, i + 1, j, g);
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        double[][] a = new double[n][n];
        int i = 0;
        int j = 0;
        int g = 0;
        a = scanner1(a, i, j, n);
        a = gauss1(a, n, i, j, g);
        toString1(a, i, j, n);
    }
}
