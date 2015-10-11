import java.util.Scanner;

/**
 * Created by Birthright on 10.02.2015.
 */
public class task05a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int localMin = 0;
        int localMax = 0;
        int n = sc.nextInt();
        Elem p = new Elem(sc.nextInt(), null);
        Elem g = p;
        Elem head = p;
        for (int i = 2; i <= n; i++) {
            p = new Elem(sc.nextInt(), head);
            head = p;
        }
        p = head;
        Elem previous;
        Elem next = null;
        while (next != g) {
            previous = p;
            p = p.getNext();
            next = p.getNext();
            if (p.getValue() < previous.getValue() && p.getValue() < next.getValue()) {
                localMin++;
            }
            if (p.getValue() > previous.getValue() && p.getValue() > next.getValue()) {
                localMax++;
            }
        }
        System.out.println("Local minimum = " + localMin + ", Local maximum = " + localMax);
    }
}
