import java.util.Scanner;

/**
 * Created by Birthright on 10.02.2015.
 */
public class task06a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CorrectList p = new CorrectList();
        for (int i = 1; i <= n; i++) {
            p.add(sc.nextInt());
        }
        p.printList();
    }
}
