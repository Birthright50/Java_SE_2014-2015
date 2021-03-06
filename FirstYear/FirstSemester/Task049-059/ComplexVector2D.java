/**
 * Created by BirthrightL on 16.11.2014.
 */
public class ComplexVector2D {
    private ComplexNumber x;
    private ComplexNumber y;


    public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
        this.x = x;
        this.y = y;
    }

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());
    }

    public ComplexNumber getX() {
        return x;
    }

    public void setX(ComplexNumber x) {
        this.x = x;
    }

    public ComplexNumber getY() {
        return y;
    }

    public void setY(ComplexNumber y) {
        this.y = y;
    }

    public ComplexVector2D add(ComplexVector2D v) {
        return new ComplexVector2D(this.x.add(v.getX()), this.y.add(v.getY()));
    }

    public String toString() {
        return this.x.toString() + " , " + this.y.toString();
    }

    public ComplexNumber scalarProduct(ComplexVector2D v) {
        ComplexNumber h = (this.x.mult(v.getX())).add(this.y.mult(v.getY()));
        return new ComplexNumber(h.getReal(), h.getImaginary());
    }

    public boolean equals(ComplexVector2D v) {
        if (this.x != v.getX()) {
            return false;
        }
        if (this.y != v.getY()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ComplexVector2D x = new ComplexVector2D();
        System.out.println(x);//0+0*i, 0+0*i
        ComplexNumber y = new ComplexNumber(5, 7);
        ComplexNumber y1 = new ComplexNumber(3, 8);
        ComplexVector2D x1 = new ComplexVector2D(y, y1);
        System.out.println(x1);//5+7*i, 3+8*i
        ComplexNumber y2 = new ComplexNumber(9, 10);
        ComplexNumber y3 = new ComplexNumber(33, 22);
        ComplexVector2D x2 = new ComplexVector2D(y2, y3);
        System.out.println(x2);//9+10*i, 33+22*i;
        System.out.println(x2.add(x1));//14+17*i, 38+25*i
        System.out.println(x2.scalarProduct(x1));//-102.0 + 443.0 * i
        System.out.println(x2.equals(x1));//false

    }

}
