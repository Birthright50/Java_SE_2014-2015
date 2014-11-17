/**
 * Created by BirthrightL on 16.11.2014.
 */
public class RationalComplexVector2D {
    private RationalComplexNumber x;
    private RationalComplexNumber y;

    public RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
        this.x = x;
        this.y = y;
    }

    public RationalComplexVector2D() {
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }

    public RationalComplexNumber getX() {
        return x;
    }

    public void setX(RationalComplexNumber x) {
        this.x = x;
    }

    public RationalComplexNumber getY() {
        return y;
    }

    public void setY(RationalComplexNumber y) {
        this.y = y;
    }

    public RationalComplexVector2D add(RationalComplexVector2D v) {
        return new RationalComplexVector2D(this.x.add(v.getX()), this.y.add(v.getY()));
    }

    public String toString() {
       return this.x.toString()+" , "+this.y.toString();
    }

    public RationalComplexNumber scalarProduct(RationalComplexVector2D v) {
        RationalComplexNumber h = (this.x.mult(v.getX())).add(this.y.mult(v.getY()));
        return new RationalComplexNumber(h.getX(), h.getY());
    }

    public static void main(String[] args) {
        RationalComplexVector2D x = new RationalComplexVector2D();
        System.out.println(x);//0/1 + 0/1 * i , 0/1 + 0/1 * i
        RationalFraction y = new RationalFraction(5, 6);
        RationalFraction y1 = new RationalFraction(6, -9);
        RationalComplexNumber x1 = new RationalComplexNumber(y, y1);
        RationalFraction y2 = new RationalFraction(5, 6);
        RationalFraction y3 = new RationalFraction(6, -9);
        RationalComplexNumber x2 = new RationalComplexNumber(y2, y3);
        RationalComplexVector2D x3 = new RationalComplexVector2D(x1, x2);
        System.out.println(x3);//(5/6 - 6/9 * i , 5/6 - 6/9 * i)
        RationalFraction a = new RationalFraction(5, 6);
        RationalFraction b = new RationalFraction(6, -9);
        RationalComplexNumber e = new RationalComplexNumber(a, b);
        RationalFraction c = new RationalFraction(5, 6);
        RationalFraction d = new RationalFraction(6, -9);
        RationalComplexNumber f = new RationalComplexNumber(c, d);
        RationalComplexVector2D p = new RationalComplexVector2D(e, f);
        System.out.println(x3.add(p));//(5/3 - 4/3 * i , 5/3 - 4/3 * i)
        System.out.println(x3.scalarProduct(x3));//1/2 - 20/9 * i

    }


}
