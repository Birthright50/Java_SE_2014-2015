import java.util.Scanner;

/**
 * Created by BirthrightL on 29.10.2014.
 */
public class TASK046 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int i = 0;
        while (i < a.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                if ((int) a.charAt(i) < (int) b.charAt(i)) {
                    System.out.println("1-я строка лексикографически раньше ");
                    break;
                } else {
                    System.out.println("2-я строка лексикографически раньше ");
                    break;
                }
            }
            i++;
        }
    }
}

