import java.util.Scanner;

/**
 * Created by BirthrightL on 28.10.2014.
 */
public class TASK044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String abs = sc.nextLine();
        String abs1, abs2;
        String[] a = abs.split(" ");
        for (String x : a) {
            abs1 = x.toLowerCase();
            abs2 = x.toUpperCase();
            int length = x.length();
            if (x.charAt(0) == abs2.charAt(0) && x.substring(1, length).equals(abs1.substring(1, length))) {
                System.out.println(x);
            }
        }
    }
}
