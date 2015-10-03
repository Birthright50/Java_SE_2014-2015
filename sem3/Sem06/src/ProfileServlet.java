import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Birthright on 01.10.2015.
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        PrintWriter writer = response.getWriter();
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
        if (login != null || username != null) {
            if (login != null) {
                writer.print("<b>Hi, " + login + "</b></br>");
            } else {
                writer.print("<b>Hi, " + username.getValue() + "</b></br>");
            }
            writer.print("<a href=\"/logout\">Logout</a>");
        } else {
            response.sendRedirect("/login");
        }
        writer.close();
    }
}
