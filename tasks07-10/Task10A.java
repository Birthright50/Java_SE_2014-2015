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
        Elem e = p.getHead();
        Integer g = 0;
        for (int i = 0; i < n; i++) {
            g = g * 2 + e.getValue();
            e = e.getNext();
        }
        CorrectList z = new CorrectList();
        int[] s = new int[g.toString().length()];
        for (int i = s.length - 1; i >= 0; i--) {
            s[i] = g % 10;
            g /= 10;
        }
        for (int value : s) {
            z.add(value);
        }
        e = z.getHead();
        while (e != null) {
            System.out.print(e.getValue() + " ");
            e = e.getNext();
        }

    }
}
