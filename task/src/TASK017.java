/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK017 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        double s = 0.5;
        double fact1 = 1;
        double fact2 = 6;
        if (n <= 0)
            System.out.println("! n>=1");
        else {
            {
                if (n == 1)
                    System.out.println("0.5");
                else
                    for (int i = 2; i <= n; i++) {
                        fact1 = fact1 * (i - 1);
                        fact2 = fact2 * 2 * i;
                        s = s + ((fact1 * fact1) / fact2);
                        fact2=fact2*(i+3);

                    }
                System.out.println(s);
            }


        }
    }
}