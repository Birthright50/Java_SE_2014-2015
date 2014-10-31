import java.util.Scanner;

/**
 * Created by BirthrightL on 29.10.2014.
 */
public class TASK046 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.equals(b)) {
            System.out.println("Одинаковые строки");
        }
        int c = a.length();
        int d = b.length();
        int min;
        if (c <= d) {
            min = c;
        } else {
            min = d;
        }
        char e[] = a.toCharArray();
        char f[] = b.toCharArray();
        for (int i = 0; i < min; i++) {
            char c1 = e[i];
            char c2 = f[i];
            if (c1 < c2) {
                System.out.println("Первая");
                return;
            }
            if (c1 > c2) {
                System.out.println("Вторая");
                return;
            }
        }
        if (c <= d && a.equals(b.substring(0, min))){
            System.out.println("Первая");
        }
        if (d < c && b.equals(a.substring(0, min))){
            System.out.println("Вторая");
        }


    }
}

