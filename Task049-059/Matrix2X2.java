import java.util.Scanner;

/**
 * Created by BirthrightL on 16.11.2014.
 */
public class Matrix2X2 {
    private double[][] a = new double[2][2];
    static Scanner sc = new Scanner(System.in);

    public Matrix2X2(double[][] a) {
        this.a = a;
    }

    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                s += a[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }

    public Matrix2X2(double x, double h, double z, double y) {
        this.a[0][0] = x;
        this.a[0][1] = h;
        this.a[1][0] = z;
        this.a[1][1] = y;
    }

    public Matrix2X2(double a) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] = a;
            }
        }
    }

    public Matrix2X2() {
        this(0);
    }

    public void transpon() {
        double b[][] = new double[2][2];
        for (int i = 0; i < 2; ++i)
            for (int j = 0; j < 2; ++j)
                b[j][i] = this.a[i][j];
        a = b;
    }

    public Matrix2X2 add(Matrix2X2 v) {
        Matrix2X2 h = new Matrix2X2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                h.a[i][j] = this.a[i][j] + v.a[i][j];
            }
        }
        return h;
    }

    public void add2(Matrix2X2 v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] += v.a[i][j];
            }
        }
    }

    public Matrix2X2 sub(Matrix2X2 v) {
        Matrix2X2 h = new Matrix2X2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                h.a[i][j] = this.a[i][j] - v.a[i][j];
            }
        }
        return h;
    }

    public void sub2(Matrix2X2 v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] -= v.a[i][j];
            }
        }
    }

    public Matrix2X2 multNumber(double v) {
        Matrix2X2 h = new Matrix2X2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                h.a[i][j] = this.a[i][j] * v;
            }
        }
        return h;
    }

    public void multNumber2(double v) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] *= v;
            }
        }
    }

    public Matrix2X2 mult(Matrix2X2 v) {
        return new Matrix2X2(this.a[0][0] * v.a[0][0] + this.a[0][1] * v.a[1][0], this.a[0][0] * v.a[0][1] + this.a[0][1] * v.a[1][1], this.a[1][0] * v.a[0][0] + this.a[1][1] * v.a[1][0], this.a[1][0] * v.a[0][1] + this.a[1][1] * v.a[1][1]);
    }

    public void mul2(Matrix2X2 v) {
        this.a[0][0] = this.a[0][0] * v.a[0][0] + this.a[0][1] * v.a[1][0];
        this.a[0][1] = this.a[0][0] * v.a[0][1] + this.a[0][1] * v.a[1][1];
        this.a[1][0] = this.a[1][0] * v.a[0][0] + this.a[1][1] * v.a[1][0];
        this.a[1][1] = this.a[1][0] * v.a[0][1] + this.a[1][1] * v.a[1][1];
    }

    public double det() {

        return this.a[0][0] * this.a[1][1] - this.a[1][0] * this.a[0][1];
    }

    public Matrix2X2 inverseMatrix() {
        if (this.det() != 0) {
            Matrix2X2 h = new Matrix2X2(1, 0, 0, 1);
            double k = this.a[1][0] / this.a[0][0];
            h.a[1][0] = h.a[1][0] - k * h.a[0][0];
            double b = this.a[1][1] - this.a[0][1] * k;
            h.a[1][1] = h.a[1][1] - k * h.a[0][1];
            k = this.a[0][1] / b;
            h.a[0][1] = h.a[0][1] - k * h.a[1][1];
            h.a[0][0] = h.a[0][0] - k * h.a[1][0];
            h.a[0][0] /= this.a[0][0];
            h.a[0][1] /= this.a[0][0];
            h.a[1][0] /= b;
            h.a[1][1] /= b;
            return h;
        } else {
            System.out.println("Обратной матрицы не существует");
            return new Matrix2X2();
        }
    }

    public Matrix2X2 equivalentDiagonal() {
        Matrix2X2 v = new Matrix2X2();
        for (int i = 0; i < 2; i++) {
            v.a[i][i] = this.a[i][i];
        }
        return v;
    }

    public Vector2D multVector(Vector2D v) {
        return new Vector2D(this.a[0][0] * v.getX() + this.a[0][1] * v.getY(), this.a[1][0] * v.getX() + this.a[1][1] * v.getY());
    }

    public static void main(String[] args) {
        Matrix2X2 x = new Matrix2X2();
        System.out.println(x);//0 0 0 0
        Matrix2X2 x1 = new Matrix2X2(5);
        System.out.println(x1);// 5 5 5 5
        Matrix2X2 x2 = new Matrix2X2(1, 2, 3, 4);
        System.out.println(x2);//1,2,3,4
        System.out.println(x2.add(x1));//6,7,8,9
        System.out.println(x2.sub(x1));//-4, -3, -2, -1
        System.out.println(x2.multNumber(5));//5,10,15,20
        System.out.println(x2.mult(x1));//15 15 35 35
        System.out.println(x2.det());//-2
        x2.transpon();
        System.out.println(x2); //1,3,2,4
        System.out.println(x1.inverseMatrix());//Обратной матрицы не существует 0, 0, 0, 0
        System.out.println(x2.inverseMatrix());// -2, 1.5, 1, -0.5
        System.out.println(x2.equivalentDiagonal());//1, 0, 0, 4
        Vector2D j = new Vector2D(5, 6);
        System.out.println(x2.multVector(j));//23, 34
        Matrix2X2 h = new Matrix2X2(1, 2, 1, 2);
        System.out.println(h.det());
        double m[][] = {
                {1, 2},
                {3, 4},

        };
        Matrix2X2 l2 = new Matrix2X2(m);
        System.out.println(l2);//1,2,3,4
    }
}
