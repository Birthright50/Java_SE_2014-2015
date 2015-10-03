import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Birthright on 01.10.2015.
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
        PrintWriter writer = response.getWriter();
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
        String error = (String) httpSession.getAttribute("error_msg");
        String name = (String) httpSession.getAttribute("name");
        if (login != null || username != null) {
            response.sendRedirect("/profile");
        } else {
            writer.print("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>Login Page</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <font size=\"5\" color=\"red\">");
            if (error != null) {
                writer.print(error);
            }
            writer.print("</font>\n" +
                    "   <form action=\"/login\" method=\"post\">\n" +
                    " Login: <input type=\"text\" name=\"login\" value=\"");

            if (name != null) {
                writer.print(name);
            }
            writer.print("\">\n" +
                    "<br>\n" +
                    "Password: <input type=\"password\" name=\"pwd\">\n" +
                    "<br>\n" +
                    "<input id=\"remember me\" type=\"checkbox\" checked name=\"checkbox\" >\n" +
                    "    <label for=\"remember_me\">Remember me</label>\n" +
                    "    <br>\n" +
                    "<input type=\"submit\" value=\"Login\">\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>");

        }
        writer.close();
    }
}
