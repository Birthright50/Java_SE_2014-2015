import java.util.Scanner;

/**
 * Created by Birthright on 19.02.2015.
 */
public class Task08B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CorrectList p = new CorrectList();
        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }
        Elem e = p.getHead();
        if (e.getValue() % 2 == 0) {
            Elem s = new Elem(100, p.getHead());
            p.setHead(s);
        }
        while (e.getNext() != null) {
            if ((e.getNext()).getValue() % 2 == 0) {
                Elem s = new Elem(100, e.getNext());
                e.setNext(s);
                e = e.getNext().getNext();
            } else {
                e = e.getNext();
            }
        }
        e = p.getHead();
        while (e != null) {
            System.out.print(e.getValue() + " ");
            e = e.getNext();
        }
    }
}

