package coursework.enums;

public enum Department {
    IT("IT"),
    MANAGERS("продажи"),
    HR("HR"),
    SECURITY("безопасность"),
    ADMINISTRATION("управление");

    private final String department;

    Department(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
