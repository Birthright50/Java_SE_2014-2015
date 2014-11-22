import java.util.Scanner;

/**
 * Created by BirthrightL on 10.10.2014.
 */
public class TASK028 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        if (k % 3 != 0) {
            k += 3 - (k % 3);
        } else {
            k += 3;
        }
        while (k < m) {
            System.out.println(k);
            k += 3;
        }
    }
}

