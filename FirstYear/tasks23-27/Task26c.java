import java.io.*;

/**
 * Created by Birthright on 02.05.2015.
 */
public class Task26c {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("in.txt");
        FileWriter writer = new FileWriter("out.txt");
        int c;
        Long x = System.nanoTime();
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }
        x = System.nanoTime() - x;
        reader.close();
        writer.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("in.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("out.txt"));
        String l;
        Long d = System.nanoTime();
        while ((l = bufferedReader.readLine()) != null) {
            printWriter.println(l);
        }
        d = System.nanoTime() - d;
        bufferedReader.close();
        printWriter.close();
        System.out.println("File Reader and Writer time = " + x + " nanoseconds");
        System.out.println("Buff Reader and Print Writer time = " + d + " nanoseconds");

    }
}
