package Menu;

import Manager.ManagerLogin;
import Model.User;

import java.io.IOException;
import java.util.Scanner;

public class MenuManagementLogin {
    static Scanner scanner = new Scanner(System.in);
    static User temp;

    public static User getTemp() {
        return temp;
    }

    public static void menu() {
        while (true) {
            try {
                System.out.println("Welcome");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("Please choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Please choice 1 or 2!");
            }
        }
    }

    public static void login() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Input Username: ");
            String userName = scanner.nextLine();
            System.out.println("Input Password: ");
            String passWord = scanner.nextLine();
            ManagerLogin.readFileLogin();
            for (User login : ManagerLogin.userArrayList) {
                if (login.getUserName().equals(userName) && login.getPassWord().equals(passWord)) {
                    System.out.println("Welcome " + userName);
                    temp = login;
                    MenuManagementStaff.menuStaff();
                    return;
                }
            }
            System.err.println("Wrong username / password");
        }
    }

    public static void register() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Input username: ");
            String userName = scanner.nextLine();
            System.out.println("Input password: ");
            String passWord = scanner.nextLine();
            ManagerLogin.readFileLogin();
            for (User login : ManagerLogin.userArrayList) {
                if(login.getUserName().equals(userName)){
                    System.err.println("Username already exist");
                    return;
                }
            }
            System.out.println("Login to access the system");
            ManagerLogin.userArrayList.add(new User(userName,passWord));
            ManagerLogin.writeFileLogin();
            break;
        }
        login();
    }
}
