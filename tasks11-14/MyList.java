import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by birthright on 06.03.15.
 */
public class MyList<T> extends MyCollection<T> implements List<T> {
    @Override

    public boolean addAll(int index, Collection<? extends T> c) {
        if (index >= 0 && index < size) {
            ParamElem e = head;
            int i = 0;
            while (i < index - 1) {
                e = e.getNext();
                i++;
            }
            MyList<T> a = new MyList<T>();
            for (T t : c) {
                a.add(t);
            }
            ParamElem z = a.getLast();
            z.setNext(e.getNext());
            e.setNext(a.getHead());
            size += c.size();
            return true;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            ParamElem e = head;
            for (int i = 0; i < index; i++) {
                e = e.getNext();
            }
            return e.getValue();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T element) {
        if (index >= 0 && index < size) {
            ParamElem e = head;
            for (int i = 0; i < index; i++) {
                e = e.getNext();
            }
            T t = e.getValue();
            e.setValue(element);
            return t;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, T element) {
        if (index >= 0 && index < size) {
            ParamElem e = head;
            for (int i = 0; i < index - 1; i++) {
                e = e.getNext();
            }
            ParamElem x = e.getNext();
            ParamElem h = new ParamElem(element, x);
            e.setNext(h);
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                T t = head.getValue();
                head = head.getNext();
                return t;
            }
            ParamElem e = head;
            for (int i = 0; i < index - 1; i++) {
                e = e.getNext();
            }
            T t = e.getNext().getValue();
            e.setNext(e.getNext().getNext());
            size--;
            return t;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        ParamElem e = head;
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
        ParamElem e = head;
        for (int i = 0; e != null; i++) {
            if (o.equals(e.getValue())) {
                q = i;
            }
            e = e.getNext();
        }
        return q;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && toIndex >= 0 && fromIndex < size && toIndex < size) {
            MyList<T> x = new MyList<T>();
            ParamElem e = head;
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


}
