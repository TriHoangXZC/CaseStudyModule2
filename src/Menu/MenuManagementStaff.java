package Menu;

import Manager.StaffManager;

import java.io.IOException;
import java.util.Scanner;

public class MenuManagementStaff {
    static Scanner scanner = new Scanner(System.in);

    public static void menuStaff() throws IOException, ClassNotFoundException {
        StaffManager staffManager = new StaffManager("src/file.txt");

        while (true) {
            try {
                System.out.println("Menu");
                System.out.println("1. Add staff");
                System.out.println("2. Edit staff");
                System.out.println("3. Edit status staff");
                System.out.println("4. Search staff");
                System.out.println("5. Check status staff");
                System.out.println("6. Delete staff");
                System.out.println("7. Display staff by type staff");
                System.out.println("8. Display staff by status");
                System.out.println("9. Display information staff");
                System.out.println("10. Back to login");
                System.out.println("11. Show user account");
                System.out.println("0. Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("1. Add staff full time");
                        System.out.println("2. Add staff part time");
                        int choice1 = Integer.parseInt(scanner.nextLine());

                        if (choice1 == 1) {
                            staffManager.addStaff("StaffFullTime");
                        } else {
                            staffManager.addStaff("StaffPartTime");
                        }
                        break;
                    case 2:
                        staffManager.editById();
                        break;
                    case 3:
                        staffManager.editStatusByName();
                        break;
                    case 4:
                        staffManager.findStaffByName();
                        break;
                    case 5:
                        staffManager.checkStaffStatus();
                        break;
                    case 6:
                        staffManager.removeStaffById();
                        break;
                    case 7:
                        staffManager.showStaffByTypeStaff();
                        break;
                    case 8:
                        staffManager.showStaffByStatus();
                        break;
                    case 9:
                        staffManager.showAllStaff();
                        break;
                    case 10:
                        MenuManagementLogin.menu();
                        break;
                    case 11:
                        staffManager.showUser();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Input Wrong! Please input again");
                }
            } catch (Exception e) {
                System.out.println("Please input number to choice");
            }
        }
    }
}
