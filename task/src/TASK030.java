import java.util.Scanner;

/**
 * Created by BirthrightL on 11.10.2014.
 */
public class TASK030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод размера массива");
        int n = sc.nextInt();
        System.out.println("Ввод элементов массива");
        int[] a = new int[n];
        int l;
        int chet = 0;
        int nechet = 0;
        boolean q = true;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if ((a[i] >= 100 && a[i] <= 999) | (a[i] >= 10000 && a[i] < 99999) | (a[i] <= -100 && a[i] >= -999) | (a[i] <= -10000 && a[i] >= -99999)) {
                int j = 0;
                int h = 0;
                int g = 0;
                while (a[i] > 0) {
                    l = a[i] % 10;
                    a[i] = a[i] / 10;
                    j++;
                    if (l % 2 == 0) {
                        g++;
                    } else {
                        h++;
                    }
                }
                if (j == g ) {
                    chet++;
                }
                if (j == h) {
                    nechet++;
                }
            }
        }
        if ((chet < 2 && chet > 2) | (nechet <2 && nechet >2)) {
            q = false;
        }
        System.out.println(q);
    }
}











