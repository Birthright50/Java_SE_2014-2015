import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 17.09.2015.
 */
public class Task02c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte n = sc.nextByte();
        sc.nextLine();
        String[] array = new String[n];
        Pattern pattern = Pattern.compile("0+|1+|(01)+0?|(10)+1?");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            if (pattern.matcher(array[i]).matches()) {
                System.out.println(array[i]);
            }
        }
    }
}
