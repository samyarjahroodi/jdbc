package service;

import model.User;
import repository.UserRepositroy;

import java.sql.SQLException;
import java.util.Scanner;

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

    public void login() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter you username:");
        String username = input.nextLine();
        System.out.println("Please enter you password:");
        String password = input.nextLine();

        User user = userRepositroy.login(username);
        if((user != null) && user.getPassword().equals(password))
            System.out.println("login successfully");
        else
            System.out.println("Bad Credentials");
    }
}
