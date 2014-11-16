/**
 * Created by BirthrightL on 16.11.2014.
 */
public class ComplexVector2D {
    private double x;
    private double x1;
    private double y;
    private double y1;

    public ComplexVector2D(ComplexNumber v, ComplexNumber v1) {
        this.x = v.getReal();
        this.x1 = v.getImaginary();
        this.y = v1.getReal();
        this.y1 = v1.getImaginary();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());
    }

    public ComplexVector2D add(ComplexVector2D v) {
        ComplexNumber v1 = new ComplexNumber(this.x, this.x1);
        ComplexNumber v2 = new ComplexNumber(v.getX(), v.getX1());
        ComplexNumber v3 = new ComplexNumber(this.y, this.y1);
        ComplexNumber v4 = new ComplexNumber(v.getX(), v.getY());
        v1.add2(v2);
        v3.add2(v4);
        return new ComplexVector2D(v1, v3);
    }

    public String toString() {
        ComplexNumber l = new ComplexNumber(this.x, this.x1);
        ComplexNumber l1 = new ComplexNumber(this.y, this.y1);
        String s = l.toString() + " , " + l1.toString();
        return s;
    }

    public ComplexNumber scalarProduct(ComplexVector2D v) {
        ComplexNumber v1 = new ComplexNumber(this.x, this.x1);
        ComplexNumber v2 = new ComplexNumber(v.getX(), v.getX1());
        v1.mult2(v2);
        v2.setReal(this.y);
        v2.setImaginary(this.y1);
        ComplexNumber v3 = new ComplexNumber(v.getY(), v.getY1());
        v2.mult2(v3);
        v1.add2(v2);
        return v1;
    }

    public boolean equals(ComplexVector2D v) {
        ComplexNumber v1 = new ComplexNumber(this.x, this.x1);
        ComplexNumber v2 = new ComplexNumber(v.getX(), v.getX1());
        ComplexNumber v3 = new ComplexNumber(this.y, this.y1);
        ComplexNumber v4 = new ComplexNumber(v.getX(), v.getY());
        if (v1.equals(v2) && v3.equals(v4)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ComplexVector2D x = new ComplexVector2D();
        System.out.println(x);//0+0*i, 0+0*i
        ComplexNumber y = new ComplexNumber(5, 7);
        ComplexNumber y1 = new ComplexNumber(3, 8);
        ComplexVector2D x1 = new ComplexVector2D(y, y1);
        System.out.println(x1);//5+7*i, 3+8*i
        ComplexNumber y2 = new ComplexNumber(9, 10);
        ComplexNumber y3 = new ComplexNumber(33, 22);
        ComplexVector2D x2 = new ComplexVector2D(y2, y3);
        System.out.println(x2);//9+10*i, 33+22*i;
        System.out.println(x2.add(x1));//14+17*i, 38+25*i
        System.out.println(x2.scalarProduct(x1));//-102.0 + 443.0 * i
        System.out.println(x2.equals(x1));//false

    }

}
