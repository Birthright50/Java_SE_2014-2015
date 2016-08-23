package db.repository;

import db.model.News;
import singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Birthright on 19.10.2015.
 */
public class NewsRepositoryImlp implements NewsRepository {
    @Override
    public Integer createNews(News event) {
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        Integer create = -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO news (name, id_user, comments, views, url, url_image, page)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, event.getName());
            preparedStatement.setInt(2, event.getId_user());
            preparedStatement.setInt(3, event.getComments());
            preparedStatement.setInt(4, event.getViews());
            preparedStatement.setString(5, event.getUrl());
            preparedStatement.setString(6, event.getUrl_image());
            preparedStatement.setString(7, event.getPage());
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
            preparedStatement = connection.prepareStatement("DELETE FROM news WHERE id=?");
            preparedStatement.setInt(1, id);
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM users WHERE id=?");
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
    public Integer updateNews(News event) {
        Integer update = -1;
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("UPDATE news SET comments = ?, views = ?, url_image = ?, page =? WHERE id = ?");
            preparedStatement.setInt(1, event.getComments());
            preparedStatement.setInt(2, event.getViews());
            preparedStatement.setString(3, event.getUrl_image());
            preparedStatement.setString(4, event.getPage());
            preparedStatement.setInt(5, event.getId());
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
    public List<News> showAll() {
        ArrayList<News> news = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM news ORDER BY date DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                News one_news = new News();
                one_news.setId(resultSet.getInt("id"));
                one_news.setName(resultSet.getString("name"));
                one_news.setId_user(resultSet.getInt("id_user"));
                one_news.setComments(resultSet.getInt("comments"));
                one_news.setViews(resultSet.getInt("views"));
                one_news.setUrl(resultSet.getString("url"));
                one_news.setUrl_image(resultSet.getString("url_image"));
                one_news.setPage(resultSet.getString("page"));
                one_news.setDate(resultSet.getString("date"));
                news.add(one_news);
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
        return news;
    }

    @Override
    public News getNews(Integer id) {
        News news = null;
        Connection connection = ConnectionSingleton.getStatement();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM news where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                news = new News();
                news.setId(id);
                news.setPage(resultSet.getString("page"));
                news.setUrl_image(resultSet.getString("url_image"));
                news.setUrl(resultSet.getString("url"));
                news.setComments(resultSet.getInt("comments"));
                news.setId_user(resultSet.getInt("id_user"));
                news.setName(resultSet.getString("name"));
                news.setViews(resultSet.getInt("views"));
                news.setDate(resultSet.getString("date"));
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
        return news;
    }

    public ArrayList<HashMap<String, String>> getNewstoFrMark() {
        ArrayList<HashMap<String, String>> news = new ArrayList<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM news ORDER BY date DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("url", resultSet.getString("url"));
                map.put("url_image", resultSet.getString("url_image"));
                map.put("name", resultSet.getString("name"));
                map.put("views", resultSet.getInt("views") + "");
                map.put("comments", resultSet.getInt("comments") + "");
                map.put("date", resultSet.getDate("date").toString());
                news.add(map);
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
        return news;
    }
}
