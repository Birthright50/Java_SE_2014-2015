import java.util.Scanner;

/**
 * Created by BirthrightL on 18.10.2014.
 */
public class TASK034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]a=new int[n];

        for (int i = 0; i<n; i++){
            a[i]=sc.nextInt();
        }
        int sum = a[0]+a[1]+a[2];
        for (int i = 1; i<n-2; i++){
            if(a[i]+a[i+1]+a[i+2]>sum){
                sum=a[i]+a[i+1]+a[i+2];
            }
        }
        System.out.println(sum);

    }
}
