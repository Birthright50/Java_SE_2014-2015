import java.util.Scanner;

/**
 * Created by Birthright on 02.05.2015.
 */
public class Task24b {
    public static boolean good(Integer m, Integer k) {
        int sum = 0;
        int x = m;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum < k;

    }

    public static void backTracking(Integer number, int length, int k, int m) {
        if (length == m) {
            System.out.println(number);
        } else {
            if (number.equals(0)) {
                for (int i = 1; i <= 9; i++) {
                    number = i;
                    backTracking(number, 1, k, m);
                }
            } else {
                for (int i = 0; i <= 9; i++) {
                    Integer x = number * 10 + i;
                    if (good(x, k)) {
                        backTracking(x, length + 1, k, m);
                    } else {
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("×èñëî");
        int k = sc.nextInt();
        System.out.println("Êîë-âî öèôğ");
        int m = sc.nextInt();
        backTracking(0, 0, k, m);
    }
}
