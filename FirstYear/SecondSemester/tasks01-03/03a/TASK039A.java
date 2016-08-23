import java.util.Scanner;

/**
 * Created by $(Birthright) on $(07.02.2015.)
 */
public class TASK039A {
    static Scanner sc = new Scanner(System.in);

    public static int[] scanner1(int[] b, int p, int i) {
        if (i == p) {
            return b;
        }
        b[i] = sc.nextInt();
        return scanner1(b, p, i + 1);
    }

    public static int[][] scanner3(int[][] a, int n, int i, int j) {
        if (j == n) {
            return a;
        }
        a[i][j] = sc.nextInt();
        return scanner3(a, n, i, j + 1);
    }

    public static int[][] scanner2(int[][] a, int m, int n, int i, int j) {
        if (i == m) {
            return a;
        }
        a = scanner3(a, n, i, j);
        return scanner2(a, m, n, i + 1, j);
    }

    public static void method1(int[][] a, int[] b, int p, int m, int n) {
        if (l == p) {
            return;
        }
        f = 0;
        qwerty = true;
        qwerty1 = false;
        w = b[l];
        q = 0;
        q = method2(b, l);
        o = q;
        //По строкам
        qwerty1 = line(a, m, n);
        o = q;
        f = 0;
        qwerty = true;
        //По столбцам
        j = 0;
        qwerty1 = column(a, m, n);
        o = q;
        f = 0;
        qwerty = true;
//по диагонали вниз
        i = 0;
        qwerty1 = diagonalDown(a, m, n);
        o = q;
//по диагонали вверх
        qwerty1 = diagonalUp(a, n);
        if (!qwerty1) {
            System.out.println(w + ": " + "нет");
        }
        l += 1;
        method1(a, b, p, m, n);
    }

    public static boolean diagonalUp(int[][] a, int n) {
        if (i < q - 1 || qwerty1) {
            return qwerty1;
        }
        //↑ →
        j = 0;
        qwerty1 = diagonalUp1(a, n);
        o = q;
        j = n - 1;
        //↑ ←
        qwerty1 = diagonalUp4(a);
        i -= 1;
        return diagonalUp(a, n);
    }

    public static boolean diagonalUp4(int[][] a) {
        if ((j <= q - 2) || (qwerty1)) {
            return qwerty1;
        }
        qwerty1 = diagonalUp5(a);
        f = 0;
        qwerty = true;
        j -= 1;
        return diagonalUp4(a);
    }

    public static boolean diagonalUp5(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i - f][j - f]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            diagonalUp6(u, i, j);
            qwerty1 = true;
            System.out.println();
        }
        f++;
        return diagonalUp5(a);
    }

    public static void diagonalUp6(int u, int i, int j) {
        if (u < 0) {
            return;
        }
        System.out.print(i - u + ":" + (j - u) + " ");
        diagonalUp6(u - 1, i, j);
    }

    public static boolean diagonalUp1(int[][] a, int n) {
        if (j > n - q || qwerty1) {
            return qwerty1;
        }
        qwerty1 = diagonalUp2(a);
        f = 0;
        qwerty = true;
        j += 1;
        return diagonalUp1(a, n);
    }

    public static boolean diagonalUp2(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i - f][j + f]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            diagonalUp3(u, j, i);
            qwerty1 = true;
            System.out.println();
        }
        f++;
        return diagonalUp2(a);
    }

    public static void diagonalUp3(int u, int j, int i) {
        if (u < 0) {
            return;
        }
        System.out.print(i - u + ":" + (j + u) + " ");
        diagonalUp3(u - 1, j, i);
    }

    public static boolean diagonalDown(int[][] a, int m, int n) {
        if (qwerty1 || i > m - q) {
            return qwerty1;
        }
        //↓ →
        j = 0;
        qwerty1 = diagonalDown1(a, n);
        o = q;
        j = n - 1;
        //↓ ←
        qwerty1 = diagonalDown4(a);
        i += 1;
        return diagonalDown(a, m, n);
    }

    public static boolean diagonalDown4(int[][] a) {
        if ((j <= q - 2) || qwerty) {
            return qwerty1;
        }
        qwerty1 = diagonalDown5(a);
        f = 0;
        qwerty = true;
        j -= 1;
        return diagonalDown4(a);
    }

    public static boolean diagonalDown5(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i + f][j - f]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            diagonalDown6(u, i, j);
            System.out.println();
            qwerty1 = true;
        }
        f++;
        return diagonalDown5(a);
    }

    public static void diagonalDown6(int u, int i, int j) {
        if (u < 0) {
            return;
        }
        System.out.print((i + u) + ":" + (j - u) + " ");
        diagonalDown6(u - 1, i, j);
    }

    public static boolean diagonalDown1(int[][] a, int n) {
        if (j > n - q) {
            return qwerty1;
        }
        qwerty1 = diagonalDown2(a);
        f = 0;
        qwerty = true;
        j += 1;
        return diagonalDown1(a, n);
    }

    public static boolean diagonalDown2(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i + f][j + f]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            diagonalDown3(u, j, i);
            System.out.println();
            qwerty1 = true;
        }
        f++;
        return diagonalDown2(a);
    }

    public static void diagonalDown3(int u, int j, int i) {
        if (u < 0) {
            return;
        }
        System.out.print(i + u + ":" + (j + u) + " ");
        diagonalDown3(u - 1, j, i);
    }

    public static boolean column(int[][] a, int m, int n) {
        if (j >= n || qwerty1) {
            return qwerty1;
        }
        // ↑↑↑↑↑
        i = m - 1;
        qwerty1 = column1(a);
        o = q;
        f = 0;
        qwerty = true;
        i = 0;
        // ↓↓↓↓
        qwerty1 = column4(a, m);
        j += 1;
        return column(a, m, n);
    }

    public static boolean column4(int[][] a, int m) {
        if (qwerty1 || i > m - q) {
            return qwerty1;
        }
        qwerty1 = column5(a);
        o = q;
        f = 0;
        qwerty = true;
        i += 1;
        return column4(a, m);
    }

    public static boolean column5(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i + f][j]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            column6(u, i, j);
            qwerty1 = true;
            System.out.println();
        }
        f++;
        return column5(a);
    }

    public static void column6(int u, int i, int j) {
        if (u < 0) {
            return;
        }
        System.out.print((i + u) + ":" + j + " ");
        column6(u - 1, i, j);
    }

    public static boolean column1(int[][] a) {
        if (qwerty1 || i <= q - 2) {
            return qwerty1;
        }
        qwerty1 = column2(a);
        f = 0;
        qwerty = true;
        i -= 1;
        return column1(a);
    }

    public static boolean column2(int[][] a) {
        if (c[0] != a[i][j] || (o <= 0) || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i - f][j]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            column3(u, i, j);
            qwerty1 = true;
            System.out.println();
        }
        f++;
        return column2(a);
    }

    public static void column3(int u, int i, int j) {
        if (u < 0) {
            return;
        }
        System.out.print((i - u) + ":" + j + " ");
        column3(u - 1, i, j);
    }

    public static boolean line(int[][] a, int m, int n) {
        if (i == m) {
            return qwerty1;
        }

        // →→→→
        qwerty1 = line1(a, n);
        o = q;
        f = 0;
        qwerty = true;
        // ←←←←
        j = n - 1;
        qwerty1 = line4(a);
        i += 1;
        return line(a, m, n);
    }

    public static boolean line4(int[][] a) {
        if (qwerty1 || j <= q - 2) {
            return qwerty1;
        }
        qwerty1 = line5(a);
        f = 0;
        qwerty = true;
        j -= 1;
        return line4(a);
    }

    public static boolean line5(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i][j - f]) {
            o--;
        } else {
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            line6(u, i, j);
            qwerty1 = true;
            System.out.println();
        }
        f++;
        return line5(a);
    }

    public static void line6(int u, int i, int j) {
        if (u < 0) {
            return;
        }
        System.out.print(i + ":" + (j - u) + " ");
        line6(u - 1, i, j);

    }

    public static boolean line1(int[][] a, int n) {
        if (j > n - q) {
            return qwerty1;
        }
        qwerty1 = line2(a);
        f = 0;
        qwerty = true;
        j += 1;
        return line1(a, n);
    }

    public static boolean line2(int[][] a) {
        if (c[0] != a[i][j] || o <= 0 || !qwerty || qwerty1) {
            return qwerty1;
        }
        if (c[f] == a[i][j + f]) {
            o--;
        } else {
            f = 0;
            o = q;
            qwerty = false;
        }
        if (o == 0) {
            System.out.print(w + ": ");
            u = q - 1;
            line3(u, i, j);
            qwerty1 = true;
            System.out.println();
        }
        f++;
        return line2(a);
    }

    public static void line3(int u, int i, int j) {
        if (u < 0) {
            return;
        }
        System.out.print(i + ":" + (j + u) + " ");
        line3(u - 1, i, j);

    }

    public static int method2(int[] b, int l) {
        if (b[l] == 0) {
            return q;
        }
        c[q] = b[l] % 10;
        b[l] /= 10;
        q++;
        return method2(b, l);
    }

    static int f;
    static boolean qwerty;
    static boolean qwerty1;
    static int w;
    static int q;
    static int o;
    static int i = 0;
    static int j = 0;
    static int l = 0;
    static int u = 0;
    static int[] c = new int[6];

    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        int p = sc.nextInt();
        int[] b = new int[p];
        a = scanner2(a, m, n, i, j);
        b = scanner1(b, p, i);
        method1(a, b, p, m, n);

    }
}
