import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by birthright on 06.03.15.
 */
public class MyLinkedCollection implements Collection<Integer> {
    protected ParametrizedElem head;
    protected ParametrizedElem last;
    protected int size = 0;

    public ParametrizedElem getHead() {
        return head;
    }

    public ParametrizedElem getLast() {
        return last;
    }

    class ParametrizedElem {
        public ParametrizedElem(int value, ParametrizedElem next) {
            this.value = value;
            this.next = next;
        }

        private int value;

        public ParametrizedElem getNext() {
            return next;
        }

        public void setNext(ParametrizedElem next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private ParametrizedElem next;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        ParametrizedElem x = head;
        while (x != null) {
            if (o.equals(x.getValue())) {
                return true;
            }
            x = x.getNext();
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        ParametrizedElem e = new ParametrizedElem(integer, null);
        if (head == null) {
            head = e;
            last = e;
        } else {
            last.next = e;
            last = e;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o.equals(head.value)) {
            head = head.next;
            size--;
            return true;
        }
        ParametrizedElem e = head;
        while (e.getNext().getNext() != null) {
            if (o.equals(e.getNext().getValue())) {
                e.setNext(e.getNext().getNext());
                size--;
                return true;
            }
            e = e.getNext();
        }
        if (o.equals(e.getNext().getValue())) {
            last = e;
            e.setNext(null);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int k;
        for (Object x : c) {
            k = 0;
            ParametrizedElem a = head;
            while (a != null) {
                if (x.equals(a.getValue())) {
                    k++;
                    break;
                }
                a = a.getNext();
            }
            if (k == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer t : c) {
            this.add(t);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int i = 0;
        for (Object x : c) {
            if (remove(x)) {
                i++;
            }
        }
        return i != 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean q = false;
        ParametrizedElem a = head;
        while (a != null) {
            if (!c.contains(a.getValue())) {
                remove(a.getValue());
                a = head;
                q = true;
            }
            a = a.getNext();
        }
        return q;
    }

    public String toString() {
        ParametrizedElem x = head;
        String s = "";
        while (x != null) {
            s = s + x.getValue() + " ";
            x = x.getNext();
        }
        return s;
    }

    @Override
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

}
