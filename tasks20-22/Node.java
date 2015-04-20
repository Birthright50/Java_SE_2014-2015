package DZ;

/**
 * Created by Birthright on 15.04.2015.
 */
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private Node parent;

    public Node(int value, Node left, Node right, Node parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
