package Manager;

import Menu.MenuManagementLogin;
import Model.Staff;
import Model.StaffFullTime;
import Model.StaffPartTime;
import Validate.Regex;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Staff> staffArrayList = new ArrayList<>();
    private final String nameFile;

    public StaffManager(String nameFile) {
        this.nameFile = nameFile;
    }

    public static Staff creatStaff(String typeStaff) {
        int id = getId();
        String name = getName();
        int age = getAge();
        String gender = getGender();
        String phone = getPhone();
        String email = getEmail();
        String address = getAddress();
        boolean status = isStatus();
        double salary = getSalary();
        if (typeStaff.equals("StaffFullTime")) {
            return new StaffFullTime(id, name, age, gender, phone, email, address, status, salary);
        } else {
            System.out.println("Input workHour: ");
            int workHour = Integer.parseInt(scanner.nextLine());
            return new StaffPartTime(id, name, age, gender, phone, email, address, status, salary, workHour);
        }
    }

    public void addStaff(String typeStaff) throws IOException, ClassNotFoundException {
        read();
        Staff staff = creatStaff(typeStaff);
        staffArrayList.add(staff);
        System.out.println("Add staff successfully");
        save();
    }

    public void showAllStaff() throws IOException, ClassNotFoundException {
        read();
        for (Staff staff : staffArrayList) {
            System.out.println(staff);
        }
    }

    public void removeStaffById() {
        try {
            read();
            System.out.println("Input Id want remove: ");
            int id = Integer.parseInt(scanner.nextLine());
            int check = -1;
            for (int i = 0; i < staffArrayList.size(); i++) {
                if (staffArrayList.get(i).getId() == id) {
                    check = i;
                }
            }
            if (check < 0) {
                System.out.println("Id is not exist");
            } else {
                staffArrayList.remove(check);
                System.out.println("Remove successfully");
            }
            save();
        } catch (Exception e) {
            System.err.println("Id must be number");
        }
    }

    public void findStaffByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Input name want find: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i).getName().equals(name)) {
                check = i;
                System.out.println(staffArrayList.get(i));
            }
        }
        if (check < 0) {
            System.out.println("Name is not exist");
        }
    }

    public void showStaffByStatus() throws IOException, ClassNotFoundException {
        read();
        System.out.println("1. List staff working: ");
        System.out.println("2. List staff retired: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            for (Staff staff : staffArrayList) {
                if (staff.isStatus()) {
                    System.out.println(staff);
                }
            }
        } else {
            for (Staff staff : staffArrayList) {
                if (!staff.isStatus()) {
                    System.out.println(staff);
                }
            }
        }
    }

    public void checkStaffStatus() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Input name staff want check status: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Staff is not exist");
        } else {
            System.out.println("Staff" + staffArrayList.get(check).getName() + " " + staffArrayList.get(check).getStatus());
        }
    }

    public void showStaffByTypeStaff() throws IOException, ClassNotFoundException {
        read();
        System.out.println("1. List staff full time: ");
        System.out.println("2. List staff part time: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            for (Staff staff : staffArrayList) {
                if (staff instanceof StaffFullTime) {
                    System.out.println(staff);
                }
            }
        } else {
            for (Staff staff : staffArrayList) {
                if (staff instanceof StaffPartTime) {
                    System.out.println(staff);
                }
            }
        }
    }

    public void editStatusByName() throws IOException, ClassNotFoundException {
        read();
        System.out.println("Input name staff want check status: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i).getName().equals(name)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Staff is not exist");
        } else {
            if (staffArrayList.get(check).isStatus()) {
                staffArrayList.get(check).setStatus(false);
            } else {
                staffArrayList.get(check).setStatus(true);
                System.out.println(staffArrayList.get(check));
            }
        }
        save();
    }

    public void editByName() throws IOException {
        System.out.println("Input name want edit: ");
        String nameEdit = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i).getName().equals(nameEdit)) {
                check = i;
            }
        }
        if (check < 0) {
            System.out.println("Name is not in the list");
        } else if (staffArrayList.get(check) instanceof StaffFullTime) {
            staffArrayList.remove(check);
            staffArrayList.add(check, creatStaff("StaffFullTime"));

//            int id = getId();
//            String name = getName();
//            int age = getAge();
//            String gender = getGender();
//            String phone = getPhone();
//            String email = getEmail();
//            String address = getAddress();
//            boolean status = isStatus();
//            double salary = getSalary();
//            staffArrayList.get(check).setId(id);
//            staffArrayList.get(check).setName(name);
//            staffArrayList.get(check).setAge(age);
//            staffArrayList.get(check).setGender(gender);
//            staffArrayList.get(check).setPhone(phone);
//            staffArrayList.get(check).setEmail(email);
//            staffArrayList.get(check).setAddress(address);
//            staffArrayList.get(check).setStatus(status);
//            staffArrayList.get(check).setSalary(salary);
//            if (staffArrayList.get(check) instanceof StaffPartTime) {
//                System.out.println("Input work hour: ");
//                int workHour = scanner.nextInt();
//                scanner.nextLine();
//                ((StaffPartTime) staffArrayList.get(check)).setWorkHour(workHour);
            } else {
            staffArrayList.remove(check);
            staffArrayList.add(check, creatStaff("StaffPartTime"));
        }
        save();
    }

    public void showUser() {
        System.out.println(MenuManagementLogin.getTemp());
    }


    private static int getId() {
        while (true) {
            try {
                System.out.println("Input ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (Regex.validateId(String.valueOf(id))) {
                    for (Staff staff : staffArrayList) {
                        if (staff.getId() == id) {
                            throw new Exception();
                        }
                    }
                    return id;
                } else System.out.println("ID must be correct format (0-9)");
            } catch (Exception e) {
                System.err.println("ID already exist");
            }
        }
    }

    private static String getName() {
        String name;
        while (true) {
            try {
                System.out.println("Input name: ");
                name = scanner.nextLine();
                if (Regex.validateName(name)) {
                    return name;
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Name must be correct format");
            }
        }
    }

    private static String getAddress() {
        System.out.println("Input address: ");
        return scanner.nextLine();
    }

    private static String getGender() {
        while (true) {
            try {
                System.out.println("Input gender (Male/Female): ");
                return scanner.nextLine();
            } catch (Exception e) {
                System.err.println("Gender is only male or female! Please input again!");
            }
        }
    }

    private static String getPhone() {
        while (true) {
            try {
                System.out.println("Input phone number: ");
                String phone = scanner.nextLine();
                if (Regex.validatePhone(phone)) {
                    return phone;
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Phone number can not be left blank");
            }
        }
    }

    private static int getAge() {
        while (true) {
            try {
                System.out.println("Input age: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (Regex.validateAge(String.valueOf(age))) {
                    if (age < 15 || age > 60) {
                        throw new Exception();
                    } else return age;
                }
            } catch (Exception e) {
                System.err.println("Age must be correct format");
                System.out.println("Input age from 16 to 59");
            }
        }
    }

    private static String getEmail() {
        while (true) {
            try {
                System.out.println("Input email: ");
                String email = scanner.nextLine();
                int check = -1;
                if (Regex.validateEmail(email)) {
                    for (Staff staff : staffArrayList) {
                        if (staff.getEmail().equals(email)) {
                            check = 1;
                        }
                    }
                    if (check < 0) {
                        return email;
                    } else {
                        System.out.println("Email already exist");
                    }
                }
            } catch (Exception e) {
                System.err.println("Email must be correct format");
            }
        }
    }

    private static double getSalary() {
        while (true) {
            try {
                System.out.println("Input salary: ");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Wrong format, salary must be number");
            }
        }

    }

    private static boolean isStatus() {
        while (true) {
            try {
                System.out.println("Input Status (working: 1), (retired: 2): ");
                boolean status = false;
                int status1 = Integer.parseInt(scanner.nextLine());
                if (status1 == 1) {
                    status = true;
                } else if (status1 == 2) {
                    status = false;
                } else {
                    throw new Exception();
                }
                return status;
            } catch (Exception e) {
                System.err.println("Input failed");
            }
        }
    }


    public void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(nameFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(staffArrayList);
    }

    public void read() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(nameFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            staffArrayList = (ArrayList<Staff>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
