import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by birthright on 06.03.15.
 */
public class MyLinkedList extends MyLinkedCollection implements List<Integer> {
    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        if (index >= 0 && index < size) {
            ParametrizedElem e = head;
            int i = 0;
            while (i < index - 1) {
                e = e.getNext();
                i++;
            }
            MyLinkedList a = new MyLinkedList();
            for (Integer t : c) {
                a.add(t);
            }
            ParametrizedElem z = a.getLast();
            z.setNext(e.getNext());
            e.setNext(a.getHead());
            size += c.size();
            return true;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < size) {
            ParametrizedElem e = head;
            for (int i = 0; i < index; i++) {
                e = e.getNext();
            }
            return e.getValue();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Integer set(int index, Integer element) {
        if (index >= 0 && index < size) {
            ParametrizedElem e = head;
            for (int i = 0; i < index; i++) {
                e = e.getNext();
            }
            int t = e.getValue();
            e.setValue(element);
            return t;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, Integer element) {
        if (index >= 0 && index < size) {
            ParametrizedElem e = head;
            for (int i = 0; i < index - 1; i++) {
                e = e.getNext();
            }
            ParametrizedElem x = e.getNext();
            ParametrizedElem h = new ParametrizedElem(element, x);
            e.setNext(h);
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Integer remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                Integer t = head.getValue();
                head = head.getNext();
                return t;
            }
            ParametrizedElem e = head;
            for (int i = 0; i < index - 1; i++) {
                e = e.getNext();
            }
            Integer t = e.getNext().getValue();
            e.setNext(e.getNext().getNext());
            size--;
            return t;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public int indexOf(Object o) {
        ParametrizedElem e = head;
        for (int i = 0; e != null; i++) {
            if (o.equals(e.getValue())) {
                return i;
            }
            e = e.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int q = -1;
        ParametrizedElem e = head;
        for (int i = 0; e != null; i++) {
            if (o.equals(e.getValue())) {
                q = i;
            }
            e = e.getNext();
        }
        return q;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && toIndex >= 0 && fromIndex < size && toIndex < size) {
            MyLinkedList x = new MyLinkedList();
            ParametrizedElem e = head;
            for (int i = 0; i < fromIndex; i++) {
                e = e.getNext();
            }
            for (int i = fromIndex; i < toIndex; i++) {
                x.add(e.getValue());
                e = e.getNext();
            }
            return x;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        MyLinkedList x = new MyLinkedList();
        for (int i = 0; i < 20; i++) {
            x.add(i);
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            a.add(i);
        }
        x.addAll(5, a);
        System.out.println(x);
    }
}
