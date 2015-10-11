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
        Elem e = p.getHead();
        if (checkPrimeNumber(e.getValue())) {
            int g = e.getValue() % 10;
            int k = theFirstDigit(e.getValue());
            Elem s = new Elem(k, p.getHead());
            Elem a = new Elem(g, e.getNext());
            p.setHead(s);
            e.setNext(a);
            e = e.getNext();
        }
        while (e.getNext() != null) {
            if (checkPrimeNumber(e.getNext().getValue())) {
                int g = e.getNext().getValue() % 10;
                int k = theFirstDigit(e.getNext().getValue());
                Elem a = new Elem(g, e.getNext().getNext());
                e.getNext().setNext(a);
                Elem s = new Elem(k, e.getNext());
                e.setNext(s);
                e = e.getNext().getNext().getNext();
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

