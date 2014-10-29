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
        if (a.compareToIgnoreCase(b) > 0) {
            System.out.println("Вторая");
        } else {
            if (a.compareToIgnoreCase(b) < 0) {
                System.out.println("Первая");
            } else {
                System.out.println("Одинаковые строки");
            }
        }
    }
}

