package ru.kpfu.itis.peter_kozlovsky.servlets;

import freemarker.template.TemplateException;
import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import ru.kpfu.itis.peter_kozlovsky.db.model.Ad;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Birthright on 14.11.2015.
 */
@WebServlet(name = "BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        String id = request.getParameter("id");
        System.out.println(id);
        if (id != null) {
            try {
                Integer id_buy = Integer.parseInt(id);
                Ad ad = DBHelper.adRepository.getAd(id_buy);
                root.put("ad", ad);

            } catch (NumberFormatException e) {
                response.sendRedirect("/buy");
            }
        } else {
            List<Ad> ads = DBHelper.adRepository.showAll();
            root.put("ads", ads);
        }

        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("buy.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
