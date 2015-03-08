import java.util.Scanner;

/**
 * Created by Birthright on 04.03.2015.
 */
public class Task14c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        MyLinkedStack<Integer> s = new MyLinkedStack<Integer>();
        for (int i = 0; i < n; i++) {
            s.push(a[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(s.pop() + " ");
        }
    }
}
