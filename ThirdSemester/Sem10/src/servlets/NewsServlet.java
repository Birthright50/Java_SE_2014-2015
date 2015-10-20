package servlets;

import db.DBHelper;
import db.model.News;
import freemarker.template.TemplateException;
import singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Birthright on 20.10.2015.
 */
@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        List<News> news = DBHelper.newsRepository.showAll();
        int length = news.size();
        int pages = length / 12 + 1;
        HashMap<String, Object> root = new HashMap<>();
        root.put("pages", pages);
        root.put("list", DBHelper.newsRepository.getNewstoFrMark());
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("profile.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
