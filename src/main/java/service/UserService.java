package service;

import model.User;
import repository.UserRepositroy;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final UserRepositroy userRepositroy = new UserRepositroy();
    Scanner input = new Scanner(System.in);

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

    public void changeFirstname() throws SQLException {
        System.out.println("Please enter your new firstname:");
        String firstname = input.nextLine();
        int result = userRepositroy.updateFirstname(firstname);
        if(result != 0)
            System.out.println("successfully edited to database");
        else
            System.out.println("OOps! :(");
    }
}
