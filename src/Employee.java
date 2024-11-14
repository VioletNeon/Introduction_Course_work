import java.util.Objects;

public class Employee {
    static int counter = 1;

    private final int id;
    private final String fullName;
    private int department;
    private float salary;

    public Employee(String fullName, int department, float salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;

        this.id = counter;

        Employee.counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object entity) {
        if (this == entity) return true;
        if (entity == null || getClass() != entity.getClass()) return false;

        Employee employee = (Employee) entity;

        return this.department == employee.department && this.id == employee.id && this.salary == employee.salary && this.fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.fullName, this.department, this.salary);
    }
}
