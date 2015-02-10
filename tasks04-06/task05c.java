import java.util.Scanner;

/**
 * Created by Birthright on 09.02.2015.
 */
public class task05c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Elem head = null;
        Elem p;
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p = new Elem(sc.nextInt(), head);
            head = p;
        }
        p = head;
        int sum = 0;
        while (p != null) {
            if (p.getValue() % 2 == 0) {
                sum += p.getValue();
            }
            p = p.getNext();
        }
        System.out.println(sum);
    }
}
