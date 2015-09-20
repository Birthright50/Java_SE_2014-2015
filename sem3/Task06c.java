import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 18.09.2015.
 */
public class Task06c {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedreader = new BufferedReader(new FileReader("custom.html"));
            Pattern pattern = Pattern.compile("^(?<protocol>([^:/\\\\?#]+):)" +
                    "?(?<autority>//(?<host>(?<hostname>[^:/\\\\?#]*):(?<port>[^/\\\\?#]*)?))?(?<pathname>[^\\\\?#]*/(?<filename>[\\w]+)\\.(?<extension>[a-z0-9\\.]+))(?<search>\\\\?([^#]*))?(?<hash>#(.*))?$");
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    stringBuilder.append("FILENAME: ").append(matcher.group("filename")).append("\nEXTENSION: ").append(matcher.group("extension")).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder);
    }
}
