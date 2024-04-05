package pages;

public class EmployeeParametersObj {
    private static String xputUserName;
    private static String firstName;
    private static String middleName;
    private static String lastName;
    private static String employeeId;

    public static String getXputUserName() {
        return xputUserName;
    }

    public  EmployeeParametersObj setXputUserName(String xputUserName) {
        EmployeeParametersObj.xputUserName = xputUserName;
        return this;
    }

    public static String getFirstName() {
        return firstName;
    }

    public  EmployeeParametersObj setFirstName(String firstName) {
        EmployeeParametersObj.firstName = firstName;
        return this;
    }

    public static String getMiddleName() {
        return middleName;
    }

    public EmployeeParametersObj setMiddleName(String middleName) {
        EmployeeParametersObj.middleName = middleName;
        return this;
    }

    public static String getLastName() {
        return lastName;
    }

    public  EmployeeParametersObj setLastName(String lastName) {
        EmployeeParametersObj.lastName = lastName;
        return this;
    }

    public static String getEmployeeId() {
        return employeeId;
    }

    public  EmployeeParametersObj setEmployeeId(String employeeId) {
        EmployeeParametersObj.employeeId = employeeId;
        return this;
    }
}
