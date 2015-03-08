import java.util.Scanner;

/**
 * Created by Birthright on 04.03.2015.
 */
public class Task14a {
    public static boolean checkNumber(String q) {
        int i = 0;
        if (q.charAt(0) == '-') {
            if (q.length() == 1) {
                return false;
            }
            i = 1;
        }

        while (i < q.length()) {
            char c = q.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        MyLinkedStack<Integer> a = new MyLinkedStack<Integer>();
        String q[] = s.split(",");
        for (String x : q) {
            if (checkNumber(x)) {
                a.push(Integer.valueOf(x));
                continue;
            }
            if (x.equals("+")) {
                a.push(a.pop() + a.pop());
            } else {
                if (x.equals("-")) {
                    a.push(a.pop() - a.pop());
                } else {
                    if (x.equals("*")) {
                        a.push(a.pop() * a.pop());
                    } else {
                        a.push(a.pop() / a.pop());
                    }
                }
            }
        }
        System.out.println(a.pop());

    }

}
