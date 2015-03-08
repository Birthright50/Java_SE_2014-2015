/**
 * Created by Birthright on 04.03.2015.
 */
public class MyLinkedStack<T> implements MyStack<T> {
    private int size = 0;
    private ParamElem head;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ParamElem getHead() {
        return head;
    }

    public void setHead(ParamElem head) {
        this.head = head;
    }


    class ParamElem {
        private T item;
        private ParamElem next;

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public ParamElem getNext() {
            return next;
        }

        public void setNext(ParamElem next) {
            this.next = next;
        }
    }

    @Override
    public void push(T p) {
        ParamElem q = head;
        head = new ParamElem();
        head.item = p;
        head.next = q;
        size++;
    }

    @Override
    public T pop() {
        if (head == null) {
            return null;
        }
        T q = head.getItem();
        head = head.next;
        size--;
        return q;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}

