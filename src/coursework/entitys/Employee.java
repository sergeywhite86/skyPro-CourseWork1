package coursework.entitys;

import coursework.enums.Department;

import java.util.Objects;

public class Employee {
    private static long idCount;
    private final long id;
    private String name;
    private String surName;
    private String patronymic;
    private Department department;
    private double salary;

    public Employee(String name, String surName, String patronymic, Department department, double salary) {
        this.name = name;
        this.surName = surName;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        idCount++;
        this.id = idCount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName) && Objects.equals(patronymic, employee.patronymic) && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, patronymic, department, salary);
    }

    @Override
    public String toString() {
        return "id:" + id +
                " имя:" + name +
                " фамилия:" + surName +
                " отчество:" + patronymic +
                " отдел:" + department.getDepartment() +
                " зарплата:" + salary;
    }
}
