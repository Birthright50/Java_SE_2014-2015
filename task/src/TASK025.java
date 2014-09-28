

/**
 * Created by BirthrightL on 28.09.2014.
 */
public class TASK025 {
    public static void main(String[] args) {
        final double EPS = 1e-9;
        double numerator = 1;
        double denominator = 4;
        double s = 0;
        double z = 1;
        for (int i = 2; Math.abs(z) > EPS; i++) {
            s = s + numerator / denominator;
            z = numerator / denominator;
            denominator = i * i + 3 * i;
            if (i % 2 == 0)
                numerator = -1;
            else
                numerator = 1;
        }
        System.out.println(s);
    }

}

