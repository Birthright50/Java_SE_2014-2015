import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Birthright on 01.05.2015.
 */
public class Edge implements Comparable<Edge>, Serializable {

    public boolean contains(int x) {
        return x == v || x == w;
    }

    private Integer v = -1;
    private Integer w = -1;

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public void setV(int v) {
        this.v = v;

    }

    public void setW(int w) {
        this.w = w;
    }

    public Edge() {
    }

    public String toString() {
        return v + "-" + w;
    }

    public Edge(int v, int w) {
        if (v < w) {
            this.v = v;
            this.w = w;
        } else {
            this.v = w;
            this.w = v;
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return Objects.equals(v, edge.v) && Objects.equals(w, edge.w);

    }

    @Override
    public int hashCode() {
        int result = v;
        result = 31 * result + w;
        return result;
    }


    @Override
    public int compareTo(Edge o) {
        if (this.v < o.v) return -1;
        if (this.v > o.v) return +1;
        if (this.w < o.w) return -1;
        if (this.w > o.w) return +1;
        return 0;
    }


}
