import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Birthright on 30.09.2015.
 */
@WebServlet(name = "MathServlet")
public class MathServlet extends HttpServlet {
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

        String[] array = path.split("/");
        if (array.length == 3) {
            try {
                stringBuilder.append("<b>");
                Integer number1 = Integer.parseInt(array[1]);
                Integer number2 = Integer.parseInt(array[2]);
                if (request.getRequestURL().toString().contains("add")) {
                    stringBuilder.append(number1).append(" + ").append(number2).append(" = ").append(number1 + number2);
                } else {
                    stringBuilder.append(number1).append(" * ").append(number2).append(" = ").append(number1 * number2);

                }
                stringBuilder.append("</b>");
                stringBuilder.append("</body>\n" +
                        "</html>");
                writer.write(stringBuilder.toString());
            } catch (NumberFormatException e) {
                writer.write("<b>Incorrect numbers</b>");
            } finally {
                writer.close();
            }
        }
    }
}
