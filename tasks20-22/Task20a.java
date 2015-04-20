package DZ;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Birthright on 15.04.2015.
 */
public class Task20a {
    public static void LPK(Node p) {
        int x = 1;
        Stack<Node> q = new Stack<>();
        while (p != null || !q.empty()) {
            if (!q.empty()) {
                p = q.pop();
                if (!q.empty() && p.getRight() == q.lastElement()) {
                    p = q.pop();
                } else {
                    p.setValue(x);
                    x += 1;
                    p = null;
                }
            }
            while (p != null) {
                q.push(p);
                if (p.getRight() != null) {
                    q.push(p.getRight());
                    q.push(p);
                }
                p = p.getLeft();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree a = new Tree(sc.nextInt());
        LPK(a.getRoot());
        a.print();
    }
}
