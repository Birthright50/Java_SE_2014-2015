package servlets;

import db.DBHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 18.10.2015.
 */
@WebServlet(name = "servlets.LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("input");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("checkbox[]");
        HttpSession httpSession = request.getSession();
        String result = DBHelper.checkUser(login, password);
        switch (result) {
            case "OK":
                if (checkbox != null) {
                    Cookie loginCookie = new Cookie("login", login);
                    loginCookie.setMaxAge(30 * 60);
                    response.addCookie(loginCookie);
                }
                httpSession.setAttribute("login", login);
                response.sendRedirect("/news");
                break;
            case "bad_pwd":
                httpSession.setAttribute("error_msg", "Incorrect password");
                httpSession.setAttribute("name", login);
                response.sendRedirect("/login");
                break;
            case "bad_login":
                httpSession.setAttribute("error_msg", "Incorrect login");
                httpSession.setAttribute("name", login);
                response.sendRedirect("/login");
                break;
        }
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
            response.sendRedirect("/news");
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
