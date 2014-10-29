import java.util.Scanner;

/**
 * Created by BirthrightL on 28.10.2014.
 */
public class TASK045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }
        int k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            String b = sc.nextLine();
            String[] g = b.split(" ");

            for (int j = 0; j < n; j++) {
                String m[] = a[j].split(" ");
                if (g[0].equals(m[0])) {
                    String l[] = g[2].split(":");
                    int first = Integer.parseInt(l[0]);
                    int second = Integer.parseInt(l[1]);
                    first = first - second;
                    a[j] = a[j] + " " + +first;
                }
                if (g[1].equals(m[0])) {
                    String l[] = g[2].split(":");
                    int first = Integer.parseInt(l[0]);
                    int second = Integer.parseInt(l[1]);
                    first = second - first;
                    a[j] = a[j] + " " + first;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            String[] l = a[i].split(" ");

            int s = 0;
            for (int j = 1; j < l.length; j++) {
                int g = Integer.parseInt(l[j]);
                s = s + g;
            }
            System.out.println(l[0] + " " + s);
        }
    }
}

