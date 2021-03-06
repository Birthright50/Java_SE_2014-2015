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
    @author(name = "Peter")
    public double getX() {
        return x;
    }
    @author(name = "Tramp")
    public void setX(double x) {
        this.x = x;
    }
    @author(name = "Tramp")
    public double getY() {
        return y;
    }
    @author(name = "Walker")
    public void setY(double y) {
        this.y = y;
    }
    @author(name = "Peter")
    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.getX(), this.y + v.getY());
    }
    @author(name = "Walker")
    public void add2(Vector2D v) {
        this.x += v.getX();
        this.y += v.getY();
    }
    @author(name = "John")
    public Vector2D sub(Vector2D v) {
        return new Vector2D(this.x - v.getY(), this.y - v.getY());
    }
    @author(name = "John")
    public void sub2(Vector2D v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }
    @author(name = "Fairman")
    public Vector2D mult(double v) {
        return new Vector2D(this.x * v, this.y * v);
    }
    @author(name = "Fairman")
    public void mult2(double v) {
        this.x *= v;
        this.y *= v;
    }
    @author(name = "Fairman")
    public String toString() {
        return "(" + this.x + " , " + this.y + ")";
    }
    @author(name = "Fairman")
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    @author(name = "Peter")
    public double scalarProduct(Vector2D v) {
        return this.x * v.getX() + this.y * v.getY();
    }
    @author(name = "Walker")
    public double cos(Vector2D v) {
        return (this.scalarProduct(v)) / this.length() / v.length();
    }
    @author(name = "Walker")
    public boolean equals(Vector2D v) {
        return this.x == v.getX() && this.y == v.getY();
    }

}