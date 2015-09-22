import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 20.09.2015.
 */
public class Task09b {
    static final String GETDATE = "/getdate";
    static final String MATH = "/(add|mult)/([1-9][0-9]*)/([1-9][0-9]*)";
    static final String SEARCH = ("/(baidu\\.com|bing\\.com|yahoo\\.com|aol\\.com)/search");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern patternMath = Pattern.compile(MATH);
        Pattern patternSearch = Pattern.compile(SEARCH);
        Matcher matcher;
        StringBuilder stringBuilder = new StringBuilder();
        boolean page404 = false;
        while (!page404) {
            String line = sc.nextLine();
            String time = Calendar.getInstance().getTime().toString();
            stringBuilder.setLength(0);
            stringBuilder.append("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title></title>\n" +
                    "</head>\n" +
                    "<body>\n");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(time.replaceAll(":", ".") + ".html"))) {
                if (line.equals(GETDATE)) {
                    stringBuilder.append("<b>").append(time).append("</b>");
                    System.out.println("Create date content");
                } else {
                    matcher = patternMath.matcher(line);
                    if (matcher.matches()) {
                        stringBuilder.append("<b>");
                        String number1 = matcher.group(2);
                        String number2 = matcher.group(3);
                        if (matcher.group(1).length() == 3) {
                            stringBuilder.append(number1).append(" + ").append(number2).append(" = ").append(Integer.parseInt(number1) + Integer.parseInt(number2));
                            System.out.println("add page created");
                        } else {
                            stringBuilder.append(number1).append(" * ").append(number2).append(" = ").append(Integer.parseInt(number1) * Integer.parseInt(number2));
                            System.out.println("mult page created");
                        }
                        stringBuilder.append("</b>");

                    } else {
                        matcher = patternSearch.matcher(line);
                        if (matcher.matches()) {
                            stringBuilder.append("<form action=\"");
                            String string = matcher.group(1);
                            if (string.length() == 8) {
                                stringBuilder.append("http://www.bing.com/search\"").append("method=\"get\">\n" +
                                        "<input type=\"text\" placeholder=\"bing.com\" name=\"q\" />");
                                System.out.println("Create bing search");
                            } else {
                                if (string.length() == 7) {
                                    stringBuilder.append("http://search.aol.com/aol/search?\"").append("method=\"get\">\n" +
                                            "    <input type=\"text\" placeholder=\"aol.com\" name=\"q\" />");
                                    System.out.println("Create aol search");
                                } else {
                                    if (string.equals("yahoo.com")) {
                                        stringBuilder.append("https://search.yahoo.com/search\"").append("method=\"get\">\n" +
                                                "    <input type=\"text\" placeholder=\"yahoo.com\" name=\"p\"/>");
                                        System.out.println("Create yahoo search");
                                    } else {
                                        stringBuilder.append("http://www.baidu.com/s\" ").append("method=\"get\">\n" +
                                                "    <input type=\"text\" placeholder=\"baidu.com\" name=\"wd\" />");
                                        System.out.println("Create baidu search");
                                    }
                                }
                            }
                            stringBuilder.append("<input type=\"submit\" value=\"Search\"/>"+"</form>");

                        } else {
                            page404 = true;
                            stringBuilder.append("<b>404 not found</b>");
                            System.out.println("Sorry, bad request. 404 page was created, the program is stopped");
                        }
                    }

                }
                stringBuilder.append("</body>\n" +
                        "</html>");
                writer.write(stringBuilder.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
