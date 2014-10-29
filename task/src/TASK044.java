import java.util.Scanner;

/**
 * Created by BirthrightL on 28.10.2014.
 */
public class TASK044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String abs = sc.nextLine();
        boolean q = true;
        String[] a = abs.split(" ");
        for (String x : a) {
            char b = x.charAt(0);
            String n = Character.toString(b);
            String c = n.toUpperCase();
            if (n.equals(c)) {
                for (int i = 1; q && i < x.length(); i++) {
                    b = x.charAt(i);
                    n = Character.toString(b);
                    c = n.toLowerCase();
                    q = n.equals(c);
                }
            } else {
                q = false;
            }
            if (q) {
                System.out.println(x);
            }
        }
    }
}
