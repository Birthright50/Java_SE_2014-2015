/**
 * Created by BirthrightL on 15.11.2014.
 */
public class RationalFraction {
    private int numerator;
    private int denominator;

    public RationalFraction(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    }

    public RationalFraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void reduce() {
        int g = Math.abs(this.numerator);
        int h = Math.abs(this.denominator);
        int l = 0;
        while (g != 0 && h != 0) {
            if (g > h) {
                g %= h;
            } else {
                h %= g;
            }
            l = h + g;
        }
        this.numerator /= l;
        this.denominator /= l;
    }

    public RationalFraction add(RationalFraction v) {
        if (this.denominator == v.getDenominator()) {
            RationalFraction v1 = new RationalFraction(this.numerator + v.getNumerator(), v.getDenominator());
            v1.reduce();

            return v1;
        } else {
            RationalFraction v1 = new RationalFraction(this.numerator * v.getDenominator() + v.getNumerator() * this.denominator, this.denominator * v.getDenominator());
            v1.reduce();

            return v1;
        }
    }

    public void add2(RationalFraction v) {
        if (this.denominator == v.getDenominator()) {
            this.numerator += v.getNumerator();
            this.reduce();
        } else {
            this.numerator = this.numerator * v.getDenominator() + v.getNumerator() * this.denominator;
            this.denominator *= v.getDenominator();
            this.reduce();
        }
    }

    public RationalFraction sub(RationalFraction v) {
        if (this.denominator == v.getDenominator()) {
            RationalFraction v1 = new RationalFraction(this.numerator - v.getNumerator(), v.getDenominator());
            v1.reduce();
            return v1;
        } else {
            RationalFraction v1 = new RationalFraction(this.numerator * v.getDenominator() - v.getNumerator() * this.denominator, this.denominator * v.getDenominator());
            v1.reduce();
            return v1;
        }
    }

    public void sub2(RationalFraction v) {
        if (this.denominator == v.getDenominator()) {
            this.numerator -= v.getNumerator();
            this.reduce();
        } else {
            this.numerator = this.numerator * v.getDenominator() - v.getNumerator() * this.denominator;
            this.denominator *= v.getDenominator();
            this.reduce();
        }
    }

    public RationalFraction mult(RationalFraction v) {
        RationalFraction v1 = new RationalFraction(this.numerator * v.getNumerator(), this.denominator * v.getDenominator());
        v1.reduce();
        return v1;
    }

    public void mult2(RationalFraction v) {
        this.numerator *= v.getNumerator();
        this.denominator *= v.getDenominator();
        this.reduce();
    }

    public RationalFraction div(RationalFraction v) {
        RationalFraction v1 = new RationalFraction(this.numerator * v.getDenominator(), this.denominator * v.getNumerator());
        v1.reduce();
        return v1;
    }

    public void div2(RationalFraction v) {
        this.numerator *= v.getDenominator();
        this.denominator *= v.getNumerator();
        this.reduce();
    }

    public String toString() {
        if(this.denominator <0 & this.numerator <0){
            String s = -this.numerator + "/" + -this.denominator;
            return s;
        }
        if (this.denominator < 0) {
            String s = "-" + this.numerator + "/" + -this.denominator;
            return s;
        }
        String s = this.numerator + "/" + this.denominator;
        return s;
    }

    public double value() {
        double s = this.numerator * 1.0 / this.denominator;
        return s;
    }

    public boolean equals(RationalFraction v) {
        this.reduce();
        v.reduce();
        if((this.toString()).equals(v.toString())){
            return true;
        }
        return false;
    }
    public int numberPart(){
        int a = this.numerator /this.denominator;
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
