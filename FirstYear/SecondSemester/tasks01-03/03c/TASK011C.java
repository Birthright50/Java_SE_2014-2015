import java.util.Scanner;

/**
 * Created by Birthright on 06.02.2015.
 */
public class TASK011C {
    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fact = fact(n);
        System.out.println(fact);
    }
}
