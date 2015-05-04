import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Birthright on 01.05.2015.
 */
public class SuperNode implements Serializable, Comparable<SuperNode> {
    public int color = -1;
    private int value;

    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append(value);
        s.append(" -> ");
        for (SuperNode x : relatedNodes) {
            s.append(x.getValue()).append(" ");
        }
        return s.toString();
    }

    private ArrayList<SuperNode> relatedNodes = new ArrayList<>();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<SuperNode> getRelatedNodes() {
        return relatedNodes;
    }


    @Override
    public int compareTo(SuperNode o) {
        if (this.value < o.value) return -1;
        if (this.value > o.value) return +1;
        return 0;
    }


}
