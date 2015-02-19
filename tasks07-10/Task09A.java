import java.util.Scanner;

/**
 * Created by Birthright on 19.02.2015.
 */
public class Task09A {
    public static boolean checkPrimeNumber(int g) {
        if (g == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(g); i++) {
            if (g % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int theFirstDigit(int g) {
        while (g > 10) {
            g = g / 10;
        }
        return g;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CorrectList p = new CorrectList();
        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }
        CorrectList h = p.getHead();
        p = h;
        CorrectList a;
        int k, g;
        if (checkPrimeNumber(p.getValue())) {
            g = p.getValue() % 10;
            k = theFirstDigit(p.getValue());
            CorrectList p1 = new CorrectList();
            p1.setValue(g);
            p1.setNext(p.getNext());
            p.setNext(p1);
            a = p;
            p = new CorrectList();
            p.setNext(a);
            p.setValue(k);
            p.setHead(p);
            h = p.getHead();
            p = (CorrectList) p.getNext().getNext();
        }
        while (p.getNext() != null) {
            if (checkPrimeNumber(p.getNext().getValue())) {
                g = p.getNext().getValue() % 10;
                k = theFirstDigit(p.getNext().getValue());
                CorrectList c1 = new CorrectList();
                CorrectList c2 = new CorrectList();
                c1.setValue(k);
                c2.setValue(g);
                c2.setNext(p.getNext().getNext());
                p.getNext().setNext(c2);
                c1.setNext(p.getNext());
                p.setNext(c1);
                p = (CorrectList) ((p.getNext()).getNext()).getNext();
            } else {
                p = (CorrectList) p.getNext();
            }
        }
        p = h;
        while (p != null) {
            System.out.print(p.getValue() + " ");
            p = (CorrectList) p.getNext();
        }
    }
}
