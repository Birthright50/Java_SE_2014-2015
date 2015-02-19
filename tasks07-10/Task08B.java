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
        CorrectList h = p.getHead();
        p = h;
        if (p.getValue() % 2 == 0) {
            p = new CorrectList();
            p.setValue(100);
            p.setNext(h);
            p.setHead(p);
            h = p.getHead();
            p = (CorrectList) p.getNext();
        }

        while (p.getNext() != null) {
            if ((p.getNext()).getValue() % 2 == 0) {
                CorrectList c = new CorrectList();
                c.setNext(p.getNext());
                p.setNext(c);
                c.setValue(100);
                p = (CorrectList) p.getNext();
                p = (CorrectList) p.getNext();

            } else {
                p = (CorrectList) p.getNext();
            }
        }
        p = h;
        while (p != null) {
            System.out.print(p.getValue() + " ");
            p = (CorrectList) p.getNext();
        }

        Integer.parseInt("11111", 2);

    }
}
