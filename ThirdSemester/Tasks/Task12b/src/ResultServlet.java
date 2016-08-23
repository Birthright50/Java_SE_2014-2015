import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Birthright on 30.09.2015.
 */
@WebServlet(name = "ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter printWriter = response.getWriter();
        Integer length = (Integer) session.getAttribute("length");
        Integer words = (Integer) session.getAttribute("words");
        Integer sentences = (Integer) session.getAttribute("sentences");
        Integer paragraphs = (Integer) session.getAttribute("paragraphs");
        if (length != null) {
            printWriter.print("<b>Characters : " + length + "</b>");
            session.removeAttribute("length");
        } else {
            if (words != null) {
                printWriter.print("<b>Words : " + words + "</b>");
                session.removeAttribute("words");
            } else {
                if (sentences != null) {
                    printWriter.print("<b>Sentences : " + sentences + "</b>");
                    session.removeAttribute("sentences");
                } else {
                    printWriter.print("<b>Paragraphs : " + paragraphs + "</b>");
                    session.removeAttribute("paragraphs");
                }
            }
        }
        printWriter.close();
    }
}
