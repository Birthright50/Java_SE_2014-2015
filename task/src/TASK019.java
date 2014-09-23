/**
 * Created by BirthrightL on 23.09.2014.
 */
public class TASK019 {
    public static void main(String[] args) {

        long n = 100000;
        for (int j = 1; n > j; n--) {
            int s = 1;
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0)
                    s = s + i;
            }
            if (n == s)
                System.out.println(s);
        }
    }
}

