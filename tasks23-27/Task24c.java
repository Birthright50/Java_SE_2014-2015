import java.util.Scanner;

/**
 * Created by Birthright on 01.05.2015.
 */
public class Task24c {
    public static String[] ch = {"e", "y", "u", "i", "o", "a"};

    public static void backTracking(String s, int n) {
        if (s.length() == n) {
            System.out.println(s);
        } else {
            for (int i = 97; i <= 122; i++) {
                String l = s + (char) (i);
                if (good(l)) {
                    backTracking(l, n);
                }

            }

        }
    }

    private static boolean good(String s) {
        String[] l = s.split("");
        int x = 0;
        for (String b : l) {
            for (String a : ch) {
                if (b.contains(a)) {
                    x++;
                    break;
                }
            }
            if (x > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        backTracking("", n);
    }
}
