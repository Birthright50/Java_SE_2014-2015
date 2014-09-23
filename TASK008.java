/**
 * Created by BirthrightL on 23.09.2014.
 */

import java.util.Scanner;

public class TASK008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ввод k");
        int k = scanner.nextInt();
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " x " + k + " = " + (i * k));
        }
    }

}

