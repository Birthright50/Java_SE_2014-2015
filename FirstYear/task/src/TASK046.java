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
        int l = Math.min(a.length(), b.length());
        while (i < l) {
            if (a.charAt(i) != b.charAt(i)) {
                if ((int) a.charAt(i) < (int) b.charAt(i)) {
                    System.out.println("1-я строка лексикографически раньше");
                    return;
                } else {
                    System.out.println("2-я строка лексикографически раньше");
                    return;
                }
            }
            i++;
        }
        if(a.length()-b.length()<0){
            System.out.println("1-я строка лексикографически раньше");
        }
        else{
            System.out.println("2-я строка лексикографически раньше");
        }
    }
}

