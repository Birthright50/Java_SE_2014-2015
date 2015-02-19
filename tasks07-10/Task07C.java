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
        CorrectList h = p.getHead();
        p = h;
        for (int i = 0; i < n - 4; i++) {
            p = (CorrectList) p.getNext();
        }
        p.setNext(null);
        p = h;
        while (p != null) {
            System.out.print(p.getValue() + " ");
            p = (CorrectList) p.getNext();
        }

    }
}
