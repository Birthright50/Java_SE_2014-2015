/**
 * Created by Birthright on 10.02.2015.
 */
public class CorrectList extends Elem {
    private Elem head;
    private Elem last;

    public Elem getHead() {
        return head;
    }

    public void setHead(Elem head) {
        this.head = head;
    }

    public Elem getLast() {
        return last;
    }

    public void setLast(Elem last) {
        this.last = last;
    }

    @Override
    public int getValue() {
        return value;
    }

    public void setLast(CorrectList last) {
        this.last = last;
    }

    public void add(int value) {
        Elem a = new Elem();
        a.value = value;
        if (last == null) {
            head = a;
            last = a;
        } else {
            last.next = a;
            last = a;
        }
    }


}