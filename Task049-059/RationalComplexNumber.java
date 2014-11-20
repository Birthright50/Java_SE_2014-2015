/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexNumber {
    private RationalFraction real;
    private RationalFraction imaginary;

    public RationalComplexNumber(RationalFraction x, RationalFraction y) {
        this.real = x;
        this.imaginary = y;
    }

    public RationalComplexNumber() {
        this(new RationalFraction(), new RationalFraction());
    }

    public String toString() {
        if(((this.imaginary.toString()).substring(0, 1)).equals("-")){
            return (this.real + " " + this.imaginary + " * i");
        }
        return (this.real + " + " + this.imaginary + " * i");
    }

    public RationalFraction getReal() {
        return real;
    }

    public void setReal(RationalFraction real) {
        this.real = real;
    }

    public RationalFraction getImaginary() {
        return imaginary;
    }

    public void setImaginary(RationalFraction imaginary) {
        this.imaginary = imaginary;
    }

    public RationalComplexNumber add(RationalComplexNumber v) {
        return new RationalComplexNumber(this.real.add(v.getReal()), this.imaginary.add(v.getImaginary()));
    }

    public RationalComplexNumber sub(RationalComplexNumber v) {
        return new RationalComplexNumber(this.real.sub(v.getReal()), this.imaginary.sub(v.getImaginary()));
    }

    public RationalComplexNumber mult(RationalComplexNumber v) {
        return new RationalComplexNumber((this.real.mult(v.real)).sub(this.imaginary.mult(v.imaginary)), (this.imaginary.mult(v.real)).add(this.real.mult(v.imaginary)));
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
        if(this.real.equals(v.getReal())&&this.imaginary.equals(v.getImaginary())){
            return true;
        }

        return false;

    }
}

