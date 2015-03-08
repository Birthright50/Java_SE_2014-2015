import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Birthright on 04.03.2015.
 */
public class MyCollection<T> implements Collection<T> {
    protected ParamElem head;
    protected ParamElem last;
    protected int size = 0;

    public ParamElem getHead() {
        return head;
    }

    public ParamElem getLast() {
        return last;
    }

    class ParamElem {
        private T value;
        private ParamElem next;

        public ParamElem(T value, ParamElem next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ParamElem getNext() {
            return next;
        }

        public void setNext(ParamElem next) {
            this.next = next;
        }
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
        ParamElem x = head;
        while (x != null) {
            if ((o).equals(x.getValue())) {
                return true;
            }
            x = x.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        ParamElem e = new ParamElem(t, null);
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
        ParamElem e = head;
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
            ParamElem a = head;
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
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
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
        ParamElem a = head;
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
        String s = "";
        ParamElem x = head;
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
