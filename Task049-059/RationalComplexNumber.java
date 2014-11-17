/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexNumber {
    private RationalFraction x;
    private RationalFraction y;

    public RationalComplexNumber(RationalFraction x, RationalFraction y) {
        this.x = x;
        this.y = y;
    }

    public RationalComplexNumber() {
        this(new RationalFraction(), new RationalFraction());
    }

    public String toString() {
        return (this.x + " + " + this.y + " * i");
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

    public RationalComplexNumber add(RationalComplexNumber v) {
        return new RationalComplexNumber(this.x.add(v.getX()), this.y.add(v.getY()));
    }

    public RationalComplexNumber sub(RationalComplexNumber v) {
        return new RationalComplexNumber(this.x.sub(v.getX()), this.y.sub(v.getY()));
    }

    public RationalComplexNumber mult(RationalComplexNumber v) {
        return new RationalComplexNumber((this.x.mult(v.x)).sub(this.y.mult(v.y)), (this.y.mult(v.x)).add(this.x.mult(v.y)));
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
        if (this.x != v.x) {
            return false;
        }
        if (this.y != v.y) {
            return false;
        }
        return true;

    }
}

