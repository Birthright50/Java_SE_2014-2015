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
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pwd");
        String checkbox = request.getParameter("checkbox");
        HttpSession httpSession = request.getSession();
        boolean containsKey = map.containsKey(login);
        if (containsKey && map.get(login).equals(password)) {
            if (checkbox != null) {
                Cookie loginCookie = new Cookie("login", login);
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
            }
            httpSession.setAttribute("login", login);
            response.sendRedirect("/profile");
        } else {
            if (containsKey && !map.get(login).equals(password)) {
                httpSession.setAttribute("error_msg", "Incorrect password");
            } else {
                httpSession.setAttribute("error_msg", "Incorrect login");
            }
            httpSession.setAttribute("name", login);
            response.sendRedirect("/login");
        }
    }

    HashMap<String, String> map;

    @Override
    public void init() throws ServletException {
        map = new HashMap<>();
        map.put("Alex", "12345");
        map.put("Peter", "qwerty");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
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
        HttpSession httpSession = request.getSession();
        String login = (String) httpSession.getAttribute("login");
        if (login != null || username != null) {
            response.sendRedirect("/profile");
        } else {
            Configuration configuration = ConfigSingleton.getConfiguration(getServletContext());
            Template template = configuration.getTemplate("login.ftl");
            String error = (String) httpSession.getAttribute("error_msg");
            String name = (String) httpSession.getAttribute("name");
            HashMap<String, String> root = new HashMap<>();
            root.put("error", error);
            root.put("name", name);
            try {
                template.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
    }
}
