package coursework.repository;

import coursework.entitys.Employee;
import coursework.enums.Department;


public interface EmployeeRepository {
    Employee[] getAll();

    double sumSalaryInMouth();

    Employee getEmployeeWithMinSalary();

    Employee getEmployeeWithMaxSalary();

    double averageSalary();

    void incrementSalary(double percent);

    void printAll();

    void printAllFullName();

    void printAllEmployeeWithSalaryLess(double valueSalary);

    void printAllEmployeeWithSalaryMore(double valueSalary);

    double sumSalaryInMouthByDepartment(Department department);

    Employee getEmployeeWithMinSalaryByDepartment(Department department);

    Employee getEmployeeWithMaxSalaryByDepartment(Department department);

    double averageSalaryByDepartment(Department department);

    void incrementSalaryByDepartment(Department department, double percent);

    void printAllByDepartment(Department department);

    void printAllFullNameByDepartment(Department department);

    void printAllByDepartmentExceptDepartment(Department department);

    boolean add(Employee employee);

    void deleteById(long id);

    Employee getById(long id);


}
