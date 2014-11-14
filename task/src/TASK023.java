
/**
 * Created by BirthrightL on 27.09.2014.
 */
public class TASK023 {

    public static void main(String[] args) {
        final double EPS = 1e-9;
        double numerator;
        double denominator;
        double s = 5.0 / 6;
        System.out.println(s);
        double z = 1;
        for (int i = 2; z > EPS; i++) {
            numerator = 2 * i + 3;
            denominator = 5 * i * i * i * i + 1;
            z = numerator / denominator;
            s = s + z;
        }
        System.out.println(s);
    }
}