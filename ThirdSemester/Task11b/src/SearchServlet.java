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


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            stringBuilder.append("http://www.bing.com/search\"").append("method=\"get\">\n" +
                    "<input type=\"text\" placeholder=\"bing.com\" name=\"q\" />");

        } else {
            if (path.length() == 4) {
                stringBuilder.append("http://search.aol.com/aol/search?\"").append("method=\"get\">\n" +
                        "    <input type=\"text\" placeholder=\"aol.com\" name=\"q\" />");

            } else {
                if (path.equals("/yahoo")) {
                    stringBuilder.append("https://search.yahoo.com/search\"").append("method=\"get\">\n" +
                            "    <input type=\"text\" placeholder=\"yahoo.com\" name=\"p\"/>");

                } else {
                    if (path.equals("/baidu")) {
                        stringBuilder.append("http://www.baidu.com/s\" ").append("method=\"get\">\n" +
                                "    <input type=\"text\" placeholder=\"baidu.com\" name=\"wd\" />");

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
