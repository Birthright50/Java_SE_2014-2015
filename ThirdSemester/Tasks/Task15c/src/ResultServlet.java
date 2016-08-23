import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 10.10.2015.
 */
@WebServlet(name = "ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer length = (Integer) session.getAttribute("length");
        Integer words = (Integer) session.getAttribute("words");
        Integer sentences = (Integer) session.getAttribute("sentences");
        Integer paragraphs = (Integer) session.getAttribute("paragraphs");
        HashMap<String, String> root = new HashMap<>();
        if (length != null) {
            root.put("result", "Length : " + length);
            session.removeAttribute("length");
        } else {
            if (words != null) {
                root.put("result", "Words : " + words);
                session.removeAttribute("words");
            } else {
                if (sentences != null) {
                    root.put("result", "Sentences : " + sentences);
                    session.removeAttribute("sentences");
                } else {
                    if (paragraphs != null) {
                        root.put("result", "Paragraphs : " + paragraphs);
                        session.removeAttribute("paragraphs");
                    } else {
                        response.sendRedirect("/process");
                        return;
                    }
                }
            }
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("result.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
