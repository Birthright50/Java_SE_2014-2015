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
        Elem e = p.getHead();
        while (e != null && e.getValue() % 2 != 0) {
            e = e.getNext();
        }
        if (e != null) {
            p.setHead(e);
        } else {
            p.setHead(null);
            System.out.println("Список пуст");
            return;
        }
        while (e != null) {
            if (e.getNext() == null || (e.getNext()).getValue() % 2 == 0) {
                e = e.getNext();
                continue;
            }
            e.setNext(e.getNext().getNext());
        }
        e = p.getHead();
        while (e != null) {
            System.out.print(e.getValue() + " ");
            e = e.getNext();
        }
    }
}