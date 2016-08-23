package ru.kpfu.itis.peter_kozlovsky.servlets;

import freemarker.template.TemplateException;
import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import ru.kpfu.itis.peter_kozlovsky.db.model.AutoBrand;
import ru.kpfu.itis.peter_kozlovsky.db.model.AutoModel;
import ru.kpfu.itis.peter_kozlovsky.db.model.AutoModify;
import ru.kpfu.itis.peter_kozlovsky.db.model.AutoSubmodel;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Birthright on 10.11.2015.
 */
@WebServlet(name = "CatalogServlet")
public class CatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String auto_brands = request.getParameter("auto_brand");
        String auto_model = request.getParameter("auto_model");
        String auto_submodels = request.getParameter("auto_submodel");
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
        if (auto_submodels != null && auto_model != null && auto_brands != null) {
            root.put("type", 4);
            AutoModify autoModify = DBHelper.autoModifyRepository.getAuto(auto_brands, auto_model, auto_submodels);
            root.put("modify", autoModify);

        } else {
            if (auto_model != null && auto_brands != null) {
                root.put("type", 3);
                List<AutoSubmodel> autoSubmodels = DBHelper.autoSubmodelRepository.getSubmodelsByModel(auto_brands, auto_model);
                AutoModel autoModel = DBHelper.autoModelRepository.getModel(auto_brands, auto_model);
                root.put("model", autoModel);
                root.put("submodels", autoSubmodels);
            } else {
                if (auto_brands != null) {
                    root.put("type", 2);
                    List<AutoModel> autoModels = DBHelper.autoModelRepository.getByBrand(auto_brands);
                    root.put("models", autoModels);

                } else {
                    List<AutoBrand> autoBrands = DBHelper.autoBrandRepository.giveAll();
                    root.put("type", 1);
                    root.put("brands", autoBrands);
                }
            }
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("catalog.ftl").process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
