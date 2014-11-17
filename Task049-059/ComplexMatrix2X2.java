/**
 * Created by BirthrightL on 16.11.2014.
 */
public class ComplexMatrix2X2 {
    private ComplexNumber[][] a = new ComplexNumber[2][2];

    public ComplexMatrix2X2(ComplexNumber v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] = v;
            }
        }

    }

    public ComplexMatrix2X2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2X2(ComplexNumber v, ComplexNumber v1, ComplexNumber v2, ComplexNumber v3) {
        this.a[0][0] = v;
        this.a[0][1] = v1;
        this.a[1][0] = v2;
        this.a[1][1] = v3;
    }

    public ComplexNumber[][] getA() {
        return a;
    }

    public void setA(ComplexNumber[][] a) {
        this.a = a;
    }

    public ComplexMatrix2X2 add(ComplexMatrix2X2 v) {
        return new ComplexMatrix2X2((this.a[0][0]).add(v.a[0][0]), this.a[0][1].add(v.a[0][1]), (this.a[1][1]).add(v.a[1][0]), (this.a[1][1]).add(v.a[1][1]));
    }

    public ComplexMatrix2X2 mult(ComplexMatrix2X2 v) {
        return new ComplexMatrix2X2((this.a[0][0].mult(v.a[0][0]).add(this.a[0][1].mult(v.a[1][0]))), (this.a[0][0].mult(v.a[0][1]).add(this.a[0][1].mult(v.a[1][1]))), (this.a[1][0].mult(v.a[0][0]).add(this.a[1][1].mult(v.a[1][0]))), (this.a[1][0].mult(v.a[0][1]).add(this.a[1][1].mult(v.a[1][1]))));
    }

    public ComplexNumber det() {
        if(this.a[0][0].mult(this.a[1][1]).equals(this.a[1][0].mult(this.a[0][1]))){
            return new ComplexNumber();
        }
        ComplexNumber x = (this.a[0][0].mult(this.a[1][1])).sub(this.a[1][0].mult(this.a[0][1]));
        return new ComplexNumber(x.getReal(), x.getImaginary());
    }

    public ComplexVector2D multVector(ComplexVector2D v) {
        return new ComplexVector2D((this.a[0][0].mult(v.getX()).add(this.a[0][1].mult(v.getY()))), (this.a[1][0].mult(v.getX()).add(this.a[1][1].mult(v.getY()))));
    }

    public String toString() {
        return this.a[0][0].toString() + "   " + this.a[0][1].toString() + "\n" + this.a[1][0].toString() + "   " + this.a[1][1].toString();
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
        System.out.println(x2.mult(x2));//74.0 - 16.0 * i 53.0 + 22.0 * i, -34.0 + 18.0 * i 85.0 + 50.0 * i
        ComplexNumber h = new ComplexNumber(5, 7);
        ComplexNumber h1 = new ComplexNumber(3, 8);
        ComplexVector2D b = new ComplexVector2D(h, h1);
        System.out.println(x2.multVector(b));//33.0 - 4.0 * i , -38.0 + 101.0 * i
    }

}
