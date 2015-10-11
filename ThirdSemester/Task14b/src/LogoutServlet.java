import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Birthright on 10.10.2015.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        Cookie logCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    logCookie = cookie;
                    break;
                }
            }
        }
        if (logCookie != null) {
            logCookie.setMaxAge(0);
            response.addCookie(logCookie);
        }
        request.getSession().invalidate();
        response.sendRedirect("/login");
    }
}
