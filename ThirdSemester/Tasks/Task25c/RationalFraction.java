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
    @author(name = "Walker")
    public int getNumerator() {
        return numerator;
    }
    @author(name = "John")
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    @author(name = "Tramp")
    public int getDenominator() {
        return denominator;
    }
    @author(name = "Fairman")
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    @author(name = "Peter")
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
    @author(name = "Peter")
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
    @author(name = "Peter")
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
    @author(name = "John")
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
    @author(name = "John")
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
    @author(name = "Tramp")
    public RationalFraction mult(RationalFraction v) {
        RationalFraction v1 = new RationalFraction(this.numerator * v.getNumerator(), this.denominator * v.getDenominator());
        v1.reduce();
        return v1;
    }
    @author(name = "Walker")
    public void mult2(RationalFraction v) {
        this.numerator *= v.getNumerator();
        this.denominator *= v.getDenominator();
        this.reduce();
    }
    @author(name = "Walker")
    public RationalFraction div(RationalFraction v) {
        RationalFraction v1 = new RationalFraction(this.numerator * v.getDenominator(), this.denominator * v.getNumerator());
        v1.reduce();
        return v1;
    }
    @author(name = "Tramp")
    public void div2(RationalFraction v) {
        this.numerator *= v.getDenominator();
        this.denominator *= v.getNumerator();
        this.reduce();
    }
    @author(name = "Tramp")
    public String toString() {
        if(this.denominator <0 & this.numerator <0){
            return -this.numerator + "/" + -this.denominator;
        }
        if (this.denominator < 0) {
            return "-" + this.numerator + "/" + -this.denominator;
        }
        return this.numerator + "/" + this.denominator;
    }
    @author(name = "Fairman")
    public double value() {
        return this.numerator * 1.0 / this.denominator;
    }
    @author(name = "Fairman")
    public boolean equals(RationalFraction v) {
        this.reduce();
        v.reduce();
        return (this.toString()).equals(v.toString());
    }
    @author(name = "Peter")
    public int numberPart(){
        return this.numerator / this.denominator;
    }


}