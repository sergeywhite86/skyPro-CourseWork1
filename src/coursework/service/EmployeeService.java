package coursework.service;

import coursework.entitys.Employee;
import coursework.enums.Department;
import coursework.repository.EmployeeRepositoryImpl;


public class EmployeeService {
    private final EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl();

    public double sumSalaryInMouth() {
        return repository.sumSalaryInMouth();
    }

    public Employee getEmployeeWithMinSalary() {
        return repository.getEmployeeWithMinSalary();
    }

    public Employee getEmployeeWithMaxSalary() {
        return repository.getEmployeeWithMaxSalary();
    }

    public double averageSalary() {
        return repository.averageSalary();
    }

    public void incrementSalary(double percent) {
        repository.incrementSalary(percent);
    }

    public void printAll() {
        repository.printAll();
    }

    public void printAllFullName() {
        repository.printAllFullName();
    }

    public void printAllEmployeeWithSalaryLess(double valueSalary) {
        repository.printAllEmployeeWithSalaryLess(valueSalary);
    }

    public void printAllEmployeeWithSalaryMore(double valueSalary) {
        repository.printAllEmployeeWithSalaryMore(valueSalary);
    }

    public double getSumSalaryInMouthByDepartment(Department department) {
        return repository.sumSalaryInMouthByDepartment(department);
    }

    public Employee getEmployeeWithMinSalaryByDepartment(Department department) {
        return repository.getEmployeeWithMinSalaryByDepartment(department);
    }

    public Employee getEmployeeWithMaxSalaryByDepartment(Department department) {
        return repository.getEmployeeWithMaxSalaryByDepartment(department);
    }

    public double averageSalaryByDepartment(Department department) {
        return repository.averageSalaryByDepartment(department);
    }

    public void incrementSalaryByDepartment(Department department, double percent) {
        repository.incrementSalaryByDepartment(department, percent);
    }

    public void printAllByDepartment(Department department) {
        repository.printAllByDepartment(department);
    }

    public void printAllFullNameByDepartment(Department department) {
        repository.printAllFullNameByDepartment(department);
    }

    public void printAllByDepartmentExceptDepartment(Department department) {
        repository.printAllByDepartmentExceptDepartment(department);
    }

    public boolean add(Employee employee) {
        return repository.add(employee);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public Employee getById(long id) {
        return repository.getById(id);
    }
}
