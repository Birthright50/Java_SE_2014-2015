import java.util.Scanner;

/**
 * Created by BirthrightL on 10.10.2014.
 */
public class TASK027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ввод размера массива");
        int n = sc.nextInt();
        System.out.println("Ввод элементов массива");
        int[] a = new int[n];
        boolean b = false;
        for (int i = 0 ;!b && i<n; i++){
            a[i]=sc.nextInt();
            if ((a[i]%2==0 & a[i]%3==0) | (a[i]%5==0 & a[i]%6==0) ) {
                b=true;
            }
        }
        System.out.println(b);
    }
}
