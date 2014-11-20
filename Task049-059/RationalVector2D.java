/**
 * Created by BirthrightL on 16.11.2014.
 */

public class RationalVector2D {
    private RationalFraction x;
    private RationalFraction y;

    public RationalVector2D(RationalFraction x, RationalFraction y) {
        this.x = x;
        this.y = y;
    }

    public RationalFraction getX() {
        return x;
    }

    public void setX(RationalFraction x) {
        this.x = x;
    }

    public RationalFraction getY() {
        return y;
    }

    public void setY(RationalFraction y) {
        this.y = y;
    }

    public RationalVector2D() {
        this(new RationalFraction(), new RationalFraction());
    }

    public RationalVector2D add(RationalVector2D v) {
        return new RationalVector2D(this.x.add(v.getX()), this.y.add(v.getY()));
    }

    public String toString() {
        return "("+this.x.toString() + " , " + this.y.toString()+")";
    }

    public double length() {
        double a = Math.sqrt(((this.x.mult(this.x)).add(this.y.mult(this.y))).value());
        return a;
    }

    public RationalFraction scalarProduct(RationalVector2D v) {
        RationalFraction x = (this.x.mult(v.getX())).add(this.y.mult(v.getY()));
        return new RationalFraction(x.getNumerator(), x.getDenominator());
    }

    public boolean equals(RationalVector2D v) {
        if (this.x != v.getX()) {
            return false;
        }
        if (this.y != v.getY()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        RationalVector2D x = new RationalVector2D();
        System.out.println(x);//(0/1 , 0/1)
        RationalFraction y = new RationalFraction(5, 6);
        RationalFraction y1 = new RationalFraction(10, 11);
        RationalVector2D x1 = new RationalVector2D(y, y1);
        System.out.println(x1);//(5/6 , 10/11)
        RationalFraction y2 = new RationalFraction(7, 10);
        RationalFraction y3 = new RationalFraction(2, 3);
        RationalVector2D x2 = new RationalVector2D(y2, y3);
        System.out.println(x2);//(7/10, 2/3)
        System.out.println(x1.add(x2));//(23/15, 52/33)
        System.out.println(x1.length());//1.233243984553008
        System.out.println(x1.scalarProduct(x2));//(157/137)
        System.out.println(x1.equals(x2));//false
    }

}
