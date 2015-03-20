import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by birthright on 19.03.15.
 */
public class LexicographicalComparison implements Comparator<Vector2D> {
    @Override
    public int compare(Vector2D o1, Vector2D o2) {
        if (o1.getX() - o2.getX() < 0) {
            return -1;
        }
        if (o1.getX() - o2.getX() > 0) {
            return 1;
        }
        if (o1.getY() - o2.getY() < 0) {
            return -1;
        }
        if (o1.getY() - o2.getY() > 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Vector2D> array = new ArrayList<Vector2D>();
        Random random = new Random();
        int q = random.nextInt(300);
        for (int i = 0; i < q; i++) {
            array.add(new Vector2D(random.nextDouble() * random.nextInt(600), random.nextDouble() * random.nextInt(600)));
        }
        Collections.sort(array, new LexicographicalComparison());
        System.out.println(array);
    }
}
