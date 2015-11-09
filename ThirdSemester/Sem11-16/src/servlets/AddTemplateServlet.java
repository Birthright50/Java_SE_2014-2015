package servlets;

import com.ibm.useful.http.FileData;
import com.ibm.useful.http.PostData;
import db.DBHelper;
import db.model.Template;
import freemarker.template.TemplateException;
import singleton.ConfigSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Birthright on 08.11.2015.
 */
@WebServlet(name = "AddTemplateServlet")
public class AddTemplateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            login = login != null ? login : username.getValue();
        }
        try {
            if (isMultiPartFormat(request)) {
                PostData multidata = new PostData(request);
                String name = multidata.getParameter("name");
                String page = multidata.getParameter("page");
                Template template = new Template();
                String type = multidata.getParameter("optradio");
                template.setType(Byte.parseByte(type));
                switch (type) {
                    case "1":
                        type = "news";
                        break;
                    case "2":
                        type = "articles";
                        break;
                    case "3":
                        type = "videos";
                        break;
                }
                FileData tempFile = multidata.getFileData("image");
                if (tempFile != null) {
                    saveFile(tempFile, type);
                    template.setName(name);
                    template.setPage(page);
                    template.setUrl_image("/images/" + type + "/" + tempFile.getFileName());
                    template.setId_user(DBHelper.userRepository.getUser(login).getId());
                    DBHelper.newsRepository.createNews(template);
                    response.sendRedirect("/" + type);
                }
                else{
                    response.sendRedirect("/profile");
                }
            }
        } catch (Exception ignored) {
            response.sendRedirect("/profile");
        }
    }

    private boolean isMultiPartFormat(HttpServletRequest request) {
        String temptype = request.getContentType();
        return temptype.contains("multipart/form-data");
    }

    private void saveFile(FileData tempFile, String type) throws IOException {
        Files.write(Paths.get("C:\\Users\\Birthright\\Documents\\University\\kozlovsky_405\\ThirdSemester\\Sem11-16\\web\\images\\" + type + "\\" + tempFile.getFileName()), tempFile.getByteData());

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
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
        if (login == null && username == null) {
            response.sendRedirect("/news");
        }
        try {
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("add_template.ftl").process(null, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
