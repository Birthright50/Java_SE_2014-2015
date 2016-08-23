import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Birthright on 29.09.2015.
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {


    private static String createSearch(String type, String placeholder, String parameter) {
        return (type + "\" method=\"get\">\n" +
                "<input type=\"text\" placeholder=\"" + placeholder + "\" name=\"" + parameter + "\" />");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String path = request.getPathInfo();
        PrintWriter writer = response.getWriter();
        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title></title>\n" +
                "</head>\n" +
                "<body>\n");
        stringBuilder.append("<form action=\"");
        if (path.length() == 5) {
            stringBuilder.append(createSearch("http://www.bing.com/search", "bing.com", "q"));

        } else {
            if (path.length() == 4) {
                stringBuilder.append(createSearch("http://search.aol.com/aol/search?", "aol.com", "q"));

            } else {
                if (path.equals("/yahoo")) {
                    stringBuilder.append(createSearch("https://search.yahoo.com/search", "yahoo.com", "p"));

                } else {
                    if (path.equals("/baidu")) {
                        stringBuilder.append(createSearch("http://www.baidu.com/s", "baidu.com", "wd"));
                    } else {
                        writer.write("<b>Incorrect PATH</b>");
                        writer.close();
                        return;
                    }
                }
            }
        }
        stringBuilder.append("<input type=\"submit\" value=\"Search\"/>" + "</form>");
        stringBuilder.append("</body>\n" +
                "</html>");
        writer.print(stringBuilder.toString());
        writer.close();
    }
}
