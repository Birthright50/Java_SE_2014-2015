package ru.kpfu.itis.peter_kozlovsky.db.repository;

import ru.kpfu.itis.peter_kozlovsky.db.model.Template;
import ru.kpfu.itis.peter_kozlovsky.singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Birthright on 19.10.2015.
 */
public class TemplateRepositoryImlp implements TemplateRepository {
    final static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
// types: 1 - news, 2 - articles, 3 - videos
    @Override
    public Integer createNews(Template event) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        Integer create = -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO templates (name, id_user, views, url_image, page, date_temp, type)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, event.getName());
            preparedStatement.setInt(2, event.getId_user());
            preparedStatement.setInt(3, 0);
            preparedStatement.setString(4, event.getUrl_image());
            preparedStatement.setString(5, event.getPage());
            Date date = Calendar.getInstance().getTime();
            preparedStatement.setDate(6, java.sql.Date.valueOf(formatter.format(date)));
            preparedStatement.setByte(7, event.getType());
            create = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return create;
    }

    @Override
    public Integer deleteNews(String login, Integer id) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        Integer delete = -1;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM templates WHERE id=?");
            preparedStatement.setInt(1, id);
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM users WHERE name=?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString(1).equals(login)) {
                    delete = preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return delete;
    }

    @Override
    public Integer updateNews(Template event) {
        Integer update = -1;
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE templates SET  views = ?, url_image = ?, page =? WHERE id = ?");
            preparedStatement.setInt(1, event.getViews());
            preparedStatement.setString(2, event.getUrl_image());
            preparedStatement.setString(3, event.getPage());
            preparedStatement.setInt(4, event.getId());
            update = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return update;
    }

    @Override
    public List<Template> showAll() {
        ArrayList<ru.kpfu.itis.peter_kozlovsky.db.model.Template> aNews = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM templates ORDER BY date_temp DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ru.kpfu.itis.peter_kozlovsky.db.model.Template one_template = new ru.kpfu.itis.peter_kozlovsky.db.model.Template();
                one_template.setId(resultSet.getInt("id"));
                one_template.setName(resultSet.getString("name"));
                one_template.setId_user(resultSet.getInt("id_user"));
one_template.setType(resultSet.getByte("type"));
                one_template.setViews(resultSet.getInt("views"));
                one_template.setUrl_image(resultSet.getString("url_image"));
                one_template.setPage(resultSet.getString("page"));
                one_template.setDate(resultSet.getDate("date_temp"));
                aNews.add(one_template);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return aNews;
    }

    @Override
    public Template getTemplate(Integer id) {
        ru.kpfu.itis.peter_kozlovsky.db.model.Template template = null;
        Connection connection = ConnectionSingleton.getStatement();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM templates WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                template = new ru.kpfu.itis.peter_kozlovsky.db.model.Template();
                template.setId(id);
                template.setPage(resultSet.getString("page"));
                template.setUrl_image(resultSet.getString("url_image"));
                template.setType(resultSet.getByte("type"));
                template.setId_user(resultSet.getInt("id_user"));
                template.setName(resultSet.getString("name"));
                template.setViews(resultSet.getInt("views"));
                template.setDate(resultSet.getDate("date_temp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return template;
    }

    @Override
    public List<Template> showAllForPage(int page, byte type) {
        ArrayList<ru.kpfu.itis.peter_kozlovsky.db.model.Template> aNews = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM templates WHERE type = ? ORDER BY date_temp DESC LIMIT 12 OFFSET ?");
            preparedStatement.setByte(1, type);
            preparedStatement.setInt(2, (page - 1) * 12);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Template one_template = new Template();
                one_template.setId(resultSet.getInt("id"));
                one_template.setName(resultSet.getString("name"));
                one_template.setId_user(resultSet.getInt("id_user"));
                one_template.setViews(resultSet.getInt("views"));
                one_template.setUrl_image(resultSet.getString("url_image"));
                one_template.setPage(resultSet.getString("page"));
                one_template.setDate(resultSet.getDate("date_temp"));
                one_template.setType(resultSet.getByte("type"));
                aNews.add(one_template);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return aNews;
    }


}
