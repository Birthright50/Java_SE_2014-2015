package db.repository;

import db.model.User;

import java.util.List;

/**
 * Created by Birthright on 18.10.2015.
 */
public interface UserRepository {


    Integer createUser(User event);

    Integer deleteUser(String login, String password);

    Integer updateUser(User event);

    List<User> showAll();

    User getUser(String login);
}
