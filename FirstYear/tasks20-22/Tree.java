package DZ;

public class Tree {
    private Node root;

    public Tree(int n) {
        root = createBalancedTree(n);
    }

    public Node getRoot() {
        return root;
    }

    static private Node createBalancedTree(int n) {
        if (n == 0)
            return null;
        int nr = n / 2;
        int nl = n - 1 - nr;
        return new Node(n, createBalancedTree(nl), createBalancedTree(nr));
    }

    public void print() {
        printTree(root, 0);
    }

    public static void printTree(Node root, int i) {
        if (root != null) {
            printTree(root.getRight(), i + 1);
            for (int j = 0; j < 2 * i; j++)
                System.out.print(" ");
            System.out.println(root.getValue());
            printTree(root.getLeft(), i + 1);
        }
    }




}