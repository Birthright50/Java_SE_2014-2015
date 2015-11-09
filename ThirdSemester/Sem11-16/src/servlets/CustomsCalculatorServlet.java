package servlets;

import freemarker.template.TemplateException;
import helpers.CustomsCalculatorHelper;
import org.json.simple.JSONObject;
import singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Birthright on 13.10.2015.
 */
@WebServlet(name = "CustomsCalculatorServlet")
public class CustomsCalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String cm = request.getParameter("cm");
        String year = request.getParameter("year");
        String autoprice = request.getParameter("autoprice_euro");
        Double price = CustomsCalculatorHelper.getInfo(cm, year, autoprice);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("price", price + " RUB");
        response.getWriter().print(jsonObject.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HashMap<String, Object> root = new HashMap<>();
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
            root.put("login", login != null ? login : username.getValue());
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("calc_tam.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
