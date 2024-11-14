public class Main {
    private static final int MAX_SALARY = 200_000;
    private static final int MIN_SALARY = 25_000;
    private static final int INITIAL_DEPARTMENT_INDEX = 1;
    private static final int FINAL_DEPARTMENT_INDEX = 5;
    private static final String[] FULL_NAMES_LIST = new String[]{
            "Прохоров Евгений Пётрович",
            "Карпов Даниил Антонинович",
            "Матвеев Артур Геннадиевич",
            "Киселёв Лазарь Максович",
            "Сазонов Герман Гордеевич",
            "Гуляев Велорий Феликсович",
            "Никитин Давид Игоревич",
            "Емельянов Вилен Олегович",
            "Фролов Казимир Тихонович",
            "Панов Харитон Давидович",
            "Овчинников Юлиан Авдеевич",
            "Комиссаров Кассиан Ярославович",
            "Миронов Аверьян Платонович",
            "Макаров Ростислав Степанович",
            "Бобров Павел Максимович",
    };

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        boolean isBookFull = false;

        while (!isBookFull) {
            int randomFullNameIndex = getRandomNumber(0, FULL_NAMES_LIST.length - 1);
            int randomDepartment = getRandomNumber(INITIAL_DEPARTMENT_INDEX, FINAL_DEPARTMENT_INDEX);
            int randomSalary = getRandomNumber(MIN_SALARY, MAX_SALARY);

            String randomFullName = FULL_NAMES_LIST[randomFullNameIndex];
            Employee employee = new Employee(randomFullName, randomDepartment, randomSalary);

            boolean addEmployeeStatus = employeeBook.addEmployee(employee);

            if (!addEmployeeStatus) {
                isBookFull = true;
                System.out.println("Книга сотрудников заполнена. Свободных мест для записи - нет." + "\n");
            } else {
                System.out.println("Добавлен сотрудник: " + "\n" + employee + "\n");
            }
        }

        employeeBook.showEmployees();

        System.out.println("\n" + "Удалим сотрудника с id: 3");
        employeeBook.removeEmployee(3);

        System.out.println("Покажем результат после удаления:");
        employeeBook.showEmployees();

        Employee aditionalEmployee = new Employee(FULL_NAMES_LIST[11], 5, 35_000F);
        System.out.println("\n" + "Добавим сотрудника - результат: " + employeeBook.addEmployee(aditionalEmployee) + "\n");

        System.out.println("Найдем добавленного сотрудника по id:" + "\n" + employeeBook.getEmployeeById(aditionalEmployee.getId()) + "\n");

        System.out.println("Посчитаем суммарную зарплату: " + employeeBook.getSalaryAmount() + "\n");

        System.out.println("Найдем минимальную зарплату: " + employeeBook.getSalaryMin() + "\n");

        System.out.println("Найдем максимальную зарплату: " + employeeBook.getSalaryMax() + "\n");

        System.out.println("Найдем среднюю зарплату: " + employeeBook.getSalaryAverage() + "\n");

        System.out.println("Распечатаем все ФИО:");
        employeeBook.printEmployeesFullNames();

        System.out.println("\n" + "Проиндексируем зарплаты на 7% всем сотрудникам. Результат индексации:");
        employeeBook.performSalaryIndexation(7);
        employeeBook.showEmployees();

        System.out.println("\n" + "Найдем минимальную зарплату по отделу: " + employeeBook.getSalaryMinByDepartment(5) + "\n");

        System.out.println("Найдем максимальную зарплату по отделу: " + employeeBook.getSalaryMaxByDepartment(5) + "\n");

        System.out.println("Найдем сумму зарплат по отделу: " + employeeBook.getSalaryAmountByDepartment(5) + "\n");

        System.out.println("Найдем среднюю зарплату по отделу: " + employeeBook.getSalaryAverageByDepartment(5) + "\n");

        System.out.println("Проиндексируем зарплаты на 5% всем сотрудникам по отделу. Результат индексации:");
        employeeBook.performSalaryIndexationByDepartment(5, 5);
        employeeBook.showEmployeesByDepartment(5);

        System.out.println("\n" + "Найдем зарплату больше чем - " + 34_000 + ". " + "И покажем результат:");
        employeeBook.getSalaryMoreThanPointer(34_000);

        System.out.println("\n" + "Найдем зарплату меньше чем - " + 55_000 + ". " + "И покажем результат:");
        employeeBook.getSalaryLessThanPointer(55_000);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.floor(Math.random() * (max - min + 1)) + min);
    }
}