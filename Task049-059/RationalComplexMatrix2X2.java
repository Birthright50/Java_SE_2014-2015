/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexMatrix2X2 {
    private RationalComplexNumber[][] a = new RationalComplexNumber[2][2];

    public RationalComplexMatrix2X2(RationalComplexNumber x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] = x;
            }
        }
    }


    public RationalComplexMatrix2X2() {
        this(new RationalComplexNumber());
    }

    public RationalComplexMatrix2X2(RationalComplexNumber x, RationalComplexNumber x1, RationalComplexNumber x2, RationalComplexNumber x3) {
        this.a[0][0] = x;
        this.a[0][1] = x1;
        this.a[1][0] = x2;
        this.a[1][1] = x3;
    }

    public RationalComplexNumber[][] getA() {
        return a;
    }

    public void setA(RationalComplexNumber[][] a) {
        this.a = a;
    }

    public RationalComplexMatrix2X2 add(RationalComplexMatrix2X2 v) {
        return new RationalComplexMatrix2X2((this.a[0][0]).add(v.a[0][0]), this.a[0][1].add(v.a[0][1]), (this.a[1][1]).add(v.a[1][0]), (this.a[1][1]).add(v.a[1][1]));
    }

    public RationalComplexMatrix2X2 mult(RationalComplexMatrix2X2 v) {
        return new RationalComplexMatrix2X2((this.a[0][0].mult(v.a[0][0]).add(this.a[0][1].mult(v.a[1][0]))), (this.a[0][0].mult(v.a[0][1]).add(this.a[0][1].mult(v.a[1][1]))), (this.a[1][0].mult(v.a[0][0]).add(this.a[1][1].mult(v.a[1][0]))), (this.a[1][0].mult(v.a[0][1]).add(this.a[1][1].mult(v.a[1][1]))));
    }

    public RationalComplexNumber det() {
        if ((this.a[0][0].mult(this.a[1][1])).equals(this.a[1][0].mult(this.a[0][1]))) {
            return new RationalComplexNumber();
        }
        RationalComplexNumber v = (this.a[0][0].mult(this.a[1][1])).sub(this.a[1][0].mult(this.a[0][1]));
        return new RationalComplexNumber(v.getX(), v.getY());
    }

    public RationalComplexVector2D multVector(RationalComplexVector2D v) {
        return new RationalComplexVector2D((this.a[0][0].mult(v.getX()).add(this.a[0][1].mult(v.getY()))), (this.a[1][0].mult(v.getX()).add(this.a[1][1].mult(v.getY()))));
    }

    public String toString() {
        return this.a[0][0].toString() + "   " + this.a[0][1].toString() + "\n" + this.a[1][0].toString() + "   " + this.a[1][1].toString();
    }

    public static void main(String[] args) {
        RationalComplexMatrix2X2 x = new RationalComplexMatrix2X2();
        System.out.println(x);//0/1 + 0/1 * i , 0/1 + 0/1 * i, 0/1 + 0/1 * i , 0/1 + 0/1 * i
        System.out.println();
        RationalFraction y = new RationalFraction(5, 6);
        RationalFraction y1 = new RationalFraction(6, -9);
        RationalComplexNumber z = new RationalComplexNumber(y, y1);
        RationalFraction y2 = new RationalFraction(7, 8);
        RationalFraction y3 = new RationalFraction(6, -4);
        RationalComplexNumber z1 = new RationalComplexNumber(y2, y3);
        RationalComplexMatrix2X2 x1 = new RationalComplexMatrix2X2(z);
        System.out.println(x1);//5/6 - 6/9 * i , 5/6 - 6/9 * i, 5/6 - 6/9 * i , 5/6 - 6/9 * i
        System.out.println();
        RationalComplexMatrix2X2 x5 = new RationalComplexMatrix2X2(z, z1, z, z1);
        System.out.println(x5);//5/6 - 6/9 * i , 7/8 - 6/4 * i, 5/6 - 6/9 * i , 7/8 - 6/4 * i
        System.out.println();
        System.out.println(x5.add(x5));//5/3 - 4/3 * i , 7/4 - 3/1 * i, 5/3 - 4/3 * i , 7/4 - 3/1 * i
        System.out.println();
        System.out.println(x5.mult(x5));//-1/48 - 53/18 * i , -337/192 - 107/24 * i, -1/48 - 53/18 * i , -337/192 - 107/24 * i
        System.out.println();
        System.out.println(x5.det());//0/1 + 0/1 * i
        RationalFraction a = new RationalFraction(5, 6);
        RationalFraction b = new RationalFraction(6, -9);
        RationalComplexNumber e = new RationalComplexNumber(a, b);
        RationalFraction c = new RationalFraction(5, 6);
        RationalFraction d = new RationalFraction(6, -9);
        RationalComplexNumber f = new RationalComplexNumber(c, d);
        RationalComplexVector2D p = new RationalComplexVector2D(e, f);
        System.out.println(x5.multVector(p));//(-1/48 - 53/18 * i , -1/48 - 53/18 * i)


    }

}

