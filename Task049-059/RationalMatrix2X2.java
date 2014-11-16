/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalMatrix2X2 {
    private int[][] a = new int[2][4];

    public RationalMatrix2X2(RationalFraction v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j += 2) {
                a[i][j] = v.getA();
                a[i][j + 1] = v.getB();
            }
        }
    }

    public RationalMatrix2X2() {
        this(new RationalFraction());
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public RationalMatrix2X2(RationalFraction v, RationalFraction v1, RationalFraction v2, RationalFraction v3) {
        this.a[0][0] = v.getA();
        this.a[0][1] = v.getB();
        this.a[0][2] = v1.getA();
        this.a[0][3] = v1.getB();
        this.a[1][0] = v2.getA();
        this.a[1][1] = v2.getB();
        this.a[1][2] = v3.getA();
        this.a[1][3] = v3.getB();
    }

    public RationalMatrix2X2 add(RationalMatrix2X2 v) {
        RationalFraction l = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction l1 = new RationalFraction(v.a[0][0], v.a[0][1]);
        l.add2(l1);
        l1.setA(this.a[0][2]);
        l1.setB(this.a[0][3]);
        RationalFraction l2 = new RationalFraction(v.a[0][2], v.a[0][3]);
        l1.add2(l2);
        l2.setA(this.a[1][0]);
        l2.setB(this.a[1][1]);
        RationalFraction l3 = new RationalFraction(v.a[1][0], v.a[1][1]);
        l2.add2(l3);
        l3.setA(this.a[1][2]);
        l3.setB(this.a[1][3]);
        RationalFraction l4 = new RationalFraction(v.a[1][2], v.a[1][3]);
        l3.add2(l4);
        return new RationalMatrix2X2(l, l1, l2, l3);
    }

    public RationalMatrix2X2 mult(RationalMatrix2X2 v) {
        RationalFraction l = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction l1 = new RationalFraction(v.a[0][0], v.a[0][1]);
        RationalFraction l2 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalFraction l3 = new RationalFraction(v.a[0][2], v.a[0][3]);
        RationalFraction l4 = new RationalFraction(this.a[1][0], this.a[1][1]);
        RationalFraction l5 = new RationalFraction(v.a[1][0], v.a[1][1]);
        RationalFraction l6 = new RationalFraction(this.a[1][2], this.a[1][3]);
        RationalFraction l7 = new RationalFraction(v.a[1][2], v.a[1][3]);
        return new RationalMatrix2X2(l.mult(l1).add(l2.mult(l5)), l.mult(l3).add(l2.mult(l7)), l4.mult(l1).add(l6.mult(l5)), l4.mult(l3).add(l6.mult(l7)));
    }

    public RationalFraction det() {
        RationalFraction l = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction l1 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalFraction l2 = new RationalFraction(this.a[1][0], this.a[1][1]);
        RationalFraction l3 = new RationalFraction(this.a[1][2], this.a[1][3]);
        l.mult2(l3);
        l1.mult2(l2);
        if (l.equals(l1)) {
            return new RationalFraction();
        }
        l.sub2(l1);
        return new RationalFraction(l.getA(), l.getB());
    }

    public RationalVector2D multVector(RationalVector2D v) {

        RationalFraction l = new RationalFraction(this.a[0][0] * v.getX(), this.a[0][1] * v.getX1());
        RationalFraction l1 = new RationalFraction(this.a[0][2] * v.getY(), this.a[0][3] * v.getY1());
        l.add2(l1);
        l1.setA(this.a[1][0] * v.getX());
        l1.setB(this.a[1][1] * v.getX1());
        RationalFraction l2 = new RationalFraction(this.a[1][2] * v.getY(), this.a[1][3] * v.getY1());
        l1.add2(l2);
        return new RationalVector2D(new RationalFraction(l.getA(), l.getB()), new RationalFraction(l1.getA(), l1.getB()));
    }

    public String toString() {
        RationalFraction l = new RationalFraction(this.a[0][0], this.a[0][1]);
        RationalFraction l1 = new RationalFraction(this.a[0][2], this.a[0][3]);
        RationalFraction l2 = new RationalFraction(this.a[1][0], this.a[1][1]);
        RationalFraction l3 = new RationalFraction(this.a[1][2], this.a[1][3]);
        return l.toString() + " " + l1.toString() + "\n" + l2.toString() + " " + l3.toString();
    }

    public static void main(String[] args) {
        RationalMatrix2X2 x = new RationalMatrix2X2();
        System.out.println(x);//(0/1 0/1 0/1 0/1)
        RationalFraction y = new RationalFraction(5, 7);
        RationalFraction y1 = new RationalFraction(-1, 8);
        RationalMatrix2X2 x2 = new RationalMatrix2X2(y);
        System.out.println(x2);//(5/7 5/7 5/7 5/7)
        RationalMatrix2X2 x3 = new RationalMatrix2X2(y, y, y1, y1);
        System.out.println(x3);//(5/7 5/7 -1/8 -1/8)
        System.out.println(x3.add(x2));//(10/7 10/7 33/56 33/56)
        System.out.println(x3.mult(x2));//50/49 50/49 -5/28 -5/28)
        System.out.println(x3.det());
        RationalFraction z = new RationalFraction(5, 6);
        RationalFraction z1 = new RationalFraction(10, 11);
        RationalVector2D x1 = new RationalVector2D(z, z1);
        System.out.println(x1);
        System.out.println(x3.multVector(x1));//(575/462 , -115/528)


    }
}

