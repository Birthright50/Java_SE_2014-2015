package db;

import db.model.User;
import db.repository.NewsRepositoryImlp;
import db.repository.UserRepositoryImpl;
import hash.SHA256;
import hash.SlowHasher;

import java.nio.charset.StandardCharsets;

/**
 * Created by Birthright on 18.10.2015.
 */
public class DBHelper {
    public static UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public static NewsRepositoryImlp newsRepository = new NewsRepositoryImlp();

    public static String checkUser(String login, String password) {
        User user = userRepository.getUser(login);
        if (user == null) {
            return "bad_login";
        }
        String salt = user.getSalt();
        if (new String(new SlowHasher().calculateSlowHash(new SHA256(), password, salt.getBytes(StandardCharsets.UTF_8)),
                StandardCharsets.UTF_8).equals(user.getPassword())) {
            return "OK";
        }
        return "bad_pwd";
    }



    public static Boolean checkRegistration(String login) {
        User user = userRepository.getUser(login);
        return user != null;
    }
}
