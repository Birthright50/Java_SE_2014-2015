import java.util.Scanner;

/**
 * Created by BirthrightL on 18.10.2014.
 */
public class TASK036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
           for(int j = 0;(a[i]>a[j])&& j<n; j++){
               if(a[i]>a[j]){
                   System.out.print(a[j]+" ");
               }
            }
            System.out.println();
        }
    }
}
