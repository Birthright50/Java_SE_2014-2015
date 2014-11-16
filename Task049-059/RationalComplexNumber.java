/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexNumber {
    private int a;
    private int a1;
    private int b;
    private int b1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getB1() {
        return b1;
    }

    public void setB1(int b1) {
        this.b1 = b1;
    }

    public RationalComplexNumber(RationalFraction x, RationalFraction y) {
        this.a = x.getA();
        this.a1 = x.getB();

        this.b = y.getA();
        this.b1 = y.getB();
    }

    public RationalComplexNumber() {
        this(new RationalFraction(), new RationalFraction());
    }

    public String toString() {
        if (this.b1 >= 0 & this.a1 >= 0 & this.b < 0)
            return this.a + "/" + this.a1 + " - " + -this.b + "/" + this.b1 + " * i";
        if (this.b1 >= 0 & this.a1 >= 0 & this.b >= 0)
            return this.a + "/" + this.a1 + " + " + this.b + "/" + this.b1 + " * i";
        if (this.b1 >= 0 & this.a1 < 0 & this.b >= 0)
            return -this.a + "/" + (-this.a1) + " + " + this.b + "/" + this.b1 + " * i";
        if (this.b1 >= 0 & this.a1 < 0 & this.b < 0)
            return -this.a + "/" + (-this.a1) + "  " + this.b + "/" + this.b1 + " * i";
        if (this.b1 < 0 & this.a1 >= 0 & this.b >= 0)
            return this.a + "/" + this.a1 + " - " + this.b + "/" + (-this.b1) + " * i";
        if (this.b1 < 0 & this.a1 >= 0 & this.b < 0)
            return this.a + "/" + this.a1 + " + " + -this.b + "/" + (-this.b1) + " * i";
        if (this.b1 < 0 & this.a1 < 0 & this.b >= 0)
            return -this.a + "/" + -this.a1 + " - " + this.b + "/" + (-this.b1) + " * i";
        if (this.b1 < 0 & this.a1 < 0 & this.b < 0)
            return -this.a + "/" + (-this.a1) + " + " + -this.b + "/" + (-this.b1) + " * i";
        return null;
    }

    public RationalComplexNumber add(RationalComplexNumber v) {
        RationalFraction y = new RationalFraction(this.a, this.a1);
        RationalFraction y1 = new RationalFraction(this.b, this.b1);
        RationalFraction y2 = new RationalFraction(v.getA(), v.getA1());
        RationalFraction y3 = new RationalFraction(v.getB(), v.getB1());
        return new RationalComplexNumber(y.add(y2), y1.add(y3));
    }

    public RationalComplexNumber sub(RationalComplexNumber v) {
        RationalFraction y = new RationalFraction(this.a, this.a1);
        RationalFraction y1 = new RationalFraction(this.b, this.b1);
        RationalFraction y2 = new RationalFraction(v.getA(), v.getA1());
        RationalFraction y3 = new RationalFraction(v.getB(), v.getB1());
        return new RationalComplexNumber(y.sub(y2), y1.sub(y3));
    }

    public RationalComplexNumber mult(RationalComplexNumber v) {
        RationalFraction y = new RationalFraction(this.a, this.a1);
        RationalFraction y1 = new RationalFraction(this.b, this.b1);
        RationalFraction y2 = new RationalFraction(v.getA(), v.getA1());
        RationalFraction y3 = new RationalFraction(v.getB(), v.getB1());
        return new RationalComplexNumber(y.mult(y2).sub(y1.mult(y3)), y.mult(y3).add(y1.mult(y2)));
    }

    public static void main(String[] args) {
        RationalComplexNumber x = new RationalComplexNumber();
        System.out.println(x);//0/1 + 0/1 * i
        RationalFraction y = new RationalFraction(5, 6);
        RationalFraction y1 = new RationalFraction(6, -9);
        RationalComplexNumber x1 = new RationalComplexNumber(y, y1);
        System.out.println(x1);//5/6 - 6/9 * i
        RationalFraction z = new RationalFraction(3, 2);
        RationalFraction z1 = new RationalFraction(7, 11);
        RationalComplexNumber x2 = new RationalComplexNumber(z, z1);
        System.out.println(x2);//3/2 + 7/11 * i
        System.out.println(x1.sub(x2));//-2/3 - 43/33 * i
        System.out.println(x1.add(x2));//7/3 - 1/33 * i
        System.out.println(x1.mult(x2));//221/132 - 31/66 * i
    }

    public boolean equals(RationalComplexNumber v) {
        RationalFraction x = new RationalFraction(this.a, this.a1);
        RationalFraction x1 = new RationalFraction(this.b, this.b1);
        RationalFraction x2 = new RationalFraction(v.a, v.a1);
        RationalFraction x3 = new RationalFraction(v.b, v.b1);
        if (x.equals(x2) && x1.equals(x3)) {
            return true;
        }
        return false;

    }
}

