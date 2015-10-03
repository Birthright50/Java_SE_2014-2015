import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 30.09.2015.
 */
@WebServlet(name = "ProcessServlet")
public class ProcessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("textarea");
        String select = request.getParameter("select");
        HttpSession session = request.getSession();
        switch (select) {
            case "1":
                Integer length = text.length();
                session.setAttribute("length", length);
                break;
            case "2":
                StringTokenizer ins = new StringTokenizer(text, " \t\n\r,.");
                session.setAttribute("words", ins.countTokens());
                break;
            case "3":
                Pattern sentencePattern = Pattern.compile("[A-Z]+[^!?.]*");
                session.setAttribute("sentences", sentencePattern.split(text).length - 1);
                break;
            case "4":
                session.setAttribute("paragraphs", text.split("\n").length);
                break;
        }
        response.sendRedirect("/result");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"utf-8\"/>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "  <form action=\"/process\" method=\"post\">\n" +
                "    <textarea name=\"textarea\"></textarea><br/>\n" +
                "    <select name=\"select\">\n" +
                "<option value=\"1\">Characters</option>\n" +
                "      <option value=\"2\">Words</option>\n" +
                "      <option value=\"3\">Sentences</option>\n" +
                "      <option value=\"4\">Paragraphs</option>\n" +
                "          </select>\n" +
                "    <input type=\"submit\"/>\n" +
                "  </form>\n" +
                "</body>\n" +
                "</html>");
        printWriter.close();
    }
}
