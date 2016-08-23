/**
 * Created by BirthrightL on 16.11.2014.
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @author(name = "Peter")
    public double getReal() {
        return real;
    }

    @author(name = "Tramp")
    public void setReal(double real) {
        this.real = real;
    }

    @author(name = "John")
    public double getImaginary() {
        return imaginary;
    }

    @author(name = "Fairman")
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @author(name = "Walker")
    public String toString() {
        if (imaginary >= 0)
            return real + " + " + imaginary + " * i";
        else
            return real + " - " + -imaginary + " * i";
    }

    public ComplexNumber() {
        this(0, 0);
    }
    @author(name = "Tramp")
    public ComplexNumber add(ComplexNumber v) {
        return new ComplexNumber(this.real + v.getReal(), this.imaginary + v.getImaginary());
    }
    @author(name = "Walker")
    public void add2(ComplexNumber v) {
        this.real += v.getReal();
        this.imaginary += v.getImaginary();
    }

    @author(name = "John")
    public ComplexNumber sub(ComplexNumber v) {
        return new ComplexNumber(this.real - v.getReal(), this.imaginary - v.getImaginary());
    }
    @author(name = "Tramp")
    public void sub2(ComplexNumber v) {
        this.real -= v.getReal();
        this.imaginary -= v.getImaginary();
    }
    @author(name = "Peter")
    public ComplexNumber multNumber(double v) {
        return new ComplexNumber(this.real * v, this.imaginary * v);
    }
    @author(name = "Tramp")
    public void multNumber2(double v) {
        this.real *= v;
        this.imaginary *= v;
    }
    @author(name = "John")
    public ComplexNumber mult(ComplexNumber v) {
        return new ComplexNumber(this.real * v.getReal() - this.imaginary * v.getImaginary(), this.imaginary * v.getReal() + this.real * v.getImaginary());
    }
    @author(name = "Fairman")
    public void mult2(ComplexNumber v) {
        double b = this.real;
        this.real = this.real * v.getReal() - this.imaginary * v.getImaginary();
        this.imaginary = b * v.getImaginary() + this.imaginary * v.getReal();
    }
    @author(name = "Fairman")
    public ComplexNumber div(ComplexNumber v) {
        ComplexNumber div = new ComplexNumber();
        double h, z;
        if (Math.abs(v.getReal()) >= Math.abs(v.getImaginary())) {
            h = v.getImaginary() / v.getReal();
            z = v.getReal() + h * v.getImaginary();
            div.real = (this.real + h * this.imaginary) / z;
            div.imaginary = (this.imaginary - h * this.real) / z;
            return div;
        } else {
            h = v.getReal() / v.getImaginary();
            z = v.getImaginary() + h * v.getReal();
            div.real = (h * this.real + this.imaginary) / z;
            div.imaginary = (h * this.imaginary - this.real) / z;
            return div;
        }
    }
    @author(name = "Tramp")
    public void div2(ComplexNumber v) {
        double h, z;
        if (Math.abs(v.getReal()) >= Math.abs(v.getImaginary())) {
            h = v.getImaginary() / v.getReal();
            z = v.getReal() + h * v.getImaginary();
            this.real = (this.real + h * this.imaginary) / z;
            this.imaginary = (this.imaginary - h * this.real) / z;

        } else {
            h = v.getReal() / v.getImaginary();
            z = v.getImaginary() + h * v.getReal();
            this.real = (h * this.real + this.imaginary) / z;
            this.imaginary = (h * this.imaginary - this.real) / z;
        }
    }
    @author(name = "John")
    public double length() {
        return Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);

    }
    @author(name = "John")
    public double arg() {
        return Math.atan2(this.imaginary, this.real);
    }
    @author(name = "Walker")
    public ComplexNumber pow(double v) {
        ComplexNumber pow = new ComplexNumber();
        pow.real = Math.pow(this.length(), v) * Math.cos(v * this.arg());
        pow.imaginary = Math.pow(this.length(), v) * Math.sin(v * this.arg());
        return pow;
    }
    @author(name = "Walker")
    public boolean equals(ComplexNumber v) {
        return this.real == v.getReal() && this.imaginary == v.getImaginary();
    }


}