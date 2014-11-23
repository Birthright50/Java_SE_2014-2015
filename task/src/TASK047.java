import java.util.Scanner;

/**
 * Created by BirthrightL on 02.11.2014.
 */
public class TASK047 {
    public static void multTable(int k) {
        for (int i = 1; i < 11; i++) {
            String l = i + " x " + k + " = " + (i * k);
            System.out.println(l);
        }
    }

    public static void infSum(int x) {
        final double EPS = 1e-9;
        double denominator = 9 * (x - 1) * (x - 1);
        double s = 1 / denominator;
        double z = 1;
        if (x == 1)
            System.out.println("Infinity");
        else {
            for (int i = 2; z > EPS; i++) {
                denominator = denominator * i * 9 * (x - 1) * (x - 1) / (i - 1);
                z = 1 / denominator;
                s = s + z;
            }
            System.out.println(s);
        }
    }

    public static int scalarProduct(int[] a, int[] b) {
        int scal = 0;
        for (int i = 0; i < a.length; i++) {
            scal += (a[i] * b[i]);
        }
        return scal;
    }

    public static double cos(int[] a, int[] b) {
        double vect1 = 0;
        double vect2 = 0;
        for (int i = 0; i < a.length; i++) {
            vect1 += (a[i] * a[i]);
            vect2 += (b[i] * b[i]);
        }
        vect1 = Math.pow(vect1, 0.5);
        vect2 = Math.pow(vect2, 0.5);
        double cos = scalarProduct(a, b) / (vect1 * vect2);
        return cos;
    }

    public static double[][] gauss(double[][] m, int z) {
        for (int i = 0; i < z - 1; i++) {
            for (int j = 0; j < z - i - 1; j++) {
                double l = m[j + i + 1][i] / m[i][i];
                for (int g = 0; g < z - i; g++) {
                    m[j + i + 1][g + i] = m[j + i + 1][g + i] - l * m[i][g + i];
                }
            }
        }
        return m;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод k (task008)");
        int k = scanner.nextInt();
        multTable(k);


        System.out.println("Ввод х (task024)");
        int x = scanner.nextInt();
        infSum(x);


        System.out.println("Ввод n (task033)");
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        System.out.println("Ввод элементов первого массива (task033)");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("Ввод элементов второго массива (task033)");
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        int q = scalarProduct(a, b);
        System.out.println("Скалярное произведение = " + q);
        double l = cos(a, b);
        System.out.println("Косинус = " + l);

        System.out.println("Ввод n (task038)");
        int z = scanner.nextInt();
        System.out.println("Ввод элементов квадратной матрицы (task038)");
        double[][] m = new double[z][z];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < z; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }
        m = gauss(m, z);
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < z; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
