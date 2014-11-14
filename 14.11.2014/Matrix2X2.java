/**
 * Created by Birthright on 14.11.2014.
 */
public class Matrix2X2 {
    private double a1;
    private double a2;
    private double a3;
    private double a4;


    public Matrix2X2(double a1, double a2, double a3, double a4) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }

    public Matrix2X2() {
        this(0, 0, 0, 0);
    }
    public Matrix2X2(double x){
        this.a1 = x;
        this.a2 = x;
        this.a3 = x;
        this.a4 = x;
    }

    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA4() {
        return a4;
    }

    public void setA4(double a4) {
        this.a4 = a4;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix2X2 matrix2X2 = (Matrix2X2) o;

        if (Double.compare(matrix2X2.a1, a1) != 0) return false;
        if (Double.compare(matrix2X2.a2, a2) != 0) return false;
        if (Double.compare(matrix2X2.a3, a3) != 0) return false;
        if (Double.compare(matrix2X2.a4, a4) != 0) return false;

        return true;
    }

       public String toString() {
        String g = a1 + " " + a2+"\n"+a3+" "+a4;
        return g;

    }
    public void add(Matrix2X2 h){
        this.a1=this.a1+h.getA1();
        this.a2=this.a2+h.getA2();
        this.a3=this.a3+h.getA3();
        this.a4=this.a4+h.getA4();
    }
}

