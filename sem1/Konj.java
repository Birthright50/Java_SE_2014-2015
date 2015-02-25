import java.util.ArrayList;

/**
 * Created by Birthright on 19.02.2015.
 */
public class Konj {
    private ArrayList<Integer> array;
    private Konj next;

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }

    public Konj getNext() {
        return next;
    }

    public void setNext(Konj next) {
        this.next = next;
    }

    public Konj() {

    }

    public Konj(ArrayList<Integer> i, Konj conjunct) {
        this.array = i;
        this.next = conjunct;
    }

    public static void main(String[] args) {

    }
}
