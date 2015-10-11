/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fact = 1;
        for (int i = n; i > 0; i = i - 2) {
            fact *= i;
        }
        System.out.println(fact);
    }
}
