package db.repository;

import db.model.User;

import java.util.List;

/**
 * Created by Birthright on 18.10.2015.
 */
public interface UserRepository {


    Boolean createUser(User event);

    Boolean deleteUser(String login, String password);

    Boolean updateUser(User event);

    List<User> showAll();

    User getUser(String login);
}
