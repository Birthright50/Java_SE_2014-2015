import java.util.Scanner;

/**
 * Created by Birthright on 04.03.2015.
 */
public class Task14b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String open = "([<{";
        String closed = ")]>}";
        int k = 0, l = 0;
        MyLinkedStack<Character> q = new MyLinkedStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character u = s.charAt(i);
            if (open.contains(u.toString())) {
                q.push(u);
                k++;
            }
            if (closed.contains(u.toString())) {
                if (q.isEmpty()) {
                    System.out.println("Встретилась лишняя закрывающая");
                    return;
                }
                int b = q.pop();
                if (u - 2 == b || u - 1 == b) {
                    l++;
                } else {
                    System.out.println("Скобки не соответствуют друг другу");
                    return;
                }
            }
        }
        if (k > l) {
            System.out.println("Не все открывающие закрыты");
            return;
        }
        if (q.isEmpty()) {
            System.out.println("Все правильно");
        }
    }
}
