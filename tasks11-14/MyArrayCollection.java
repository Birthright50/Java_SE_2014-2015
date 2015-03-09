import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Birthright on 04.03.2015.
 */
public class MyArrayCollection implements Collection<Integer> {
    protected final int CAPACITY = 1000000;
    protected int[] a = new int[CAPACITY];
    protected int size = 0;

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
        for (int i = 0; i < size; i++) {
            if (o.equals(a[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if (size == CAPACITY) {
            return false;
        }
        a[size] = integer;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(a[i])) {
                for (int j = i; j < size - 1; j++) {
                    a[j] = a[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

      @Override
      public boolean containsAll(Collection<?> c) {
          for (Object aX : c) {
              if (!contains(aX)) {
                  return false;
              }
          }
          return true;
      }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        if (c.size() + size <= CAPACITY) {
            int i = size;
            for (Integer q : c) {
                a[i] = q;
                i++;
            }
            size += c.size();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int i = 0;
        for (Object a : c) {
            if (remove(a)) {
                i++;
            }
        }
        return i != 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean q = false;
        for (int i = 0; i < size; i++)
            if (!c.contains(a[i])) {
                remove(a[i]);
                i = 0;
                q = true;
            }
        return q;
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            a[i] = 0;
        }
        size = 0;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + a[i] + " ";
        }
        return s;
    }

}
