import java.util.Scanner;

/**
 * Created by BirthrightL on 19.10.2014.
 */
public class TASK039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int p = sc.nextInt();
        int[] b = new int[p];
        for (int i = 0; i < p; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < p; i++) {
            int q = b[i];
            boolean lal = false;
            if (b[i] / 100000 > 0) {
                int r, t, y, u, o, l;

                r = q % 10;
                q = q / 10;
                t = q % 10;
                q = q / 10;
                y = q % 10;
                q = q / 10;
                u = q % 10;
                q = q / 10;
                o = q % 10;
                q = q / 10;
                l = q % 10;
                //по строкам
                for (int j = 0; j < n; j++) {
                    for (int lk = 0; lk + 5 < m && lk < m; lk++) {
                        if (a[j][lk] == l) {
                            if (a[j][lk + 1] == o) {
                                if (a[j][lk + 2] == u) {
                                    if (a[j][lk + 3] == y) {
                                        if (a[j][lk + 4] == t) {
                                            if (a[j][lk + 5] == r) {
                                                System.out.println(b[i] + ": " + (j + ":" + lk) + " " + (j + ":" + (lk + 1)) + " " + (j + ":" + (lk + 2)) + " " + (j + ":" + (lk + 3)) + " " + (j + ":" + (lk + 4)) + " " + (j + ":" + (lk + 5)));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        if (a[j][lk + 5] == l) {
                            if (a[j][lk + 4] == o) {
                                if (a[j][lk + 3] == u) {
                                    if (a[j][lk + 2] == y) {
                                        if (a[j][lk + 1] == t) {
                                            if (a[j][lk] == r) {
                                                System.out.println(b[i] + ": " + j + ":" + (lk + 5) + " " + j + ":" + (lk + 4) + " " + j + ":" + (lk + 3) + " " + j + ":" + (lk + 2) + " " + j + ":" + (lk + 1) + " " + j + ":" + lk);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //по столбцам
                for (int j = 0; j < m; j++) {
                    for (int lk = 0; lk + 5 < n && lk < m; lk++) {
                        if (a[lk][j] == l) {
                            if (a[lk + 1][j] == o) {
                                if (a[lk + 2][j] == u) {
                                    if (a[lk + 3][j] == y) {
                                        if (a[lk + 4][j] == t) {
                                            if (a[lk + 5][j] == r) {
                                                System.out.println(b[i] + ": " + lk + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk + 2) + ":" + (j) + " " + (lk + 3) + ":" + (j) + " " + (lk + 4) + ":" + (j) + " " + (lk + 5) + ":" + j);
                                                lal = true;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                        if (a[lk + 5][j] == l) {
                            if (a[lk + 4][j] == o) {
                                if (a[lk + 3][j] == u) {
                                    if (a[lk + 2][j] == y) {
                                        if (a[lk + 1][j] == t) {
                                            if (a[lk][j] == r) {
                                                System.out.println(b[i] + ": " + (lk + 5) + ":" + (j) + " " + (lk + 2) + ":" + (j) + " " + (lk + 3) + ":" + (j) + " " + (lk + 4) + ":" + (j) + " " + (lk + 5) + ":" + (j) + " " + (lk) + ":" + j);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //по диагонали слева(строки)
                for (int j = 0; j < n; j++) {
                    int ram = j;
                    for (int lk = 0; ram + 5 < n && lk + 5 < m && lk < m; lk++, ram++) {
                        if (a[ram][lk] == l) {
                            if (a[ram + 1][lk + 1] == o) {
                                if (a[ram + 2][lk + 2] == u) {
                                    if (a[ram + 3][lk + 3] == y) {
                                        if (a[ram + 4][lk + 4] == t) {
                                            if (a[ram + 5][lk + 5] == r) {
                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 4) + ":" + (lk + 4) + " " + (ram + 5) + ":" + (lk + 5));
                                                lal = true;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                        if (a[ram + 5][lk + 5] == l) {
                            if (a[ram + 4][lk + 4] == o) {
                                if (a[ram + 3][lk + 3] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 5) + ":" + (lk + 5) + " " + (ram + 4) + ":" + (lk + 4) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //по диагонали слева(столбцы)
                for (int j = 0; j < n; j++) {
                    int ram = j;
                    for (int lk = 1; ram + 5 < n && lk + 5 < m && lk < m; lk++, ram++) {
                        if (a[ram][lk] == l) {
                            if (a[ram + 1][lk + 1] == o) {
                                if (a[ram + 2][lk + 2] == u) {
                                    if (a[ram + 3][lk + 3] == y) {
                                        if (a[ram + 4][lk + 4] == t) {
                                            if (a[ram + 5][lk + 5] == r) {
                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 4) + ":" + (lk + 4) + " " + (ram + 5) + ":" + (lk + 5));

                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a[ram + 5][lk + 5] == l) {
                            if (a[ram + 4][lk + 4] == o) {
                                if (a[ram + 3][lk + 3] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 5) + ":" + (lk + 5) + " " + (ram + 4) + ":" + (lk + 4) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //по диагонали справа(строки)
                for (int j = 0; j < n; j++) {
                    int ram = j;
                    for (int lk = m - 1; ram + 5 < n && lk - 5 >= 0 && lk >= 0; lk--, ram++) {
                        if (a[ram][lk] == l) {
                            if (a[ram + 1][lk - 1] == o) {
                                if (a[ram + 2][lk - 2] == u) {
                                    if (a[ram + 3][lk - 3] == y) {
                                        if (a[ram + 4][lk - 4] == t) {
                                            if (a[ram + 5][lk - 5] == r) {
                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 3) + ":" + (lk - 3) + " " + (ram + 4) + ":" + (lk - 4) + " " + (ram + 5) + ":" + (lk - 5));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a[ram + 5][lk - 5] == l) {
                            if (a[ram + 4][lk - 4] == o) {
                                if (a[ram + 3][lk - 3] == u) {
                                    if (a[ram + 2][lk - 2] == y) {
                                        if (a[ram + 1][lk - 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 5) + ":" + (lk - 5) + " " + (ram + 4) + ":" + (lk - 4) + " " + (ram + 3) + ":" + (lk - 3) + " " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //по диагонали справа(столбцы)
                for (int j = m - 2; j >= 0; j--) {
                    int ram = j;
                    for (int lk = 0; ram - 5 >= 0 && lk + 5 < n && lk < n; lk++, ram--) {
                        if (a[lk][ram] == l) {
                            if (a[lk + 1][ram - 1] == o) {
                                if (a[lk + 2][ram - 2] == u) {
                                    if (a[lk + 3][ram - 3] == y) {
                                        if (a[lk + 4][ram - 4] == t) {
                                            if (a[lk + 5][ram - 5] == r) {
                                                System.out.println(b[i] + ": " + lk + ":" + (ram) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 3) + ":" + (ram - 3) + " " + (lk + 4) + ":" + (ram - 4) + " " + (lk + 5) + ":" + (ram - 5));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (a[lk + 5][ram - 5] == l) {
                            if (a[lk + 4][ram - 4] == o) {
                                if (a[lk + 3][ram - 3] == u) {
                                    if (a[lk + 2][ram - 2] == y) {
                                        if (a[lk + 1][ram - 1] == t) {
                                            if (a[lk][ram] == r) {
                                                System.out.println(b[i] + ": " + (lk + 5) + ":" + (ram - 5) + " " + (lk + 4) + ":" + (ram - 4) + " " + (lk + 3) + ":" + (ram - 3) + " " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk) + ":" + (ram));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            } else

            {
                if (b[i] / 10000 > 0) {
                    int r, t, y, u, o = 0;
                    r = q % 10;
                    q = q / 10;
                    t = q % 10;
                    q = q / 10;
                    y = q % 10;
                    q = q / 10;
                    u = q % 10;
                    q = q / 10;
                    o = q % 10;

                    //по строкам
                    for (int j = 0; j < n; j++) {
                        for (int lk = 0; lk + 4 < m && lk < m; lk++) {
                            if (a[j][lk] == o) {
                                if (a[j][lk + 1] == u) {
                                    if (a[j][lk + 2] == y) {
                                        if (a[j][lk + 3] == t) {
                                            if (a[j][lk + 4] == r) {
                                                System.out.println(b[i] + ": " + (j + ":" + lk) + " " + (j + ":" + (lk + 1)) + " " + (j + ":" + (lk + 2)) + " " + (j + ":" + (lk + 3)) + " " + (j + ":" + (lk + 4)));
                                                lal = true;
                                            }
                                        }
                                    }
                                }

                            }
                            if (a[j][lk + 4] == o) {
                                if (a[j][lk + 3] == u) {
                                    if (a[j][lk + 2] == y) {
                                        if (a[j][lk + 1] == t) {
                                            if (a[j][lk] == r) {

                                                System.out.println(b[i] + ": " + j + ":" + (lk + 4) + " " + j + ":" + (lk + 3) + " " + j + ":" + (lk + 2) + " " + j + ":" + (lk + 1) + " " + j + ":" + lk);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //по столбцам
                    for (int j = 0; j < m; j++) {
                        for (int lk = 0; lk + 4 < n && lk < m; lk++) {
                            if (a[lk][j] == o) {
                                if (a[lk + 1][j] == u) {
                                    if (a[lk + 2][j] == y) {
                                        if (a[lk + 3][j] == t) {
                                            if (a[lk + 4][j] == r) {

                                                System.out.println(b[i] + ": " + lk + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk + 2) + ":" + (j) + " " + (lk + 3) + ":" + (j) + " " + (lk + 4) + ":" + (j));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }

                            if (a[lk + 4][j] == o) {
                                if (a[lk + 3][j] == u) {
                                    if (a[lk + 2][j] == y) {
                                        if (a[lk + 1][j] == t) {
                                            if (a[lk][j] == r) {
                                                System.out.println(b[i] + ": " + (lk + 4) + ":" + (j) + " " + (lk + 3) + ":" + (j) + " " + (lk + 2) + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk) + ":" + j);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    //по диагонали слева(строки)
                    for (int j = 0; j < n; j++) {
                        int ram = j;
                        for (int lk = 0; ram + 4 < n && lk + 4 < m && lk < m; lk++, ram++) {
                            if (a[ram][lk] == o) {
                                if (a[ram + 1][lk + 1] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 3][lk + 3] == t) {
                                            if (a[ram + 4][lk + 4] == r) {

                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 4) + ":" + (lk + 4));
                                                lal = true;
                                            }

                                        }
                                    }
                                }
                            }
                            if (a[ram + 4][lk + 4] == o) {
                                if (a[ram + 3][lk + 3] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 4) + ":" + (lk + 4) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //по диагонали слева(столбцы)
                    for (int j = 0; j < n; j++) {
                        int ram = j;
                        for (int lk = 1; ram + 4 < n && lk + 4 < m && lk < m; lk++, ram++) {
                            if (a[ram][lk] == o) {
                                if (a[ram + 1][lk + 1] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 3][lk + 3] == t) {
                                            if (a[ram + 4][lk + 4] == r) {

                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 4) + ":" + (lk + 4));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                            if (a[ram + 4][lk + 4] == o) {
                                if (a[ram + 3][lk + 3] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 4) + ":" + (lk + 4) + " " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //по диагонали справа(строки)
                    for (int j = 0; j < n; j++) {
                        int ram = j;
                        for (int lk = m - 1; ram + 4 < n && lk - 4 >= 0 && lk >= 0; lk--, ram++) {
                            if (a[ram][lk] == o) {
                                if (a[ram + 1][lk - 1] == u) {
                                    if (a[ram + 2][lk - 2] == y) {
                                        if (a[ram + 3][lk - 3] == t) {
                                            if (a[ram + 4][lk - 4] == t) {
                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 3) + ":" + (lk - 3) + " " + (ram + 4) + ":" + (lk - 4));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }

                            if (a[ram + 4][lk - 4] == o) {
                                if (a[ram + 3][lk - 3] == u) {
                                    if (a[ram + 2][lk - 2] == y) {
                                        if (a[ram + 1][lk - 1] == t) {
                                            if (a[ram][lk] == r) {

                                                System.out.println(b[i] + ": " + (ram + 4) + ":" + (lk - 4) + " " + (ram + 3) + ":" + (lk - 3) + " " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //по диагонали справа(столбцы)
                    for (int j = m - 2; j >= 0; j--) {
                        int ram = j;
                        for (int lk = 0; ram - 4 >= 0 && lk + 4 < n && lk < n; lk++, ram--) {
                            if (a[lk][ram] == o) {
                                if (a[lk + 1][ram - 1] == u) {
                                    if (a[lk + 2][ram - 2] == y) {
                                        if (a[lk + 3][ram - 3] == t) {
                                            if (a[lk + 4][ram - 4] == r) {
                                                System.out.println(b[i] + ": " + lk + ":" + (ram) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 3) + ":" + (ram - 3) + " " + (lk + 4) + ":" + (ram - 4));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                            if (a[lk + 4][ram - 4] == o) {
                                if (a[lk + 3][ram - 3] == u) {
                                    if (a[lk + 2][ram - 2] == y) {
                                        if (a[lk + 1][ram - 1] == t) {
                                            if (a[lk][ram] == r) {
                                                System.out.println(b[i] + ": " + (lk + 4) + ":" + (ram - 4) + " " + (lk + 3) + ":" + (ram - 3) + " " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk) + ":" + (ram));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                } else {
                    if (b[i] / 1000 > 0) {
                        int r, t, y, u = 0;
                        r = q % 10;
                        q = q / 10;
                        t = q % 10;
                        q = q / 10;
                        y = q % 10;
                        q = q / 10;
                        u = q % 10;
                        //по строкам
                        for (int j = 0; j < n; j++) {
                            for (int lk = 0; lk + 3 < m && lk < m; lk++) {
                                if (a[j][lk] == u) {
                                    if (a[j][lk + 1] == y) {
                                        if (a[j][lk + 2] == t) {
                                            if (a[j][lk + 3] == r) {

                                                System.out.println(b[i] + ": " + (j + ":" + lk) + " " + (j + ":" + (lk + 1)) + " " + (j + ":" + (lk + 2)) + " " + (j + ":" + (lk + 3)));
                                                lal = true;
                                            }
                                        }
                                    }

                                }
                                if (a[j][lk + 3] == u) {
                                    if (a[j][lk + 2] == y) {
                                        if (a[j][lk + 1] == t) {
                                            if (a[j][lk] == r) {
                                                System.out.println(b[i] + ": " + j + ":" + (lk + 3) + " " + j + ":" + (lk + 2) + " " + j + ":" + (lk + 1) + " " + j + ":" + lk);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //по столбцам
                        for (int j = 0; j < m; j++) {
                            for (int lk = 0; lk + 3 < n && lk < m; lk++) {
                                if (a[lk][j] == u) {
                                    if (a[lk + 1][j] == y) {
                                        if (a[lk + 2][j] == t) {
                                            if (a[lk + 3][j] == r) {


                                                System.out.println(b[i] + ": " + lk + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk + 2) + ":" + (j) + " " + (lk + 3) + ":" + (j));
                                                lal = true;
                                            }
                                        }
                                    }
                                }

                                if (a[lk + 3][j] == u) {
                                    if (a[lk + 2][j] == y) {
                                        if (a[lk + 1][j] == t) {
                                            if (a[lk][j] == r) {

                                                System.out.println(b[i] + ": " + (lk + 3) + ":" + (j) + " " + (lk + 2) + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk) + ":" + j);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        //по диагонали слева(строки)
                        for (int j = 0; j < n; j++) {
                            int ram = j;
                            for (int lk = 0; ram + 3 < n && lk + 3 < m && lk < m; lk++, ram++) {
                                if (a[ram][lk] == u) {
                                    if (a[ram + 1][lk + 1] == y) {
                                        if (a[ram + 2][lk + 2] == t) {
                                            if (a[ram + 3][lk + 3] == r) {
                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 3) + ":" + (lk + 3));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                                if (a[ram + 3][lk + 3] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {

                                                System.out.println(b[i] + ": " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //по диагонали слева(столбцы)
                        for (int j = 0; j < n; j++) {
                            int ram = j;
                            for (int lk = 1; ram + 3 < n && lk + 3 < m && lk < m; lk++, ram++) {
                                if (a[ram][lk] == u) {
                                    if (a[ram + 1][lk + 1] == y) {
                                        if (a[ram + 2][lk + 2] == t) {
                                            if (a[ram + 3][lk + 3] == r) {


                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 3) + ":" + (lk + 3));
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                                if (a[ram + 3][lk + 3] == u) {
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {

                                                System.out.println(b[i] + ": " + (ram + 3) + ":" + (lk + 3) + " " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //по диагонали справа(строки)
                        for (int j = 0; j < n; j++) {
                            int ram = j;
                            for (int lk = m - 1; ram + 3 < n && lk - 3 >= 0 && lk >= 0; lk--, ram++) {
                                if (a[ram][lk] == u) {
                                    if (a[ram + 1][lk - 1] == y) {
                                        if (a[ram + 2][lk - 2] == t) {
                                            if (a[ram + 3][lk - 3] == r) {

                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 3) + ":" + (lk - 3));
                                                lal = true;
                                            }
                                        }
                                    }
                                }


                                if (a[ram + 3][lk - 3] == u) {
                                    if (a[ram + 2][lk - 2] == y) {
                                        if (a[ram + 1][lk - 1] == t) {
                                            if (a[ram][lk] == r) {


                                                System.out.println(b[i] + ": " + (ram + 3) + ":" + (lk - 3) + " " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram) + ":" + (lk));
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //по диагонали справа(столбцы)
                        for (int j = m - 2; j >= 0; j--) {
                            int ram = j;
                            for (int lk = 0; ram - 3 >= 0 && lk + 3 < n && lk < n; lk++, ram--) {
                                if (a[lk][ram] == u) {
                                    if (a[lk + 1][ram - 1] == y) {
                                        if (a[lk + 2][ram - 2] == t) {
                                            if (a[lk + 3][ram - 3] == r) {

                                                System.out.println(b[i] + ": " + lk + ":" + (ram) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 3) + ":" + (ram - 3));
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                                if (a[lk + 3][ram - 3] == u) {
                                    if (a[lk + 2][ram - 2] == y) {
                                        if (a[lk + 1][ram - 1] == t) {
                                            if (a[lk][ram] == r) {
                                                System.out.println(b[i] + ": " + (lk + 3) + ":" + (ram - 3) + " " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk) + ":" + (ram));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }


                    } else {
                        if (b[i] / 100 > 0) {
                            int r, t, y = 0;
                            r = q % 10;
                            q = q / 10;
                            t = q % 10;
                            q = q / 10;
                            y = q % 10;

                            //по строкам
                            for (int j = 0; j < n; j++) {
                                for (int lk = 0; lk + 2 < m && lk < m; lk++) {
                                    if (a[j][lk] == y) {
                                        if (a[j][lk + 1] == t) {
                                            if (a[j][lk + 2] == r) {
                                                System.out.println(b[i] + ": " + (j + ":" + lk) + " " + (j + ":" + (lk + 1)) + " " + (j + ":" + (lk + 2)));
                                                lal = true;

                                            }
                                        }

                                    }
                                    if (a[j][lk + 2] == y) {
                                        if (a[j][lk + 1] == t) {
                                            if (a[j][lk] == r) {

                                                System.out.println(b[i] + ": " + j + ":" + (lk + 2) + " " + j + ":" + (lk + 1) + " " + j + ":" + lk);
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                            }
                            //по столбцам
                            for (int j = 0; j < m; j++) {
                                for (int lk = 0; lk + 2 < n && lk < m; lk++) {
                                    if (a[lk][j] == y) {
                                        if (a[lk + 1][j] == t) {
                                            if (a[lk + 2][j] == r) {


                                                System.out.println(b[i] + ": " + lk + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk + 2) + ":" + (j));
                                                lal = true;

                                            }
                                        }
                                    }

                                    if (a[lk + 2][j] == y) {
                                        if (a[lk + 1][j] == t) {
                                            if (a[lk][j] == r) {


                                                System.out.println(b[i] + ": " + (lk + 2) + ":" + (j) + " " + (lk + 1) + ":" + (j) + " " + (lk) + ":" + j);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }

                            //по диагонали слева(строки)
                            for (int j = 0; j < n; j++) {
                                int ram = j;
                                for (int lk = 0; ram + 2 < n && lk + 2 < m && lk < m; lk++, ram++) {
                                    if (a[ram][lk] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram + 2][lk + 2] == r) {

                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2));
                                                lal = true;

                                            }
                                        }
                                    }
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {


                                                System.out.println(b[i] + ": " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                            }
                            //по диагонали слева(столбцы)
                            for (int j = 0; j < n; j++) {
                                int ram = j;
                                for (int lk = 1; ram + 2 < n && lk + 2 < m && lk < m; lk++, ram++) {
                                    if (a[ram][lk] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram + 2][lk + 2] == r) {


                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram + 2) + ":" + (lk + 2));
                                                lal = true;

                                            }
                                        }
                                    }
                                    if (a[ram + 2][lk + 2] == y) {
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 2) + ":" + (lk + 2) + " " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                            //по диагонали справа(строки)
                            for (int j = 0; j < n; j++) {
                                int ram = j;
                                for (int lk = m - 1; ram + 2 < n && lk - 2 >= 0 && lk >= 0; lk--, ram++) {
                                    if (a[ram][lk] == y) {
                                        if (a[ram + 1][lk - 1] == t) {
                                            if (a[ram + 2][lk - 2] == r) {
                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram + 2) + ":" + (lk - 2));
                                                lal = true;

                                            }
                                        }
                                    }


                                    if (a[ram + 2][lk - 2] == y) {
                                        if (a[ram + 1][lk - 1] == t) {
                                            if (a[ram][lk] == r) {
                                                System.out.println(b[i] + ": " + (ram + 2) + ":" + (lk - 2) + " " + (ram + 1) + ":" + (lk - 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }
                            //по диагонали справа(столбцы)
                            for (int j = m - 2; j >= 0; j--) {
                                int ram = j;
                                for (int lk = 0; ram - 2 >= 0 && lk + 2 < n && lk < n; lk++, ram--) {
                                    if (a[lk][ram] == y) {
                                        if (a[lk + 1][ram - 1] == t) {
                                            if (a[lk + 2][ram - 2] == r) {
                                                System.out.println(b[i] + ": " + lk + ":" + (ram) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk + 2) + ":" + (ram - 2));
                                                lal = true;
                                            }
                                        }
                                    }
                                    if (a[lk + 2][ram - 2] == y) {
                                        if (a[lk + 1][ram - 1] == t) {
                                            if (a[lk][ram] == r) {
                                                System.out.println(b[i] + ": " + (lk + 2) + ":" + (ram - 2) + " " + (lk + 1) + ":" + (ram - 1) + " " + (lk) + ":" + (ram));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                            }

                        } else {
                            if (b[i] / 10 > 0) {
                                int r, t = 0;
                                r = q % 10;
                                q = q / 10;
                                t = q % 10;
                                //по строкам
                                for (int j = 0; j < n; j++) {
                                    for (int lk = 0; lk + 1 < m && lk < m; lk++) {
                                        if (a[j][lk] == t) {
                                            if (a[j][lk + 1] == r) {

                                                System.out.println(b[i] + ": " + (j + ":" + lk) + " " + (j + ":" + (lk + 1)));
                                                lal = true;
                                            }

                                        }
                                        if (a[j][lk + 1] == t) {
                                            if (a[j][lk] == r) {
                                                System.out.println(b[i] + ": " + j + ":" + (lk + 1) + " " + j + ":" + lk);
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                                //по столбцам
                                for (int j = 0; j < m; j++) {
                                    for (int lk = 0; lk + 1 < n && lk < m; lk++) {
                                        if (a[lk][j] == t) {
                                            if (a[lk + 1][j] == r) {
                                                System.out.println(b[i] + ": " + lk + ":" + (j) + " " + (lk + 1) + ":" + (j));
                                                lal = true;
                                            }
                                        }

                                        if (a[lk + 1][j] == t) {
                                            if (a[lk][j] == r) {
                                                System.out.println(b[i] + ": " + (lk + 1) + ":" + (j) + " " + (lk) + ":" + j);
                                                lal = true;
                                            }
                                        }
                                    }
                                }

                                //по диагонали слева(строки)
                                for (int j = 0; j < n; j++) {
                                    int ram = j;
                                    for (int lk = 0; ram + 1 < n && lk + 1 < m && lk < m; lk++, ram++) {
                                        if (a[ram][lk] == t) {
                                            if (a[ram + 1][lk + 1] == r) {

                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1));
                                                lal = true;
                                            }
                                        }
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {

                                                System.out.println(b[i] + ": " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;

                                            }
                                        }
                                    }
                                }
                                //по диагонали слева(столбцы)
                                for (int j = 0; j < n; j++) {
                                    int ram = j;
                                    for (int lk = 1; ram + 1 < n && lk + 1 < m && lk < m; lk++, ram++) {
                                        if (a[ram][lk] == t) {
                                            if (a[ram + 1][lk + 1] == r) {


                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk + 1));
                                                lal = true;

                                            }
                                        }
                                        if (a[ram + 1][lk + 1] == t) {
                                            if (a[ram][lk] == r) {

                                                System.out.println(b[i] + ": " + (ram + 1) + ":" + (lk + 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                                //по диагонали справа(строки)
                                for (int j = 0; j < n; j++) {
                                    int ram = j;
                                    for (int lk = m - 1; ram + 1 < n && lk - 1 >= 0 && lk >= 0; lk--, ram++) {
                                        if (a[ram][lk] == t) {
                                            if (a[ram + 1][lk - 1] == r) {

                                                System.out.println(b[i] + ": " + (ram) + ":" + (lk) + " " + (ram + 1) + ":" + (lk - 1));
                                                lal = true;
                                            }
                                        }
                                        if (a[ram + 1][lk - 1] == t) {
                                            if (a[ram][lk] == r) {

                                                System.out.println(b[i] + ": " + (ram + 1) + ":" + (lk - 1) + " " + (ram) + ":" + (lk));
                                                lal = true;
                                            }
                                        }
                                    }
                                }
                                //по диагонали справа(столбцы)
                                for (int j = m - 2; j >= 0; j--) {
                                    int ram = j;
                                    for (int lk = 0; ram - 1 >= 0 && lk + 1 < n && lk < n; lk++, ram--) {
                                        if (a[lk][ram] == t) {
                                            if (a[lk + 1][ram - 1] == r) {
                                                System.out.println(b[i] + ": " + lk + ":" + (ram) + " " + (lk + 1) + ":" + (ram - 1));
                                                lal = true;
                                            }
                                        }
                                        if (a[lk + 1][ram - 1] == t) {
                                            if (a[lk][ram] == r) {
                                                System.out.println(b[i] + ": " + (lk + 1) + ":" + (ram - 1) + " " + (lk) + ":" + (ram));
                                                lal = true;
                                            }
                                        }
                                    }
                                }

                            } else {
                                if (b[i] > 0) {
                                    for (int j = 0; j < n; j++) {
                                        for (int lk = 0; lk < m; lk++) {
                                            if (a[j][lk] == b[i]) {
                                                System.out.println(b[i] + ": " + (j + ":" + lk));
                                                lal = true;
                                            }
                                        }

                                    }
                                }
                            }
                        }
                        if (!lal) {
                            System.out.println(b[i] + ": нет");
                        }
                    }


                }


            }
        }
    }
}




