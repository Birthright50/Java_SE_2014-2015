import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Birthright on 23.02.2015.
 */
public class ZhegalkinPolinom {
    private Konj head;
    private Konj last;

    public ZhegalkinPolinom() {
    }

    public Konj getHead() {
        return head;
    }

    public void setHead(Konj head) {
        this.head = head;
    }

    public Konj getLast() {
        return last;
    }

    public void setLast(Konj last) {
        this.last = last;
    }

    public ZhegalkinPolinom(Konj head, Konj last) {
        this.head = head;
        this.last = last;
    }

    private void checkHead(ZhegalkinPolinom i, Konj j) {
        if (i.head == null) {
            i.head = j;
            i.last = j;
        } else {
            i.last.setNext(j);
            i.last = j;
        }
    }

    public ZhegalkinPolinom constructPolynomial(String s) {
        String[] b = s.split("[+]");
        for (String x : b) {
            Konj j;
            try {
                if (Integer.valueOf(x).equals(1)) {
                    ArrayList<Integer> a1 = new ArrayList<Integer>();
                    a1.add(0, 0);
                    j = new Konj(a1, null);
                    checkHead(this, j);
                    continue;
                }
            } catch (NumberFormatException e) {
            }
            ArrayList<Integer> a = new ArrayList<Integer>();
            String[] l = x.split("");
            for (int i = 1; i < l.length; i = i + 3) {
                a.add(Integer.valueOf(l[i]));
            }
            j = new Konj(a, null);
            checkHead(this, j);
        }
        return this;
    }

    private String fromHeadToTheLast(Konj j) {
        String s = "";
        while (j.getNext() != null) {
            if (j.getArray().get(0) == 0) {
                s = s + 1 + "+";
            } else {
                for (int i = 0; i < j.getArray().size(); i++) {
                    s = s + "X" + j.getArray().get(i) + "&";
                }
                s = s.substring(0, s.length() - 1);
                s = s + "+";
            }
            j = j.getNext();
        }
        if (j.getArray().get(0) == 0) {
            s = s + 1;
        } else {
            for (int i = 0; i < j.getArray().size(); i++) {
                s = s + "X" + j.getArray().get(i) + "&";
            }
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    public String toString() {
        String s = "";
        Konj j = this.head;
        if (j.getArray().get(0) == 0) {
            s = 1 + "+";
        } else {
            for (int i = 0; i < j.getArray().size(); i++) {
                s = s + "X" + j.getArray().get(i) + "&";
            }
            s = s.substring(0, s.length() - 1);
            s = s + "+";
        }
        j = j.getNext();
        s = s + fromHeadToTheLast(j);
        return s;
    }

    public void insert(Konj j) {
        Konj a = this.head;
        while (a != null) {
            if ((a.getArray()).equals(j.getArray())) {
                return;
            }
            a = a.getNext();
        }
        this.last.setNext(j);
        this.last = j;
    }

    private void insertAnItem(Konj j, int i) {
        while (j.getNext() != null) {
            boolean q = true;
            for (int a = 0; a < j.getArray().size(); a++) {
                if (j.getArray().get(a) == i) {
                    q = false;
                    break;
                }
            }
            if (q) {
                j.getArray().add(i);
            }
            if (j.getArray().get(0) == 0) {
                j.getArray().clear();
                j.getArray().add(i);
            }
            j = j.getNext();
        }
    }

    public ZhegalkinPolinom polinomWith(int i) {
        ZhegalkinPolinom s = new ZhegalkinPolinom(this.head, this.last);
        boolean q = true;
        Konj j = s.head;
        for (int a = 0; a < s.head.getArray().size(); a++) {
            if (s.head.getArray().get(a) == i) {
                q = false;
                break;
            }
        }
        if (s.head.getArray().get(0) == 0) {
            s.head.getArray().clear();
            s.head.getArray().add(i);
        }
        if (q) {
            s.head.getArray().add(i);
        }
        j = j.getNext();
        this.head.setNext(j);
        insertAnItem(j, i);
        for (int a = 0; a < s.last.getArray().size(); a++) {
            q = true;
            if (s.last.getArray().get(a) == i) {
                q = false;
                break;
            }
        }
        if (q) {
            s.last.getArray().add(i);
        }
        if (s.last.getArray().get(0) == 0) {
            s.last.getArray().clear();
            s.last.getArray().add(i);
        }
        return s;
    }

    public ZhegalkinPolinom sum(ZhegalkinPolinom p) {
        ZhegalkinPolinom g = new ZhegalkinPolinom(this.head, this.last);
        g.last.setNext(p.getHead());
        g.last = p.getLast();
        Konj j = this.head;
        Konj a = this.head;
        Konj q = this.head;
        while (j != null) {
            while (a != null) {
                if (j.getArray().equals(a.getArray())) {

                }
                a = a.getNext();
            }
            q = q.getNext();
            a = q;
            j = j.getNext();
        }
        return g;
    }

    public boolean value(boolean[] v) {
        Konj j = this.head;
        int k = 0;
        while (j != null) {
            if (j.getArray().get(0) == 0) {
                k++;
                j = j.getNext();
                continue;
            }
            boolean l = true;
            for (int i = 0; l && i < j.getArray().size(); i++) {
                for (int q = 1; l && q <= v.length; q++) {
                    if (j.getArray().get(i) == q) {
                        if (v[q - 1]) {
                            break;
                        } else {
                            l = false;
                        }
                    }
                }
            }
            if (l) {
                k++;
            }
            j = j.getNext();
        }
        return k % 2 != 0;
    }

    public void sortByLength() {
        Konj j = this.head;
        Konj a = this.head;
        Konj q = this.head;
        while (j != null) {
            while (a != null) {
                if (j.getArray().size() > a.getArray().size()) {
                    ArrayList<Integer> x = j.getArray();
                    j.setArray(a.getArray());
                    a.setArray(x);
                }
                a = a.getNext();
            }
            q = q.getNext();
            a = q;
            j = j.getNext();
        }
    }

    public static void main(String[] args) {
        String s = "X1&X2&X3+X1+X3&X2+1";
        ZhegalkinPolinom x = new ZhegalkinPolinom();
        x.constructPolynomial(s);
        System.out.println(x);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(4);
        Konj j = new Konj(a, null);
        x.insert(j);
        System.out.println(x);
        ZhegalkinPolinom s1 = x.polinomWith(4);
        System.out.println(s1);
        boolean q[] = new boolean[4];
        q[0] = true;
        q[1] = true;
        q[2] = false;
        q[3] = true;
        String s55 = "X1&X2&X3+X1+X2&X3+1+X4";
        ZhegalkinPolinom s66 = new ZhegalkinPolinom();
        s66.constructPolynomial(s55);
        System.out.println(s66.value(q));
        s1.sortByLength();
        System.out.println(s1);
    }
}
