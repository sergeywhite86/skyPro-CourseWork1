
import coursework.entitys.Employee;
import coursework.enums.Department;
import coursework.service.EmployeeService;



public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        System.out.println("Список всех сотрудников:");
        service.printAll();
        System.out.println("Затраты на зп в месяц");
        System.out.println(service.sumSalaryInMouth());
        System.out.println("Сотрудник с минимальной зарплатой: " + service.getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + service.getEmployeeWithMaxSalary());
        System.out.println("Средняя зарплата всей фирмы: " + service.averageSalary());
        System.out.println("Распечатка сотрудников по ФИО: ");
        service.printAllFullName();
        System.out.println("Находим сотрудника с минимальной зарплатой по отделу IT");
        System.out.println(service.getEmployeeWithMinSalaryByDepartment(Department.IT));
        System.out.println("Находим сотрудника с максимальной зарплатой по отделу безопасности");
        System.out.println(service.getEmployeeWithMaxSalaryByDepartment(Department.SECURITY));
        System.out.println("Сумма затрат зп отдела продаж");
        System.out.println(service.getSumSalaryInMouthByDepartment(Department.MANAGERS));
        System.out.println("Среднее значение зарплаты по HR отделу");
        System.out.println(service.averageSalaryByDepartment(Department.HR));
        System.out.println("Список сотрудников по департаменту IT");
        service.printAllByDepartment(Department.IT);
        System.out.println("Список ФИО сотрудников по департаменту IT");
        service.printAllFullNameByDepartment(Department.IT);
        System.out.println("Повышаем зарплату всем сотрудникам");
        double salaryBefore = service.getById(1).getSalary();
        service.incrementSalary(10);
        double salaryAfter = service.getById(1).getSalary();
        System.out.printf("Зарплата сотрудника до %.1f %nЗарплата сотрудника после %.1f %n", salaryBefore, salaryAfter);
        System.out.println("Повышаем зарплату сотрудникам отдела управления");
        service.printAllByDepartment(Department.ADMINISTRATION);
        service.incrementSalaryByDepartment(Department.ADMINISTRATION, 20);
        service.printAllByDepartment(Department.ADMINISTRATION);
        System.out.println("Печать всех сотрудников отдела (все данные, кроме отдела)");
        service.printAllByDepartmentExceptDepartment(Department.ADMINISTRATION);
        System.out.println("Печать всех сотрудников с зп меньше числа");
        service.printAllEmployeeWithSalaryLess(57000);
        System.out.println("Печать всех сотрудников с зп больше числа");
        service.printAllEmployeeWithSalaryMore(100_000);
        System.out.println("Добавление нового сотрудника");
        Employee employee =
                new Employee("John", "Connor", "T-1000", Department.ADMINISTRATION, 777);
        System.out.println(service.add(employee));
        System.out.println("Добавление нового сотрудника когда нет места");
        Employee employee2 =
                new Employee("John", "Connor", "T-1000", Department.ADMINISTRATION, 777);
        System.out.println(service.add(employee2));
        System.out.println("Проверка удаления сотрудника по id и получения");
        System.out.println(service.getById(21));
        service.deleteById(21);
        System.out.println("Попытка получить сотрудника после удаления");
        try {
            service.getById(21);
        } catch (NullPointerException ex) {
            System.out.println("T-1000 уничтожен");
        }
    }
}