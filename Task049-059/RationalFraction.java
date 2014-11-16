/**
 * Created by BirthrightL on 15.11.2014.
 */
public class RationalFraction {
    private int a;
    private int b;

    public RationalFraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public RationalFraction() {
        this(0, 1);
    }

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

    public void reduce() {
        int g = Math.abs(this.a);
        int h = Math.abs(this.b);
        int l = 0;
        while (g != 0 && h != 0) {
            if (g > h) {
                g %= h;
            } else {
                h %= g;
            }
            l = h + g;
        }
        this.a /= l;
        this.b /= l;
    }

    public RationalFraction add(RationalFraction v) {
        if (this.b == v.getB()) {
            RationalFraction v1 = new RationalFraction(this.a + v.getA(), v.getB());
            v1.reduce();

            return v1;
        } else {
            RationalFraction v1 = new RationalFraction(this.a * v.getB() + v.getA() * this.b, this.b * v.getB());
            v1.reduce();

            return v1;
        }
    }

    public void add2(RationalFraction v) {
        if (this.b == v.getB()) {
            this.a += v.getA();
            this.reduce();
        } else {
            this.a = this.a * v.getB() + v.getA() * this.b;
            this.b *= v.getB();
            this.reduce();
        }
    }

    public RationalFraction sub(RationalFraction v) {
        if (this.b == v.getB()) {
            RationalFraction v1 = new RationalFraction(this.a - v.getA(), v.getB());
            v1.reduce();
            return v1;
        } else {
            RationalFraction v1 = new RationalFraction(this.a * v.getB() - v.getA() * this.b, this.b * v.getB());
            v1.reduce();
            return v1;
        }
    }

    public void sub2(RationalFraction v) {
        if (this.b == v.getB()) {
            this.a -= v.getA();
            this.reduce();
        } else {
            this.a = this.a * v.getB() - v.getA() * this.b;
            this.b *= v.getB();
            this.reduce();
        }
    }

    public RationalFraction mult(RationalFraction v) {
        RationalFraction v1 = new RationalFraction(this.a * v.getA(), this.b * v.getB());
        v1.reduce();
        return v1;
    }

    public void mult2(RationalFraction v) {
        this.a *= v.getA();
        this.b *= v.getB();
        this.reduce();
    }

    public RationalFraction div(RationalFraction v) {
        RationalFraction v1 = new RationalFraction(this.a * v.getB(), this.b * v.getA());
        v1.reduce();
        return v1;
    }

    public void div2(RationalFraction v) {
        this.a *= v.getB();
        this.b *= v.getA();
        this.reduce();
    }

    public String toString() {
        if(this.b<0 & this.a<0){
            String s = -this.a + "/" + -this.b;
            return s;
        }
        if (this.b < 0) {
            String s = "-" + this.a + "/" + -this.b;
            return s;
        }
        String s = this.a + "/" + this.b;
        return s;
    }

    public double value() {
        double s = this.a * 1.0 / this.b;
        return s;
    }

    public boolean equals(RationalFraction v) {
        this.reduce();
        v.reduce();
        if(this.a!=v.getA()&&this.b!=v.getB()){
            return false;
        }
        return true;
    }
    public int numberPart(){
        int a = this.a/this.b;
        return a;
    }

    public static void main(String[] args) {
        RationalFraction x = new RationalFraction();
        System.out.println(x); //(0/1)
        RationalFraction x1 = new RationalFraction(4, -12);
        System.out.println(x1);//(-4/12)
        x1.reduce();
        System.out.println(x1); //(-1/3)
        RationalFraction x2 = new RationalFraction(8, 12);
        System.out.println(x2.add(x1)); //(1/3)
        System.out.println(x2.sub(x1)); //(1/1)
        System.out.println(x2.mult(x1)); //(-2/9)
        System.out.println(x2.div(x1)); //(-2/1)
        System.out.println(x2.value()); //(0,(6))
        System.out.println(x1.equals(x2));//false
        System.out.println(x1.numberPart()); //0
    }
}
