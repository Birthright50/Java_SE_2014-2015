/**
 * Created by Birthright on 10.02.2015.
 */
public class Elem {
    protected int value;
    protected Elem next;
    protected double valueDouble;


    public Elem(int value, Elem next) {
        this.value = value;
        this.next = next;
    }

    public Elem() {
    }

    public void setValueDouble(double valueDouble) {
        this.valueDouble = valueDouble;
    }

    public Elem(double valueDouble, Elem next) {
        this.next = next;
        this.valueDouble = valueDouble;
    }

    public Elem getNext() {
        return next;
    }

    public void setNext(Elem next) {
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public double getValueDouble() {
        return valueDouble;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
