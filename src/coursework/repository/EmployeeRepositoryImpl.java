package coursework.repository;

import coursework.entitys.Employee;
import coursework.enums.Department;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;


public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Employee[] data;

    public EmployeeRepositoryImpl() {
        InMemoryDataBase dataBase = new InMemoryDataBase();
        data = dataBase.getData();
    }

    @Override
    public Employee[] getAll() {
        return data;
    }

    @Override
    public double sumSalaryInMouth() {
        return Arrays.stream(data).filter(Objects::nonNull).mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return Arrays.stream(data).filter(Objects::nonNull).min(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return Arrays.stream(data).filter(Objects::nonNull).max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();
    }

    public int countOfEmployee() {
        return (int) Arrays.stream(data).filter(Objects::nonNull).count();
    }

    @Override
    public double averageSalary() {
        return sumSalaryInMouth() / countOfEmployee();
    }

    @Override
    public void incrementSalary(double percent) {
        Arrays.stream(data)
                .filter(Objects::nonNull)
                .forEach(emp -> emp.setSalary(emp.getSalary() + emp.getSalary() * (percent / 100)));
    }

    @Override
    public void printAll() {
        Arrays.stream(data)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }

    @Override
    public void printAllFullName() {
        Arrays.stream(data)
                .filter(Objects::nonNull)
                .forEach(emp -> System.out.printf("%s %s %s %n", emp.getSurName(), emp.getName(), emp.getPatronymic()));
    }

    @Override
    public void printAllEmployeeWithSalaryLess(double valueSalary) {
        Arrays.stream(data)
                .filter(Objects::nonNull)
                .filter(emp -> emp.getSalary() < valueSalary)
                .forEach(System.out::println);
    }

    @Override
    public void printAllEmployeeWithSalaryMore(double valueSalary) {
        Arrays.stream(data)
                .filter(Objects::nonNull)
                .filter(emp -> emp.getSalary() >= valueSalary).forEach(System.out::println);
    }

    public Stream<Employee> groupByDepartment(Department department) {
        return Arrays.stream(data)
                .filter(Objects::nonNull)
                .filter(emp -> emp.getDepartment().equals(department));
    }

    @Override
    public double sumSalaryInMouthByDepartment(Department department) {
        return groupByDepartment(department)
                .mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public Employee getEmployeeWithMinSalaryByDepartment(Department department) {
        return groupByDepartment(department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMaxSalaryByDepartment(Department department) {
        return groupByDepartment(department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public double averageSalaryByDepartment(Department department) {
        double sumSalaryInDepartment = groupByDepartment(department).mapToDouble(Employee::getSalary).sum();
        int countEmployeesInDepartment = (int) groupByDepartment(department).count();
        return sumSalaryInDepartment / countEmployeesInDepartment;
    }

    @Override
    public void incrementSalaryByDepartment(Department department, double percent) {
        groupByDepartment(department).forEach(emp -> emp.setSalary(emp.getSalary() + emp.getSalary() * (percent / 100)));
    }

    @Override
    public void printAllByDepartment(Department department) {
        groupByDepartment(department).forEach(System.out::println);
    }

    @Override
    public void printAllFullNameByDepartment(Department department) {
        groupByDepartment(department)
                .filter(Objects::nonNull)
                .forEach(emp -> System.out.printf("%s %s %s %n", emp.getSurName(), emp.getName(), emp.getPatronymic()));
    }

    @Override
    public void printAllByDepartmentExceptDepartment(Department department) {
        groupByDepartment(department)
                .filter(Objects::nonNull)
                .forEach(emp -> System.out.printf("id:%d имя:%s фамилия:%s отчество:%s зарплата:%.1f %n"
                        , emp.getId(), emp.getSurName(), emp.getName(), emp.getPatronymic(), emp.getSalary()));
    }

    @Override
    public boolean add(Employee employee) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = employee;
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(long id) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].getId() == id) data[i] = null;
        }
    }

    @Override
    public Employee getById(long id) {
        return Arrays.stream(data).filter(employee -> employee.getId() == id).findFirst().orElseThrow();
    }
}
