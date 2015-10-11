package DZ;

import java.util.*;

/**
 * Created by Birthright on 15.04.2015.
 */
public class MyTreeSet implements Set<Integer> {
    private int size = 0;
    private Node root;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean search(Node node, Object o) {
        if (node == null) {
            return false;
        }
        if (o.equals(node.getValue())) {
            return true;
        }
        if ((Integer) (o) < node.getValue()) {
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
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {
        int cursor = 0;
        int last = -1;
        Object[] array = MyTreeSet.this.toArray();

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Integer next() {
            int i = cursor;
            if (i > size)
                throw new NoSuchElementException();

            cursor = i + 1;
            return (Integer) array[last = i];
        }
    }

    @Override
    public Object[] toArray() {
        Node p = root;
        int i = 0;
        Object a[] = new Object[size];
        Stack<Node> q = new Stack<>();
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
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(this.toArray(), size, a.getClass());
        }
        System.arraycopy(this.toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }


    private void insert(Integer integer, Node node, Node parent) {
        if (root == null) {
            root = new Node(integer, null, null, null);
            return;
        }
        if (node.getValue() > integer) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(integer, null, null, node));
            } else {
                insert(integer, node.getLeft(), node);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(integer, null, null, node));
            } else {
                insert(integer, node.getRight(), node);
            }
        }
    }

    @Override
    public boolean add(Integer integer) {
        if (!contains(integer)) {
            insert(integer, root, null);
            size++;
            return true;
        }
        return false;
    }

    private Integer findMinimum(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    private boolean delete(Node node, Object o) {
        if (node == null) {
            return false;
        }
        if ((Integer) (o) < node.getValue()) {
            delete(node.getLeft(), o);
        }
        if ((Integer) (o) > node.getValue()) {
            delete(node.getRight(), o);
        }
        if ((Integer) (o) == node.getValue()) {
            if ((node.getLeft() == null && node.getRight() == null)) {
                if (node.getParent() != null) {
                    if (node.getValue() < node.getParent().getValue()) {
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
                        if (node.getValue() < node.getParent().getValue()) {
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
                            if (node.getValue() < node.getParent().getValue()) {
                                node.getParent().setLeft(node.getRight());
                            } else {
                                node.getParent().setRight(node.getRight());
                            }
                        } else {
                            root = node.getRight();
                        }
                        return true;
                    } else {
                        Integer minimumOnRight = findMinimum(node.getRight());
                        node.setValue(minimumOnRight);
                        delete(node.getRight(), minimumOnRight);
                        return true;
                    }
                }
            }

        }
        return false;
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
    public boolean addAll(Collection<? extends Integer> c) {
        int i = 0;
        for (Integer a : c) {
            if (add(a)) {
                i++;
            }
        }
        return i > 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean q = false;
        for (Integer x : this) {
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

    private static void printTree(Node root, int i) {
        if (root != null) {
            printTree(root.getRight(), i + 1);
            for (int j = 0; j < 2 * i; j++)
                System.out.print(" ");
            System.out.println(root.getValue());
            printTree(root.getLeft(), i + 1);
        }

    }
}
