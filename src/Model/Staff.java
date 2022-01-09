package Model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private boolean status;
    private double salary;

    public Staff() {
    }

    public Staff(int id, String name, int age, String gender, String phone, String email, String address, boolean status, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        String status = null;
        if (this.status == true) {
            status = "working";
        } else {
            status = "retired";
        }
        return status;
    }

    public double getTotalSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Model.Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", status=" + getStatus() +
                ", salary=" + salary +
                '}';
    }
}
