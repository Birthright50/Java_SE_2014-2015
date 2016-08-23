import java.util.Scanner;

/**
 * Created by BirthrightL on 10.10.2014.
 */
public class TASK027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean b = false;
        for (int i = 0; !b && i < n; i++) {
            int a = sc.nextInt();
            if ((a % 2 == 0 && a % 3 == 0) || (a % 5 == 0 && a % 6 == 0)) {
                b = true;
            }
        }
        System.out.println(b);
    }
}
