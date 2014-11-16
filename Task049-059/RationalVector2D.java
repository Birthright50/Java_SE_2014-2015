/**
 * Created by BirthrightL on 16.11.2014.
 */

public class RationalVector2D {
    private int x;
    private int x1;
    private int y;
    private int y1;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public RationalVector2D(RationalFraction x, RationalFraction y) {
        this.x = x.getA();
        this.x1 = x.getB();
        this.y = y.getA();
        this.y1 = y.getB();
    }

    public RationalVector2D() {
        this(new RationalFraction(), new RationalFraction());

    }

    public RationalVector2D add(RationalVector2D v) {
        RationalFraction l = new RationalFraction(this.x, this.x1);
        RationalFraction l1 = new RationalFraction(v.getX(), v.getX1());
        l.add2(l1);
        l1.setA(this.y);
        l1.setB(this.y1);
        RationalFraction l2 = new RationalFraction(v.getY(), v.getY1());
        l1.add2(l2);
        return new RationalVector2D(l, l1);
    }

    public String toString() {
        RationalFraction l = new RationalFraction(this.x, this.x1);
        RationalFraction l1 = new RationalFraction(this.y, this.y1);
        String s = "(" + l.toString() + " , " + l1.toString() + ")";
        return s;
    }

    public double length() {
        RationalFraction l = new RationalFraction(this.x, this.x1);
        RationalFraction l1 = new RationalFraction(this.y, this.y1);
        l.mult2(l);
        l1.mult2(l1);
        l.add2(l1);
        double s = Math.sqrt(l.value());
        return s;
    }

    public RationalFraction scalarProduct(RationalVector2D v) {
        RationalFraction s = new RationalFraction(this.x, this.x1);
        RationalFraction s1 = new RationalFraction(v.getX(), v.getX1());
        s.mult2(s1);
        s1.setA(this.y);
        s1.setB(this.y1);
        RationalFraction s3 = new RationalFraction(v.getY(), v.getY1());
        s1.mult2(s3);
        s.add2(s1);
        return new RationalFraction(s.getA(), s.getB());
    }

    public boolean equals(RationalVector2D v) {
        RationalFraction l = new RationalFraction(this.x, this.x1);
        RationalFraction l1 = new RationalFraction(v.getX(), v.getX1());
        RationalFraction l2 = new RationalFraction(this.y, this.y1);
        RationalFraction l3 = new RationalFraction(v.getY(), v.getY1());
        if (l.equals(l1) && l2.equals(l3)) {
            return true;
        }
        return false;
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
