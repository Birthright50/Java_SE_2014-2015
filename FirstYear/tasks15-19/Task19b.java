import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by birthright on 19.03.15.
 */
public class Task19b {

    static class compareTheLength implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return lengthOf(o1) - lengthOf(o2);
        }
    }

    public static Integer lengthOf(int a) {
        int i = 0;
        while (a != 0) {
            a = a / 10;
            i++;
        }
        return i;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("in.txt"));
        ArrayList<Integer> s = new ArrayList<Integer>();
        while (sc.hasNext()) {
            s.add(sc.nextInt());
        }
        Collections.sort(s, new compareTheLength());
        FileWriter writer = new FileWriter("out.txt");
        for (Integer value : s) {
            writer.write(value + " ");
        }
        writer.flush();
        writer.close();
    }
}
