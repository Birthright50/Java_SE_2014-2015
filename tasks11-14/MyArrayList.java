import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Birthright on 04.03.2015.
 */
public class MyArrayList extends MyArrayCollection implements List<Integer> {

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        if (index >= 0 && index < size && size + c.size() <= CAPACITY) {
            for (int i = index; i < size; i++) {
                a[i + c.size()] = a[i];
            }
            size += c.size();
            int i = index;
            for (Integer x : c) {
                a[i] = x;
                i++;
            }
            return true;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < size) {
            return a[index];
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public Integer set(int index, Integer element) {
        if (index >= 0 && index < size) {
            int q = a[index];
            a[index] = element;
            return q;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, Integer element) {
        if (index >= 0 && index < size && size < CAPACITY) {
            for (int i = size - 1; i >= index; i--) {
                a[i + 1] = a[i];
            }
            a[index] = element;
            size++;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public Integer remove(int index) {
        if (index >= 0 && index < size) {
            int q = a[index];
            for (int i = index; i < size - 1; i++) {
                a[i] = a[i + 1];
            }
            size--;
            return q;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(a[i])) {
                return i;
            }
        }
        return -1;
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
            MyArrayList x = new MyArrayList();
            for (int i = fromIndex; i < toIndex; i++) {
                x.add(this.a[i]);
            }
            return x;
        } else {
            throw new IndexOutOfBoundsException();

        }
    }
}
