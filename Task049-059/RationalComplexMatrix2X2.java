/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexMatrix2X2 {
    private int[][] a = new int[2][8];

    public RationalComplexMatrix2X2(RationalComplexNumber x) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j += 4) {
                a[i][j] = x.getA();
                a[i][j + 1] = x.getA1();
                a[i][j + 2] = x.getB();
                a[i][j + 3] = x.getB1();
            }
        }
    }

    public RationalComplexMatrix2X2() {
        this(new RationalComplexNumber());
    }

    public RationalComplexMatrix2X2(RationalComplexNumber x, RationalComplexNumber x1, RationalComplexNumber x2, RationalComplexNumber x3) {
        this.a[0][0] = x.getA();
        this.a[0][1] = x.getA1();
        this.a[0][2] = x.getB();
        this.a[0][3] = x.getB1();
        this.a[0][4] = x1.getA();
        this.a[0][5] = x1.getA1();
        this.a[0][6] = x1.getB();
        this.a[0][7] = x1.getB1();
        this.a[1][0] = x2.getA();
        this.a[1][1] = x2.getA1();
        this.a[1][2] = x2.getB();
        this.a[1][3] = x2.getB1();
        this.a[1][4] = x3.getA();
        this.a[1][5] = x3.getA1();
        this.a[1][6] = x3.getB();
        this.a[1][7] = x3.getB1();
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public RationalComplexMatrix2X2 add(RationalComplexMatrix2X2 v) {
        RationalFraction x = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction x2 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalFraction x9 = new RationalFraction(v.a[0][0], v.a[0][1]);
        RationalFraction x10 = new RationalFraction(v.a[0][2], v.a[0][3]);
        RationalComplexNumber y = new RationalComplexNumber(x, x2);
        RationalComplexNumber y1 = new RationalComplexNumber(x9, x10);


        x.setA(this.a[0][4]);
        x.setB(this.a[0][5]);
        x2.setA(this.a[0][6]);
        x2.setB(this.a[0][7]);
        x9.setA(v.a[0][4]);
        x9.setB(v.a[0][5]);
        x10.setA(v.a[0][6]);
        x10.setB(v.a[0][7]);
        RationalComplexNumber y2 = new RationalComplexNumber(x, x2);
        RationalComplexNumber y3 = new RationalComplexNumber(x9, x10);

        x.setA(this.a[1][0]);
        x.setB(this.a[1][1]);
        x2.setA(this.a[1][2]);
        x2.setB(this.a[1][3]);
        x9.setA(v.a[1][0]);
        x9.setB(v.a[1][1]);
        x10.setA(v.a[1][2]);
        x10.setB(v.a[1][3]);
        RationalComplexNumber y4 = new RationalComplexNumber(x, x2);
        RationalComplexNumber y5 = new RationalComplexNumber(x9, x10);

        x.setA(this.a[1][4]);
        x.setB(this.a[1][5]);
        x2.setA(this.a[1][6]);
        x2.setB(this.a[1][7]);
        x9.setA(v.a[1][4]);
        x9.setB(v.a[1][5]);
        x10.setA(v.a[1][6]);
        x10.setB(v.a[1][7]);
        RationalComplexNumber y6 = new RationalComplexNumber(x, x2);
        RationalComplexNumber y7 = new RationalComplexNumber(x9, x10);

        return new RationalComplexMatrix2X2(y.add(y1), y2.add(y3), y4.add(y5), y6.add(y7));
    }

    public RationalComplexMatrix2X2 mult(RationalComplexMatrix2X2 v) {
        RationalFraction y1 = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction y2 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalComplexNumber v1 = new RationalComplexNumber(y1, y2);

        y1.setA(this.a[0][4]);
        y1.setB(this.a[0][5]);
        y2.setA(this.a[0][6]);
        y2.setB(this.a[0][7]);
        RationalComplexNumber v2 = new RationalComplexNumber(y1, y2);

        y1.setA(this.a[1][0]);
        y1.setB(this.a[1][1]);
        y2.setA(this.a[1][2]);
        y2.setB(this.a[1][3]);
        RationalComplexNumber v3 = new RationalComplexNumber(y1, y2);

        y1.setA(this.a[1][4]);
        y1.setB(this.a[1][5]);
        y2.setA(this.a[1][6]);
        y2.setB(this.a[1][7]);
        RationalComplexNumber v4 = new RationalComplexNumber(y1, y2);

        y1.setA(v.a[0][0]);
        y1.setB(v.a[0][1]);
        y2.setA(v.a[0][2]);
        y2.setB(v.a[0][3]);
        RationalComplexNumber v5 = new RationalComplexNumber(y1, y2);

        y1.setA(v.a[0][4]);
        y1.setB(v.a[0][5]);
        y2.setA(v.a[0][6]);
        y2.setB(v.a[0][7]);
        RationalComplexNumber v6 = new RationalComplexNumber(y1, y2);

        y1.setA(v.a[1][0]);
        y1.setB(v.a[1][1]);
        y2.setA(v.a[1][2]);
        y2.setB(v.a[1][3]);
        RationalComplexNumber v7 = new RationalComplexNumber(y1, y2);

        y1.setA(v.a[1][4]);
        y1.setB(v.a[1][5]);
        y2.setA(v.a[1][6]);
        y2.setB(v.a[1][7]);
        RationalComplexNumber v8 = new RationalComplexNumber(y1, y2);

        return new RationalComplexMatrix2X2(v1.mult(v5).add(v2.mult(v7)), v1.mult(v6).add(v2.mult(v8)), v3.mult(v5).add(v4.mult(v7)), v3.mult(v6).add(v4.mult(v8)));
    }

    public RationalComplexNumber det() {
        RationalFraction y1 = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction y2 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalComplexNumber z1 = new RationalComplexNumber(y1, y2);

        y1.setA(this.a[0][4]);
        y1.setB(this.a[0][5]);
        y2.setA(this.a[0][6]);
        y2.setB(this.a[0][7]);
        RationalComplexNumber z2 = new RationalComplexNumber(y1, y2);

        y1.setA(this.a[1][0]);
        y1.setB(this.a[1][1]);
        y2.setA(this.a[1][2]);
        y2.setB(this.a[1][3]);
        RationalComplexNumber z3 = new RationalComplexNumber(y1, y2);

        y1.setA(this.a[1][4]);
        y1.setB(this.a[1][5]);
        y2.setA(this.a[1][6]);
        y2.setB(this.a[1][7]);
        RationalComplexNumber z4 = new RationalComplexNumber(y1, y2);
        z1 = z1.mult(z4);
        z2 = z2.mult(z3);
        if (z2.equals(z1)) {
            return new RationalComplexNumber();
        }
        RationalComplexNumber s = z1.mult(z4).sub(z2.mult(z3));
        System.out.println(s);
        y1.setA(s.getA());
        y1.setB(s.getA1());
        y2.setA(s.getB());
        y2.setB(s.getB1());
        return new RationalComplexNumber(y1, y2);
    }

    public RationalComplexVector2D multVector(RationalComplexVector2D v) {
        RationalFraction y1 = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction y2 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalComplexNumber x1 = new RationalComplexNumber(y1, y2);
        RationalFraction y3 = new RationalFraction(this.a[0][4], this.a[0][5]);
        RationalFraction y4 = new RationalFraction(this.a[0][6], this.a[0][7]);
        RationalComplexNumber x2 = new RationalComplexNumber(y3, y4);
        RationalFraction z1 = new RationalFraction(v.getA(), v.getA1());
        RationalFraction z2 = new RationalFraction(v.getA2(), v.getA3());
        RationalComplexNumber x3 = new RationalComplexNumber(z1, z2);
        RationalFraction z3 = new RationalFraction(v.getA4(), v.getA5());
        RationalFraction z4 = new RationalFraction(v.getA6(), v.getA7());
        RationalComplexNumber x4 = new RationalComplexNumber(z3, z4);
        x1 = x1.mult(x3).add(x2.mult(x4));
        RationalFraction y5 = new RationalFraction(this.a[1][0], this.a[1][1]);
        RationalFraction y6 = new RationalFraction(this.a[1][2], this.a[1][3]);
        RationalComplexNumber x5 = new RationalComplexNumber(y5, y6);
        RationalFraction y7 = new RationalFraction(this.a[1][4], this.a[1][5]);
        RationalFraction y8 = new RationalFraction(this.a[1][6], this.a[1][7]);
        RationalComplexNumber x6 = new RationalComplexNumber(y7, y8);
        x2 = x5.mult(x3).add(x6.mult(x4));
        return new RationalComplexVector2D(x1, x2);
    }

    public String toString() {
        RationalFraction y1 = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction y2 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalComplexNumber x1 = new RationalComplexNumber(y1, y2);
        RationalFraction y3 = new RationalFraction(this.a[0][4], this.a[0][5]);
        RationalFraction y4 = new RationalFraction(this.a[0][6], this.a[0][7]);
        RationalComplexNumber x2 = new RationalComplexNumber(y3, y4);
        RationalFraction y5 = new RationalFraction(this.a[1][0], this.a[1][1]);
        RationalFraction y6 = new RationalFraction(this.a[1][2], this.a[1][3]);
        RationalComplexNumber x3 = new RationalComplexNumber(y5, y6);
        RationalFraction y7 = new RationalFraction(this.a[1][4], this.a[1][5]);
        RationalFraction y8 = new RationalFraction(this.a[1][6], this.a[1][7]);
        RationalComplexNumber x4 = new RationalComplexNumber(y7, y8);
        return x1.toString() + " , " + x2.toString() + "\n" + x3.toString() + " , " + x4.toString();

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

