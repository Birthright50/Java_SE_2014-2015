/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalMatrix2X2 {
    private RationalFraction[][] a = new RationalFraction[2][2];


    public RationalMatrix2X2() {
        this(new RationalFraction());
    }

    public RationalMatrix2X2(RationalFraction v, RationalFraction v1, RationalFraction v2, RationalFraction v3) {
        this.a[0][0] = v;
        this.a[0][1] = v1;
        this.a[1][0] = v2;
        this.a[1][1] = v3;
    }

    public RationalMatrix2X2(RationalFraction a) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] = a;
            }
        }
    }

    public RationalFraction[][] getA() {
        return a;
    }

    public void setA(RationalFraction[][] a) {
        this.a = a;
    }

    public RationalMatrix2X2 add(RationalMatrix2X2 v) {
        return new RationalMatrix2X2((this.a[0][0]).add(v.a[0][0]), this.a[0][1].add(v.a[0][1]), (this.a[1][1]).add(v.a[1][0]), (this.a[1][1]).add(v.a[1][1]));
    }

    public RationalMatrix2X2 mult(RationalMatrix2X2 v) {
        return new RationalMatrix2X2((this.a[0][0].mult(v.a[0][0]).add(this.a[0][1].mult(v.a[1][0]))), (this.a[0][0].mult(v.a[0][1]).add(this.a[0][1].mult(v.a[1][1]))), (this.a[1][0].mult(v.a[0][0]).add(this.a[1][1].mult(v.a[1][0]))), (this.a[1][0].mult(v.a[0][1]).add(this.a[1][1].mult(v.a[1][1]))));
    }

    public RationalFraction det() {
        if((this.a[0][0].mult(this.a[1][1])).equals(this.a[1][0].mult(this.a[0][1]))){
            return new RationalFraction();
        }
        RationalFraction x = (this.a[0][0].mult(this.a[1][1])).sub(this.a[1][0].mult(this.a[0][1]));
        return new RationalFraction(x.getNumerator(), x.getDenominator());
    }

    public RationalVector2D multVector(RationalVector2D v) {
        return new RationalVector2D((this.a[0][0].mult(v.getX()).add(this.a[0][1].mult(v.getY()))), (this.a[1][0].mult(v.getX()).add(this.a[1][1].mult(v.getY()))));
    }

    public String toString() {
        return this.a[0][0].toString() + " " + this.a[0][1].toString() + "\n" + this.a[1][0].toString() + " " + this.a[1][1].toString();
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

