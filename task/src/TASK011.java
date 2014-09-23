/**
 * Created by BirthrightL on 23.09.2014.
 */
import java.util.Scanner;

public class TASK011 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ввод n");
        int n = sc.nextInt();
        int x = 1;
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                x = x * i * 2;
            }
        } else {
            int i = 1;
            while (i <= n) {
                x = x * i;
                i = i + 2;
            }
        }
        System.out.println(x);
    }
}
