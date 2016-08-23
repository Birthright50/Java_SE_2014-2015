import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 10.10.2015.
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession httpSession = request.getSession();
        String login = (String) httpSession.getAttribute("login");
        Cookie[] cookies = request.getCookies();
        Cookie username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    username = cookie;
                    break;
                }
            }
        }
        if (username == null && login == null) {
            response.sendRedirect("/login");
        } else {
            Configuration configuration = ConfigSingleton.getConfiguration(getServletContext());
            Template template = configuration.getTemplate("profile.ftl");
            HashMap<String, String> root = new HashMap<>();
            if (login != null) {
                root.put("login", login);
            } else {
                root.put("login", username.getValue());
            }
            try {
                template.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
}
