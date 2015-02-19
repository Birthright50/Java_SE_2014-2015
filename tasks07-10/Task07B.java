import java.util.Scanner;

/**
 * Created by Birthright on 19.02.2015.
 */
public class Task07B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CorrectList p = new CorrectList();
        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }
        CorrectList h = p.getHead();
        p = p.getHead();

        while (p.getValue() % 2 != 0) {
            p = (CorrectList) p.getNext();
            p.setHead(p);
            h = p.getHead();
        }

        while (p != null) {
            if (p.getNext() == null || (p.getNext()).getValue() % 2 == 0) {
                p = (CorrectList) p.getNext();
                continue;
            }
            p.setNext(p.getNext().getNext());
        }
        p = h;
        while (p != null) {
            System.out.print(p.getValue() + " ");
            p = (CorrectList) p.getNext();
        }
    }
}
