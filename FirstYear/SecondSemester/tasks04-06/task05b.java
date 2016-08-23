import java.util.Scanner;

/**
 * Created by Birthright on 09.02.2015.
 */
public class task05b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Elem head;
        Elem p = new Elem(0.5, null);
        head = p;
        p = new Elem(sc.nextInt(), head);
        head = p;
        int mult = 1;
        for (int i = 2; i <= n; i++) {
            p = new Elem(sc.nextInt(), head);
            head = p;
        }
        p = head;
        while (p != null && p.getValueDouble() != 0.5) {
            mult *= p.getValue();
            p = p.getNext();
            p = p.getNext();
        }
        System.out.println(mult);
    }
}

