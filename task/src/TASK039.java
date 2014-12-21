import java.util.Scanner;

/**
 * Created by BirthrightL on 19.10.2014.
 */
public class TASK039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        int p = sc.nextInt();
        int[] b = new int[p];
        int[] c = new int[6];
        for (int i = 0; i < p; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int l = 0; l < p; l++) {
            int f = 0;
            boolean qwerty = true;
            boolean qwerty1 = false;
            int w = b[l];
            int q = 0;
            while (b[l] > 0) {
                c[q] = b[l] % 10;
                b[l] /= 10;
                q++;
            }
            int o = q;
            //По строкам
            for (int i = 0; i < m; i++) {
                // →→→→
                for (int j = 0; j <= n - q; j++) {
                    while (c[0] == a[i][j] && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i][j + f]) {
                            o--;
                        } else {
                            f = 0;
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print(i + ":" + (j + u) + " ");
                            }
                            qwerty1 = true;
                            System.out.println();
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
                o = q;
                f = 0;
                qwerty = true;
                // ←←←←
                for (int j = n - 1; !qwerty1 && j > q - 2; j--) {
                    while (c[0] == a[i][j] && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i][j - f]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print(i + ":" + (j - u) + " ");
                            }
                            qwerty1 = true;
                            System.out.println();
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
            }
            o = q;
            f = 0;
            qwerty = true;
            //по столбцам
            for (int j = 0; !qwerty1 && j < n; j++) {
                // ↑↑↑↑↑
                for (int i = m - 1; !qwerty1 && i > q - 2; i--) {
                    while (c[0] == a[i][j] && (o > 0) && qwerty && !qwerty1) {
                        if (c[f] == a[i - f][j]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print((i - u) + ":" + j + " ");
                            }
                            qwerty1 = true;
                            System.out.println();
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
                o = q;
                f = 0;
                qwerty = true;

                //↓↓↓↓
                for (int i = 0; !qwerty1 && i <= m - q; i++) {
                    while ((c[0] == a[i][j]) && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i + f][j]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print((i + u) + ":" + j + " ");
                            }
                            qwerty1 = true;
                            System.out.println();
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
            }
            o = q;
            f = 0;
            qwerty = true;
//по диагонали
            for (int i = 0; !qwerty1 && i <= m - q; i++) {
//↓ →
                for (int j = 0; j <= n - q; j++) {
                    while (c[0] == a[i][j] && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i + f][j + f]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print(i + u + ":" + (j + u) + " ");
                            }
                            System.out.println();
                            qwerty1 = true;
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
//↓ ←
                o = q;
                for (int j = n - 1; (j > q - 2) && !qwerty1; j--) {
                    while (c[0] == a[i][j] && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i + f][j - f]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print((i + u) + ":" + (j - u) + " ");
                            }
                            System.out.println();
                            qwerty1 = true;
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
            }
            o = q;

            for (int i = m - 1; i >= q - 1 && !qwerty1; i--) {
//↑ →
                for (int j = 0; j <= n - q && !qwerty1; j++) {
                    while (c[0] == a[i][j] && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i - f][j + f]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print(i - u + ":" + (j + u) + " ");
                            }
                            qwerty1 = true;
                            System.out.println();
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;

                }
                o = q;
//↑ ←
                for (int j = n - 1; (j > q - 2) && (!qwerty1); j--) {
                    while (c[0] == a[i][j] && o > 0 && qwerty && !qwerty1) {
                        if (c[f] == a[i - f][j - f]) {
                            o--;
                        } else {
                            o = q;
                            qwerty = false;
                        }
                        if (o == 0) {
                            System.out.print(w + ": ");
                            for (int u = q - 1; u >= 0; u--) {
                                System.out.print(i - u + ":" + (j - u) + " ");
                            }
                            qwerty1 = true;
                            System.out.println();
                        }
                        f++;
                    }
                    f = 0;
                    qwerty = true;
                }
            }
            if (!qwerty1) {
                System.out.println(w + ": " + "нет");
            }
        }
    }
}




