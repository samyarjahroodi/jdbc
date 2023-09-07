package service;

import model.User;
import repository.UserRepositroy;

import java.sql.SQLException;

public class UserService {

    private final UserRepositroy userRepositroy = new UserRepositroy();

    public UserService() throws SQLException {
    }

    public void register() throws SQLException {
        User user = new User(null, "farzad", "afi", "farzadafi", "1111");
        int result = userRepositroy.save(user);
        if(result != 0)
            System.out.println(user.getFirstname() + " successfully added to database");
        else
            System.out.println("OOps! :(");
    }
}
