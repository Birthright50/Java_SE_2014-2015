import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK035A {
    public static void toString(int n, int[] a, int i) {
        if (i == n) {
            return;
        }
        System.out.print(a[i] + " ");
        toString(n, a, i + 1);
    }

    public static int sort1(int[] a, int j, int n, int min_i, int min) {
        if (j == n) {
            return min_i;
        }
        if (a[j] < min) {
            min = a[j];
            min_i = j;
        }
        return sort1(a, j + 1, n, min_i, min);
    }

    public static int[] sort(int n, int[] a, int i) {
        if (i == n) {
            return a;
        }
        int min = a[i];
        int min_i = i;
        int j = i + 1;
        min_i = sort1(a, j, n, min_i, min);
        if (i != min_i) {
            int b = a[i];
            a[i] = a[min_i];
            a[min_i] = b;
        }
        return sort(n, a, i + 1);
    }

    public static int[] massive(int n, int[] a, int i) {
        if (n == i) {
            return a;
        }
        a[i] = sc.nextInt();
        return massive(n, a, i + 1);
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int i = 0;
        a = massive(n, a, i);
        sort(n, a, i);
        toString(n, a, i);


    }
}
