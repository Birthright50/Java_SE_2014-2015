/**
 * Created by BirthrightL on 16.11.2014.
 */
public class ComplexMatrix2X2 {
    private double[][] a = new double[2][4];

    public ComplexMatrix2X2(ComplexNumber v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j += 2) {
                a[i][j] = v.getReal();
                a[i][j + 1] = v.getImaginary();
            }
        }

    }

    public ComplexMatrix2X2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2X2(ComplexNumber v, ComplexNumber v1, ComplexNumber v2, ComplexNumber v3) {
        this.a[0][0] = v.getReal();
        this.a[0][1] = v.getImaginary();
        this.a[0][2] = v1.getReal();
        this.a[0][3] = v1.getImaginary();
        this.a[1][0] = v2.getReal();
        this.a[1][1] = v2.getImaginary();
        this.a[1][2] = v3.getReal();
        this.a[1][3] = v3.getImaginary();
    }

    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public ComplexMatrix2X2 add(ComplexMatrix2X2 v) {
        return new ComplexMatrix2X2(new ComplexNumber(this.a[0][0] + v.a[0][0], this.a[0][1] + v.a[0][1]), new ComplexNumber(this.a[0][2] + v.a[0][2], this.a[0][3] + v.a[0][3]), new ComplexNumber(this.a[1][0] + v.a[1][0], this.a[1][1] + v.a[1][1]), new ComplexNumber(this.a[1][2] + v.a[1][2], this.a[1][3] + v.a[1][3]));
    }

    public ComplexMatrix2X2 mult(ComplexMatrix2X2 v) {
        ComplexNumber v1 = new ComplexNumber(this.a[0][0], this.a[0][1]);
        ComplexNumber v2 = new ComplexNumber(v.a[0][0], v.a[0][1]);
        ComplexNumber v3 = new ComplexNumber(this.a[0][2], this.a[0][3]);
        ComplexNumber v4 = new ComplexNumber(v.a[0][2], v.a[0][3]);
        ComplexNumber v5 = new ComplexNumber(this.a[1][0], this.a[1][1]);
        ComplexNumber v6 = new ComplexNumber(v.a[1][0], v.a[1][1]);
        ComplexNumber v7 = new ComplexNumber(this.a[1][2], this.a[1][3]);
        ComplexNumber v8 = new ComplexNumber(v.a[1][2], v.a[1][3]);
        return new ComplexMatrix2X2(v1.mult(v2).add(v3.mult(v6)), (v1.mult(v4).add(v3.mult(v8))), (v5.mult(v2).add(v7.mult(v6))), (v5.mult(v4).add(v7.mult(v8))));
    }

    public ComplexNumber det() {
        ComplexNumber v1 = new ComplexNumber(this.a[0][0], this.a[0][1]);
        ComplexNumber v3 = new ComplexNumber(this.a[0][2], this.a[0][3]);
        ComplexNumber v5 = new ComplexNumber(this.a[1][0], this.a[1][1]);
        ComplexNumber v7 = new ComplexNumber(this.a[1][2], this.a[1][3]);
        v1.mult2(v7);
        v3.mult2(v5);
        if (v1.equals(v3)) {
            return new ComplexNumber();
        }
        v1.sub2(v3);
        return new ComplexNumber(v1.getReal(), v1.getImaginary());
    }

    public ComplexVector2D multVector(ComplexVector2D v) {
        ComplexNumber v1 = new ComplexNumber(this.a[0][0], this.a[0][1]);
        ComplexNumber v3 = new ComplexNumber(this.a[0][2], this.a[0][3]);
        ComplexNumber v5 = new ComplexNumber(this.a[1][0], this.a[1][1]);
        ComplexNumber v7 = new ComplexNumber(this.a[1][2], this.a[1][3]);
        ComplexNumber s1 = new ComplexNumber(v.getX(), v.getX1());
        ComplexNumber s2 = new ComplexNumber(v.getY(), v.getY1());
        return new ComplexVector2D(v1.mult(s1).add(v3.mult(s2)), v5.mult(s1).add(v7.mult(s2)));
    }

    public String toString() {
        ComplexNumber l = new ComplexNumber(this.a[0][0], this.a[0][1]);
        ComplexNumber l1 = new ComplexNumber(this.a[0][2], this.a[0][3]);
        ComplexNumber l2 = new ComplexNumber(this.a[1][0], this.a[1][1]);
        ComplexNumber l3 = new ComplexNumber(this.a[1][2], this.a[1][3]);
        return l.toString() + " , " + l1.toString() + "\n" + l2.toString() + " , " + l3.toString();
    }

    public static void main(String[] args) {
        ComplexMatrix2X2 x = new ComplexMatrix2X2();
        System.out.println(x); //0.0 + 0.0 * i , 0.0 + 0.0 * i, 0.0 + 0.0 * i , 0.0 + 0.0 * i
        ComplexNumber y = new ComplexNumber(1, 3);
        ComplexMatrix2X2 x1 = new ComplexMatrix2X2(y);
        System.out.println(x1);//1.0 + 3.0 * i , 1.0 + 3.0 * i, 1.0 + 3.0 * i , 1.0 + 3.0 * i
        ComplexNumber z1 = new ComplexNumber(-5, 3);
        ComplexNumber z2 = new ComplexNumber(5, -8);
        ComplexNumber z3 = new ComplexNumber(2, 6);
        ComplexNumber z4 = new ComplexNumber(6, 3);
        ComplexMatrix2X2 x2 = new ComplexMatrix2X2(z1, z2, z3, z4);
        System.out.println(x2);//-5.0 + 3.0 * i , 5.0 - 8.0 * i, 2.0 + 6.0 * i , 6.0 + 3.0 * i
        System.out.println(x2.det());//-97.0 - 11.0 * i
        System.out.println(x2.add(x2));//-10.0 + 6.0 * i , 10.0 - 16.0 * i, 4.0 + 12.0 * i , 12.0 + 6.0 * i
        System.out.println(x2.mult(x2));
        ComplexNumber h = new ComplexNumber(5, 7);
        ComplexNumber h1 = new ComplexNumber(3, 8);
        ComplexVector2D b = new ComplexVector2D(h, h1);
        System.out.println(x2.multVector(b));//33.0 - 4.0 * i , -38.0 + 101.0 * i
    }

}
