import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 22.11.2015.
 */
public class Task24b {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        URL url;
        URLConnection connection = null;
        try {
            url = new URL("https://ru.wikipedia.org/wiki/%D0%A0%D1%83%D1%81%D1%8C_(%D0%BD%D0%B0%D1%80%D0%BE%D0%B4)");
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert connection != null;
        try (LineNumberReader lineNumberReader = new LineNumberReader(new BufferedReader(new InputStreamReader(connection.getInputStream())))) {
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("<[^>]+href\\s*=\\s*['\"]([^'\"]+.(?:pdf|mp3))['\"][^>]*>");
        Matcher matcher = pattern.matcher(builder);

        while (matcher.find()) {
            String link = matcher.group(1);
            String fileName = link.substring(link.lastIndexOf('/') + 1, link.length());
            ReadableByteChannel readableByteChannel = null;
            FileOutputStream fileOutputStream = null;
            try {
                url = new URL(link);
                readableByteChannel = Channels.newChannel(url.openStream());
                fileOutputStream = new FileOutputStream(fileName);
                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (readableByteChannel != null) {
                        readableByteChannel.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
