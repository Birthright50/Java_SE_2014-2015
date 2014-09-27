
/**
 * Created by BirthrightL on 27.09.2014.
 */
public class TASK023 {

    public static void main(String[] args) {
        final double EPS = 1e-9;
        double numerator = 5;
        double denominator = 6;
        double s = 0;
        double z = 1;
        for (int i = 2; z > EPS; i++) {
            s = s + numerator / denominator;
            z = numerator / denominator;
            numerator = 2 * i + 3;
            denominator = 5 * i * i * i * i + 1;
        }
        System.out.println(s);
    }
}