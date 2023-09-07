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

    public void register(User user) throws SQLException {
        int result = userRepositroy.save(user);
        if(result != 0)
            System.out.println(user.getFirstname() + " successfully added to database");
        else
            System.out.println("OOps! :(");
    }

    public User login(String username) throws SQLException {
        User user = userRepositroy.login(username);
        return user;
    }

    public void changeFirstname(int id) throws SQLException {
        System.out.println("Please enter your new firstname:");
        String firstname = input.nextLine();
        int result = userRepositroy.updateFirstname(firstname, id);
        if(result != 0)
            System.out.println("successfully edited to database");
        else
            System.out.println("OOps! :(");
    }

    public void delete(int id) throws SQLException {
        int result = userRepositroy.delete(id);
        if(result != 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("OOps! :(");
    }
}
