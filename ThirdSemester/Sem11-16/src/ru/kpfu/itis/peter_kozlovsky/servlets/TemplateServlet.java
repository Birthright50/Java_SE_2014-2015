package ru.kpfu.itis.peter_kozlovsky.servlets;

import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import ru.kpfu.itis.peter_kozlovsky.db.model.Template;
import freemarker.template.TemplateException;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Birthright on 20.10.2015.
 */
@WebServlet(name = "NewsServlet")
public class TemplateServlet extends HttpServlet {
    private static final String NEWS = "/news";
    private static final String ARTICLES = "/articles";
    private static final String VIDEOS = "/videos";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
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
        String servletPath = request.getServletPath();
        String id = null;
        byte type = 0;
        switch (servletPath) {
            case NEWS:
                type = 1;
                root.put("type", 1);
                id = request.getParameter("id_news");
                break;
            case ARTICLES:
                type = 2;
                root.put("type", 2);
                id = request.getParameter("id_articles");
                break;
            case VIDEOS:
                type = 3;
                root.put("type", 3);
                id = request.getParameter("id_videos");
        }
        if (id != null) {
            Integer id_temp = Integer.parseInt(id);
            Template template = DBHelper.newsRepository.getTemplate(id_temp);
            DBHelper.addViewsForPage(id_temp);
            String page = template.getPage();
            root.put("page", page);
        } else {
            String pathInfo = request.getPathInfo();
            Integer page;
            if (pathInfo == null || pathInfo.length() == 1) {
                page = 1;
            } else {
                page = Integer.parseInt(pathInfo.split("/")[2]);
            }
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("utf-8");
            List<Template> aNews = DBHelper.newsRepository.showAllForPage(page, type);
            int length = DBHelper.getNewsCount(type);
            int pages = length / 12 + 1;
            root.put("pages", pages);
            root.put("list", aNews);
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("template.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
