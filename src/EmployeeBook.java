import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public EmployeeBook() {
        Arrays.fill(this.employees, null);
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            Employee currentEmployee = employees[i];

            if (currentEmployee == null) {
                employees[i] = employee;

                return true;
            }
        }

        return false;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            int currentEmployeeId = employees[i].getId();

            if (currentEmployeeId == id) {
                employees[i] = null;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            int currentEmployeeId = employee.getId();

            if (currentEmployeeId == id) {
                return employee;
            }
        }

        return null;
    }

    public void showEmployees() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
    }

    public float getSalaryAmount() {
        float sum = 0;

        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }

        return sum;
    }

    public float getSalaryMin() {
        float min = this.employees[0].getSalary();

        for (Employee employee : this.employees) {
            float salary = employee.getSalary();

            if (salary < min) {
                min = salary;
            }
        }

        return min;
    }

    public float getSalaryMax() {
        float max = this.employees[0].getSalary();

        for (Employee employee : this.employees) {
            float salary = employee.getSalary();

            if (salary > max) {
                max = salary;
            }
        }

        return max;
    }

    public float getSalaryAverage() {
        float sum = getSalaryAmount();

        return sum / this.employees.length;
    }

    public void printEmployeesFullNames() {
        for (Employee employee : this.employees) {
            System.out.println(employee.getFullName());
        }
    }

    public void performSalaryIndexation(int indexationPercentage) {
        for (Employee employee : this.employees) {
            float salary = employee.getSalary();
            salary += salary * indexationPercentage / 100;

            employee.setSalary(salary);
        }
    }

    public Employee[] getEmployeeListByDepartment(int department) {
        int counterByDepartment = 0;

        for (Employee employee : this.employees) {
            int employeeDepartment = employee.getDepartment();

            if (department == employeeDepartment) {
                counterByDepartment++;
            }
        }

        if (counterByDepartment == 0) {
            throw new IllegalArgumentException("В департамент " + department + " сотрудники не наняты");
        }

        Employee[] employeesByDepartment = new Employee[counterByDepartment];

        counterByDepartment = 0;

        for (Employee employee : this.employees) {
            int employeeDepartment = employee.getDepartment();

            if (department == employeeDepartment) {
                employeesByDepartment[counterByDepartment] = employee;

                counterByDepartment++;
            }
        }

        return employeesByDepartment;
    }

    public float getSalaryMinByDepartment(int department) {
        float minSalary = this.employees[0].getSalary();

        Employee[] employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();

            if (salary < minSalary) {
                minSalary = salary;
            }
        }

        return minSalary;
    }

    public float getSalaryMaxByDepartment(int department) {
        float maxSalary = this.employees[0].getSalary();

        Employee[] employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();

            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }

        return maxSalary;
    }

    public float getSalaryAmountByDepartment(int department) {
        float sumSalary = 0;

        Employee[] employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();

            sumSalary += salary;
        }

        return sumSalary;
    }

    public float getSalaryAverageByDepartment(int department) {
        float sumSalary = getSalaryAmountByDepartment(department);

        Employee[] employeeByDepartment = getEmployeeListByDepartment(department);

        return sumSalary / employeeByDepartment.length;
    }

    public void performSalaryIndexationByDepartment(int indexationPercentage, int department) {
        Employee[] employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            float salary = employee.getSalary();
            salary += salary * indexationPercentage / 100;

            employee.setSalary(salary);
        }
    }

    public void showEmployeeWithoutDepartment(Employee employee) {
        System.out.println("Employee {" + "id=" + employee.getId() + ", fullName='" + employee.getFullName() + '\'' + ", salary=" + employee.getSalary() + '}');
    }

    public void showEmployeesByDepartment(int department) {
        Employee[] employeeByDepartment = getEmployeeListByDepartment(department);

        for (Employee employee : employeeByDepartment) {
            showEmployeeWithoutDepartment(employee);
        }
    }

    public void getSalaryLessThanPointer(int pointer) {
        for (Employee employee : this.employees) {
            float salary = employee.getSalary();

            if (salary < pointer) {
                showEmployeeWithoutDepartment(employee);
            }
        }
    }

    public void getSalaryMoreThanPointer(int pointer) {
        for (Employee employee : this.employees) {
            float salary = employee.getSalary();

            if (salary >= pointer) {
                showEmployeeWithoutDepartment(employee);
            }
        }
    }
}
