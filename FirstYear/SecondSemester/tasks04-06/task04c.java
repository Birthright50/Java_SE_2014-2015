import java.util.Scanner;

/**
 * Created by Birthright on 09.02.2015.
 */
public class task04c {
    public static void main(String[] args) {
        Elem head = null;
        Elem p;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p = new Elem(sc.nextInt(), head);
            head = p;
        }
        p = head;
        boolean q = false;
        while (p != null && !q) {
            if (p.getValue() == 0) {
                q = true;
            }
            p = p.getNext();
        }
        System.out.println(q);
    }
}
