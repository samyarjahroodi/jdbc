package menu;

import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final UserService userService = new UserService();

    public Menu() throws SQLException {
    }

    public void pulicMenu() throws SQLException {
        System.out.println("***Welcome***");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit");
        System.out.println("Enter your select:");
        int select = input.nextInt();
        input.nextLine();
        switch (select) {
            case 1 -> enter();
            case 2 -> register();
            case 3 -> System.out.println("exit");
            default -> System.out.println("چته مریضی؟");
        }
    }

    public void register() throws SQLException {
        System.out.println("Enter your firstname:");
        String firstname = input.nextLine();

        System.out.println("Enter your lastname:");
        String lastname = input.nextLine();

        System.out.println("Enter your username:");
        String username = input.nextLine();

        System.out.println("Enter your password:");
        String password = input.nextLine();

        User user = new User(null, firstname, lastname, username, password);
        userService.register(user);
    }

    public void enter() throws SQLException {
        System.out.println("Enter your username:");
        String username = input.nextLine();

        System.out.println("Enter your password:");
        String password = input.nextLine();
        User user = userService.login(username);
        if( user == null && !user.getPassword().equals(password))
            System.out.println("you enter a username and password incorrect");
        else{
            boolean isTrue = true;
            while (isTrue){
            System.out.println("=====================================");
            System.out.println("1-update firstname");
            System.out.println("2-delete yourself");
            System.out.println("3-exit");
            int number = input.nextInt();
            input.nextLine();
            switch (number) {
                case 1 -> userService.changeFirstname(user.getId());
                case 2 -> userService.delete(user.getId());
                case 3 -> isTrue = false;
                default -> System.out.println("hooooy");
            }
            }
        }

    }
}
