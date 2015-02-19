import java.util.Scanner;

/**
 * Created by Birthright on 19.02.2015.
 */
public class Task10A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CorrectList p = new CorrectList();
        for (int i = 0; i < n; i++) {
            p.add(sc.nextInt());
        }
        p = p.getHead();
        int g = 0;
        for (int i = 0; i < n; i++) {
            g = g * 2 + p.getValue();
            p = (CorrectList) p.getNext();
        }
        CorrectList z = new CorrectList();
        int q = g % 10;
        g /= 10;
        z.setValue(q);
        z.setHead(z);
        z.setLast(z);
        CorrectList h;
        while (g > 0) {
            q = g % 10;
            g /= 10;
            h = z;
            z = new CorrectList();
            z.setValue(q);
            z.setNext(h);
            z.setHead(z);
        }
        z = z.getHead();
        while (z != null) {
            System.out.print(z.getValue() + " ");
            z = (CorrectList) z.getNext();
        }


    }
}
