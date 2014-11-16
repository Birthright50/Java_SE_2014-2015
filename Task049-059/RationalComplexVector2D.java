/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexVector2D {
    private int a;
    private int a1;
    private int a2;
    private int a3;
    private int a4;
    private int a5;
    private int a6;
    private int a7;

    public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
        this.a = x.getA();
        this.a1 = x.getA1();
        this.a2 = x.getB();
        this.a3 = x.getB1();
        this.a4 = y.getA();
        this.a5 = y.getA1();
        this.a6 = y.getB();
        this.a7 = y.getB1();
    }

    public RationalComplexVector2D() {
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public int getA3() {
        return a3;
    }

    public void setA3(int a3) {
        this.a3 = a3;
    }

    public int getA4() {
        return a4;
    }

    public void setA4(int a4) {
        this.a4 = a4;
    }

    public int getA5() {
        return a5;
    }

    public void setA5(int a5) {
        this.a5 = a5;
    }

    public int getA6() {
        return a6;
    }

    public void setA6(int a6) {
        this.a6 = a6;
    }

    public int getA7() {
        return a7;
    }

    public void setA7(int a7) {
        this.a7 = a7;
    }

    public RationalComplexVector2D add(RationalComplexVector2D v) {
        RationalFraction x = new RationalFraction(this.a, this.a1);
        RationalFraction x2 = new RationalFraction(this.a2, this.a3);
        RationalFraction x3 = new RationalFraction(this.a4, this.a5);
        RationalFraction x4 = new RationalFraction(this.a6, this.a7);
        RationalFraction x5 = new RationalFraction(v.a, v.a1);
        RationalFraction x6 = new RationalFraction(v.a2, v.a3);
        RationalFraction x7 = new RationalFraction(v.a4, v.a5);
        RationalFraction x8 = new RationalFraction(v.a6, v.a7);
        RationalComplexNumber y = new RationalComplexNumber(x.add(x5), x2.add(x6));
        RationalComplexNumber y1 = new RationalComplexNumber(x3.add(x7), x4.add(x8));

        return new RationalComplexVector2D(y, y1);
    }

    public String toString() {
        RationalFraction x = new RationalFraction(this.a, this.a1);
        RationalFraction x2 = new RationalFraction(this.a2, this.a3);
        RationalFraction x3 = new RationalFraction(this.a4, this.a5);
        RationalFraction x4 = new RationalFraction(this.a6, this.a7);
        RationalComplexNumber y = new RationalComplexNumber(x, x2);
        RationalComplexNumber y1 = new RationalComplexNumber(x3, x4);
        String g = "(" + y.toString() + " , " + y1.toString() + ")";
        return g;
    }

    public RationalComplexNumber scalarProduct(RationalComplexVector2D v) {
        RationalFraction x = new RationalFraction(this.a, this.a1);
        RationalFraction x2 = new RationalFraction(this.a2, this.a3);
        RationalFraction x3 = new RationalFraction(this.a4, this.a5);
        RationalFraction x4 = new RationalFraction(this.a6, this.a7);
        RationalComplexNumber y = new RationalComplexNumber(x, x2);
        RationalComplexNumber y2 = new RationalComplexNumber(x3, x4);
        y = y.mult(y2);
        x.setA(v.a);
        x.setB(v.a1);
        x2.setA(v.a2);
        x2.setB(v.a3);
        x3.setA(v.a4);
        x3.setB(v.a5);
        x4.setA(v.a6);
        x4.setB(v.a7);
        RationalComplexNumber y3 = new RationalComplexNumber(x, x2);
        RationalComplexNumber y4 = new RationalComplexNumber(x3, x4);
        y3 = y3.mult(y4);
        y = y.add(y3);
        return y;
    }

    public static void main(String[] args) {
        RationalComplexVector2D x = new RationalComplexVector2D();
        System.out.println(x);//0/1 + 0/1 * i , 0/1 + 0/1 * i
        RationalFraction y = new RationalFraction(5, 6);
        RationalFraction y1 = new RationalFraction(6, -9);
        RationalComplexNumber x1 = new RationalComplexNumber(y, y1);
        RationalFraction y2 = new RationalFraction(5, 6);
        RationalFraction y3 = new RationalFraction(6, -9);
        RationalComplexNumber x2 = new RationalComplexNumber(y2, y3);
        RationalComplexVector2D x3 = new RationalComplexVector2D(x1, x2);
        System.out.println(x3);//(5/6 - 6/9 * i , 5/6 - 6/9 * i)
        RationalFraction a = new RationalFraction(5, 6);
        RationalFraction b = new RationalFraction(6, -9);
        RationalComplexNumber e = new RationalComplexNumber(a, b);
        RationalFraction c = new RationalFraction(5, 6);
        RationalFraction d = new RationalFraction(6, -9);
        RationalComplexNumber f = new RationalComplexNumber(c, d);
        RationalComplexVector2D p = new RationalComplexVector2D(e, f);
        System.out.println(x3.add(p));//(5/3 - 4/3 * i , 5/3 - 4/3 * i)
        System.out.println(x3.scalarProduct(x3));//1/2 - 20/9 * i

    }


}
