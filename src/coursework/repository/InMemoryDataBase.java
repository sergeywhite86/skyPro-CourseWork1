package coursework.repository;

import coursework.entitys.Employee;
import coursework.enums.Department;

public class InMemoryDataBase {
    private final Employee[] data = new Employee[21];

    public Employee[] getData() {
        return data;
    }

    public InMemoryDataBase() {
        initDB();
    }

    private void initDB() {
        data[0] = new Employee("Светлана", "Солнцева", "Константиновна", Department.MANAGERS, 57000);
        data[1] = new Employee("Анна", "Булкина", "Федоровна", Department.MANAGERS, 57000);
        data[2] = new Employee("Аркадий", "Продавцов", "Николаевич", Department.MANAGERS, 52000);
        data[3] = new Employee("Екатерина", "Певцова", "Ивановна", Department.MANAGERS, 65000);
        data[4] = new Employee("Александр", "Купидонов", "Васильевич", Department.SECURITY, 59500);
        data[5] = new Employee("Игнат", "Конь", "Николаевич", Department.SECURITY, 61000);
        data[6] = new Employee("Иван", "Скала", "Игоревич", Department.SECURITY, 45000);
        data[7] = new Employee("Игорь", "Рыбов", "Михайлович", Department.SECURITY, 52500);
        data[8] = new Employee("Олег", "Путилов", "Иванович", Department.SECURITY, 53000);
        data[9] = new Employee("Инокентий", "Джавов", "Олегович", Department.IT, 70000);
        data[10] = new Employee("Ксения", "Плюсова", "Александровна", Department.IT, 150000);
        data[11] = new Employee("Мария", "Кошкина", "Сергеевна", Department.IT, 85500);
        data[12] = new Employee("Сергей", "Белый", "Сергеевич", Department.IT, 300000);
        data[13] = new Employee("Сергей", "Бобылев", "Федорович", Department.ADMINISTRATION, 170000);
        data[14] = new Employee("Марина", "Управова", "Ивановна", Department.ADMINISTRATION, 185500);
        data[15] = new Employee("Роман", "Иванов", "Иванович", Department.ADMINISTRATION, 150000);
        data[16] = new Employee("Лариса", "Поисковна", "Олеговна", Department.HR, 85300);
        data[17] = new Employee("Иван", "Гусь", "Константинович", Department.HR, 50000);
        data[18] = new Employee("Дмитрий", "Гришенков", "Викторович", Department.HR, 95000);
        data[19] = new Employee("Лука", "Святой", "Михайлович", Department.HR, 50000);

    }
}
