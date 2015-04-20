package DZ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Birthright on 15.04.2015.
 */
public class Task20c {
    public static int maxKLP(Node p) {
        Stack<Node> q = new Stack<>();
        int max = p.getValue();
        while (p != null || !q.empty()) {
            if (!q.empty()) {
                p = q.pop();
            }
            while (p != null) {
                if (p.getValue() > max) {
                    max = p.getValue();
                }
                if (p.getRight() != null) {
                    q.push(p.getRight());
                }
                p = p.getLeft();
            }
        }
        return max;
    }

    public static int sumOfTheWidth(Node p) {
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        do {
            sum += p.getValue();
            if (p.getLeft() != null) {
                q.add(p.getLeft());
            }
            if (p.getRight() != null) {
                q.add(p.getRight());
            }
            if (!q.isEmpty()) {
                p = q.poll();
            }
        } while (!q.isEmpty());
        return sum;
    }

    static int mult;

    public static void multiplication(Node p) {
        if (p != null) {
            mult *= p.getValue();
            multiplication(p.getLeft());
            multiplication(p.getRight());
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        Tree a = new Tree(sc.nextInt());
        int max = maxKLP(a.getRoot());
        System.out.println(max);
        int sum = sumOfTheWidth(a.getRoot());
        System.out.println(sum);
        mult = 1;
        multiplication(a.getRoot());
        System.out.println(mult);
    }
}
