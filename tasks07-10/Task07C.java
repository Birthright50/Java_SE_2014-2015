import java.util.Scanner;

/**
 * Created by Birthright on 19.02.2015.
 */
public class Task07C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CorrectList p = new CorrectList();
        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }
        Elem a = p.getHead();
        for (int i = 0; i < n - 4; i++) {
            a = a.getNext();
        }
        a.setNext(null);
        a = p.getHead();
        while (a != null) {
            System.out.print(a.getValue() + " ");
            a = a.getNext();
        }
    }
}
