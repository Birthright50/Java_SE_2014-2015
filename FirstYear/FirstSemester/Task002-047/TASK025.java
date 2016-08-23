

/**
 * Created by BirthrightL on 28.09.2014.
 */
public class TASK025 {
    public static void main(String[] args) {
        final double EPS = 1e-9;
        double numerator = 1;
        double denominator;
        double s = 0.25;
        double z = 1;
        for (int i = 2; Math.abs(z) > EPS; i++) {
            numerator *= -1;
            denominator = i * i + 3 * i;
            z = numerator / denominator;
            s = s + z;
        }
        System.out.println(s);
    }

}

