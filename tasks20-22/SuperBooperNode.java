package DZ;

/**
 * Created by Birthright on 19.04.2015.
 */
public class SuperBooperNode {
    private String value;
    private SuperBooperNode son;
    private SuperBooperNode next;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SuperBooperNode getSon() {
        return son;
    }

    public void setSon(SuperBooperNode son) {
        this.son = son;
    }

    public SuperBooperNode getNext() {
        return next;
    }

    public void setNext(SuperBooperNode next) {
        this.next = next;
    }

    public SuperBooperNode(String value, SuperBooperNode son, SuperBooperNode next) {
        this.value = value;
        this.son = son;
        this.next = next;

    }
}
