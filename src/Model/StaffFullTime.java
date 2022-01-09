package Model;

public class StaffFullTime extends Staff {

    public StaffFullTime(){
    }

    public StaffFullTime(int id, String name, int age, String gender, String phone, String email, String address, boolean status, double salary) {
        super(id, name, age, gender, phone, email, address, status, salary);
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary() * 10;
    }

    @Override
    public String toString() {
        return "Model.StaffFullTime{" + super.toString() + "total salary" + getTotalSalary() + "}";
    }
}
