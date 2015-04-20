package DZ;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Birthright on 15.04.2015.
 */
public class Task20b {
    public static void LKP(Node p) {
        int x = 1;
        Stack<Node> q = new Stack<>();
        while (p != null || !q.empty()) {
            if (!q.empty()) {
                p = q.pop();
                p.setValue(x);
                x += 1;
                if (p.getRight() != null) {
                    p = p.getRight();
                } else {
                    p = null;
                }
            }
            while (p != null) {
                q.push(p);
                p = p.getLeft();
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree a = new Tree(sc.nextInt());
        LKP(a.getRoot());
        a.print();
    }
}
