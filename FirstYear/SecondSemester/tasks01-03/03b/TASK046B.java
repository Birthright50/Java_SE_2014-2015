import java.util.Scanner;

/**
 * Created by Birthright on 07.02.2015.
 */
public class TASK046B {
    public static void check(int i, String a, String b, int l) {
        if (i == l) {
            if (a.length() - b.length() < 0) {
                System.out.println("1-я строка лексикографически раньше");
            } else {
                System.out.println("2-я строка лексикографически раньше");
            }
            return;
        }
        if (a.charAt(i) != b.charAt(i)) {
            if ((int) a.charAt(i) < (int) b.charAt(i)) {
                System.out.println("1-я строка лексикографически раньше");
                return;
            } else {
                System.out.println("2-я строка лексикографически раньше");
                return;
            }
        }
        check(i + 1, a, b, l);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int i = 0;
        int l = Math.min(a.length(), b.length());
        check(i, a, b, l);
    }
}
