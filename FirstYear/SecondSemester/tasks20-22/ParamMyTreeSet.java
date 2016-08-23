package DZ;

import java.util.*;

/**
 * Created by Birthright on 18.04.2015.
 */
public class ParamMyTreeSet<T extends Comparable<T>> implements Set<T> {
    private ParamNode root;
    private int size = 0;

    private class ParamNode {
        T value;
        ParamNode left;
        ParamNode right;
        ParamNode parent;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ParamNode getLeft() {
            return left;
        }

        public void setLeft(ParamNode left) {
            this.left = left;
        }

        public ParamNode getRight() {
            return right;
        }

        public void setRight(ParamNode right) {
            this.right = right;
        }

        public ParamNode getParent() {
            return parent;
        }

        public void setParent(ParamNode parent) {
            this.parent = parent;
        }

        public ParamNode(T value, ParamNode left, ParamNode right, ParamNode parent) {

            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
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

    private boolean search(ParamNode node, Object o) {
        if (node == null) {
            return false;
        }
        if (o.equals(node.getValue())) {
            return true;
        }
        if (node.getValue().compareTo((T) o) < 0) {
            return search(node.getLeft(), o);
        } else {
            return search(node.getRight(), o);
        }
    }

    @Override
    public boolean contains(Object o) {
        return search(root, o);
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor = 0;
        int last = -1;
        Object[] array = ParamMyTreeSet.this.toArray();

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            int i = cursor;
            if (i > size)
                throw new NoSuchElementException();
            cursor = i + 1;
            return (T) array[last = i];
        }
    }

    @Override
    public Object[] toArray() {
        ParamNode p = root;
        int i = 0;
        Object a[] = new Object[size];
        Stack<ParamNode> q = new Stack<>();
        while (p != null || !q.empty()) {
            if (!q.empty()) {
                p = q.pop();
                a[i] = p.getValue();
                i++;
                if (p.getRight() != null) {
                    p = p.getRight();
                } else {
                    p = null;
                }
            }
            while (p != null) {
                q.push(p);
                p = p.getLeft();
            }
        }
        return a;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(this.toArray(), size, a.getClass());
        }
        System.arraycopy(this.toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    private void insert(T t, ParamNode node, ParamNode parent) {
        if (root == null) {
            root = new ParamNode(t, null, null, null);
            return;
        }
        if (node.getValue().compareTo(t) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new ParamNode(t, null, null, node));
            } else {
                insert(t, node.getLeft(), node);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new ParamNode(t, null, null, node));
            } else {
                insert(t, node.getRight(), node);
            }
        }
    }

    @Override
    public boolean add(T t) {
        if (!contains(t)) {
            insert(t, root, null);
            size++;
            return true;
        }
        return false;
    }


    private boolean delete(ParamNode node, Object o) {
        if (node == null) {
            return false;
        }
        if (node.getValue().compareTo((T) o) > 0) {
            delete(node.getLeft(), o);
        }
        if (node.getValue().compareTo((T) o) < 0) {
            delete(node.getRight(), o);
        }
        if (o.equals(node.getValue())) {
            if ((node.getLeft() == null && node.getRight() == null)) {
                if (node.getParent() != null) {
                    if (node.getValue().compareTo(node.getParent().getValue()) < 0) {
                        node.getParent().setLeft(null);
                    } else {
                        node.getParent().setRight(null);
                    }
                } else {
                    root = null;
                }
                return true;
            } else {
                if (node.getLeft() != null && node.getRight() == null) {
                    if (node.getParent() != null) {
                        if (node.getValue().compareTo(node.getParent().getValue()) < 0) {
                            node.getParent().setLeft(node.getLeft());
                        } else {
                            node.getParent().setRight(node.getLeft());
                        }
                    } else {
                        root = node.getLeft();
                    }
                    return true;
                } else {
                    if (node.getLeft() == null && node.getRight() != null) {
                        if (node.getParent() != null) {
                            if (node.getValue().compareTo(node.getParent().getValue()) < 0) {
                                node.getParent().setLeft(node.getRight());
                            } else {
                                node.getParent().setRight(node.getRight());
                            }
                        } else {
                            root = node.getRight();
                        }

                        return true;
                    } else {
                        T minimumOnRight = findMinimum(node.getRight());
                        node.setValue(minimumOnRight);
                        delete(node.getRight(), minimumOnRight);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    private T findMinimum(ParamNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    @Override
    public boolean remove(Object o) {
        boolean b = delete(root, o);
        if (b) {
            size--;
        }
        return b;
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
    public boolean addAll(Collection<? extends T> c) {
        int i = 0;
        for (T a : c) {
            if (add(a)) {
                i++;
            }
        }
        return i > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean q = false;
        for (T x : this) {
            if (!c.contains(x)) {
                remove(x);
                q = true;
            }
        }
        return q;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int i = 0;
        for (Object a : c) {
            if (remove(a)) {
                i++;
            }
        }
        return i > 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    public void print() {
        printTree(root, 0);
    }

    private void printTree(ParamNode root, int i) {
        if (root != null) {
            printTree(root.getRight(), i + 1);
            for (int j = 0; j < 2 * i; j++)
                System.out.print(" ");
            System.out.println(root.getValue());
            printTree(root.getLeft(), i + 1);
        }
    }

}
