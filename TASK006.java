/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        int y = (x * x * x * x * x + 6 * x * x * x * x + 10 * x * x * x + 25 * x * x + 30 * x + 101);
        System.out.println(y);
    }
}
