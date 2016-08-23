import java.util.Scanner;

/**
 * Created by Birthright on 06.02.2015.
 */
public class TASK008C {


    public static String multTable(int n, int k) {
        System.out.println(n + " x " + k + " = " + n * k);
        if (n == 10) {
            return 10 + " x " + k + " = " + 10 * k;
        }
        return multTable(n + 1, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        multTable(1, k);
    }
}
