import java.util.Scanner;

/**
 * Created by BirthrightL on 11.10.2014.
 */
public class TASK032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод кол-во элементов первого массива");
        int q = sc.nextInt();
        int[] a = new int[q];
        System.out.println("Ввод кол-во элементов второго массива");
        int j = sc.nextInt();
        int[] b = new int[j];
        System.out.println("Ввод элементов первого массива");
        String str = "";
        for (int i = 0; i < q; i++) {
            a[i] = sc.nextInt();
            String str1 = Integer.toString(a[i]);
            str = str + str1;
        }
        long m = Long.parseLong(str);
        System.out.println("m="+m);

        str = "";
        System.out.println("Ввод элементов второго массива");
        for (int i = 0; i < j; i++) {
            b[i] = sc.nextInt();
            String str1 = Integer.toString(b[i]);
            str = str + str1;
        }
        long n = Long.parseLong(str);
        System.out.println("n="+n);
        System.out.println("m+n="+(m + n));
    }


}











