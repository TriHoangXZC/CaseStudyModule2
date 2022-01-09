package Model;

public class StaffPartTime extends Staff {
    private int workHour;

    public StaffPartTime(int id, String name, int age, String gender, String phone, String email, String address, boolean status, double salary, int workHour) {
        super(id, name, age, gender, phone, email, address, status, salary);
        this.workHour = workHour;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary() * getWorkHour();
    }

    @Override
    public String toString() {
        return "Model.StaffPartTime{" + super.toString() +
                "workHour=" + workHour +
                "total salary" + getTotalSalary() +
                '}';
    }
}
