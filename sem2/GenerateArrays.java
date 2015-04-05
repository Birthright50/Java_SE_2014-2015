import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;


/**
 * Created by Birthright on 18.03.2015.
 */
public class GenerateArrays {
    static final Random RANDOM = new Random();

    private static void saveData(final String fileName, final int[] array) throws IOException {
        final Path filePath = FileSystems.getDefault().getPath((fileName));
        try (final BufferedWriter writer = Files.newBufferedWriter(filePath, Charset.defaultCharset())) {
            writer.write(Arrays.toString(array));
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 50, q = 1; i <= 10000; i = i + 50, q++) {
            String s = q + ".txt";
            int a[] = new int[i];
            for (int j = 0; j < a.length; j++) {
                a[j] = RANDOM.nextInt();
            }
            saveData(s, a);
        }

    }

}
