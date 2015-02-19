/**
 * Created by Birthright on 10.02.2015.
 */
public class CorrectList extends Elem {
    private CorrectList head;
    private CorrectList last;

    public CorrectList getHead() {
        return head;
    }

    public void setHead(CorrectList head) {
        this.head = head;
    }

    public CorrectList getLast() {
        return last;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setLast(CorrectList last) {
        this.last = last;
    }

    public void add(int value) {
        CorrectList a = new CorrectList();
        a.value = value;
        if (last == null) {
            head = a;
            last = a;
        } else {
            last.next = a;
            last = a;
        }
    }

    public void printList() {
        CorrectList t = head;
        while (t != null) {
            System.out.print(t.getValue() + " ");
            t = (CorrectList) t.getNext();
        }
    }

}
