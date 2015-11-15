package ru.kpfu.itis.peter_kozlovsky.servlets;

import com.ibm.useful.http.FileData;
import com.ibm.useful.http.PostData;
import freemarker.template.TemplateException;
import ru.kpfu.itis.peter_kozlovsky.db.DBHelper;
import ru.kpfu.itis.peter_kozlovsky.db.model.Ad;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConfigSingleton;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Birthright on 14.11.2015.
 */
@WebServlet(name = "AddAdServlet")
public class AddAdServlet extends HttpServlet {
    private static final int IMG_WIDTH = 240;
    private static final int IMG_HEIGHT = 160;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
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
                String name = new String(multidata.getParameter("name").getBytes(), "UTF-8");
                String city = new String(multidata.getParameter("city").getBytes(), "UTF-8");
                int probeg = Integer.parseInt(new String(multidata.getParameter("probeg").getBytes(), "UTF-8"));
                int year = Integer.parseInt(new String(multidata.getParameter("year").getBytes(), "UTF-8"));
                int price = Integer.parseInt(new String(multidata.getParameter("price").getBytes(), "UTF-8"));
                String text = new String(multidata.getParameter("text").getBytes(), "UTF-8");

                FileData[] images = new FileData[5];
                Path path = Paths.get(getServletContext().getRealPath("/") + "\\images\\all_adds\\");
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }
                for (int i = 0; i < 5; i++) {
                    images[i] = multidata.getFileData("img" + (i + 1));
                    System.out.println(multidata.getFileData("img" + (i + 1)) != null);
                    saveFile(images[i]);
                }

                for (int i = 0; i < 5; i++) {
                    BufferedImage originalImage = ImageIO.read(new File(getServletContext().getRealPath("/") + "images\\all_adds\\"
                            + new String(images[i].getFileName().getBytes(), "UTF-8")));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
                    BufferedImage resizeImagePng = resizeImage(originalImage, type);
                    ImageIO.write(resizeImagePng, "png", new File(getServletContext().getRealPath("/") + "images\\all_adds\\"
                            + new String(images[i].getFileName().getBytes(), "UTF-8").replace(".jpg", "") + ".png"));
                }
                Ad ad = new Ad();
                ad.setCity(city);
                ad.setName(name);
                ad.setProbeg(probeg);
                ad.setPrice(price);
                ad.setYear(year);
                ad.setId_user(DBHelper.userRepository.getUser(login).getId());
                ad.setText(text);
                ad.setUrl_image_1("/images/all_adds/" + new String(images[0].getFileName().getBytes(), "UTF-8").replace(".jpg", ""));
                ad.setUrl_image_2("/images/all_adds/" + new String(images[1].getFileName().getBytes(), "UTF-8").replace(".jpg", ""));
                ad.setUrl_image_3("/images/all_adds/" + new String(images[2].getFileName().getBytes(), "UTF-8").replace(".jpg", ""));
                ad.setUrl_image_4("/images/all_adds/" + new String(images[3].getFileName().getBytes(), "UTF-8").replace(".jpg", ""));
                ad.setUrl_image_5("/images/all_adds/" + new String(images[4].getFileName().getBytes(), "UTF-8").replace(".jpg", ""));
                DBHelper.adRepository.createAd(ad);
                response.sendRedirect("/buy");
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.sendRedirect("/buy");
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    private boolean isMultiPartFormat(HttpServletRequest request) {
        String temptype = request.getContentType();
        return temptype.contains("multipart/form-data");
    }

    private void saveFile(FileData tempFile) throws IOException {
        Files.write(Paths.get(getServletContext().getRealPath("/") + "images\\all_adds\\" + new String(tempFile.getFileName().getBytes(), "UTF-8")), tempFile.getByteData());
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
            ConfigSingleton.getConfiguration(getServletContext()).getTemplate("add_ad.ftl").process(null, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
