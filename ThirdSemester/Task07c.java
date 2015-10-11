import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 18.09.2015.
 */
public class Task07c {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedreader = new BufferedReader(new FileReader("custom.html"));
            Pattern pattern = Pattern.compile("\\?((\\w+)=(\\w+)(&(\\w+)=(\\w+))*)#?");
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String fullLine = matcher.group(1);
                    stringBuilder.append("PARAM STRING: ").append(fullLine);
                    String [] partsOfTheLine = fullLine.split("&");
                    int count = partsOfTheLine.length;
                    for(int i = 0; i<count; i++){
                        String[] partsOfTheSubline = partsOfTheLine[i].split("=");
                        stringBuilder.append("\n").append("NAME: ").append(partsOfTheSubline[0]).append("\n").append("VALUE: ")
                                .append(partsOfTheSubline[1]);
                    }
                    stringBuilder.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder);
    }
}
