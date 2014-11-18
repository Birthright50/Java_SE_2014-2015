/**
 * Created by BirthrightL on 15.11.2014.
 */
public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.getX(), this.y + v.getY());
    }

    public void add2(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public Vector2D sub(Vector2D v) {
        return new Vector2D(this.x - v.getY(), this.y - v.getY());
    }

    public void sub2(Vector2D v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public Vector2D mult(double v) {
        return new Vector2D(this.x * v, this.y * v);
    }

    public void mult2(double v) {
        this.x *= v;
        this.y *= v;
    }

    public String toString() {
        String g = "(" + this.x + " , " + this.y + ")";
        return g;
    }

    public double length() {
        double a = Math.sqrt(this.x * this.x + this.y * this.y);
        return a;
    }

    public double scalarProduct(Vector2D v) {
        double a = this.x * v.getX() + this.y * v.getY();
        return a;
    }

    public double cos(Vector2D v) {
        double a = (this.scalarProduct(v)) / this.length() / v.length();
        return a;
    }

    public boolean equals(Vector2D v) {
        if (this.x != v.getX()) {
            return false;
        }
        if (this.y != v.getY()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Vector2D x = new Vector2D();
        System.out.println(x);
        Vector2D x1 = new Vector2D(3, 3);
        System.out.println(x1);
        Vector2D x2 = new Vector2D(4, 5);
        Vector2D y = x1.add(x2);
        System.out.println(y);
        x1.add2(x2); //7, 8
        System.out.println(x1);
        x2=x2.sub(x1);
        System.out.println(x2); //-4, -3
        x2 = x2.mult(5);
        System.out.println(x2); //-20, -15
        System.out.println(x2.length()); //25
        System.out.println(x2.scalarProduct(x1)); //-260
        System.out.println(x2.equals(x1)); //false
        System.out.println(x2.cos(x1)); //-0.97...

    }
}
