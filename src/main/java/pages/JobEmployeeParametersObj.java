package pages;

public class JobEmployeeParametersObj {
    private static  String xputNameEmployee;
    private static String userName;
    private static String userRole;
    private static String employeeNameJob;
    private static String status;
    private static String paswrd;

    public String getXputNameEmployee() {
        return xputNameEmployee;
    }

    public JobEmployeeParametersObj setXputNameEmployee(String xputNameEmployee) {
        JobEmployeeParametersObj.xputNameEmployee = xputNameEmployee;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public JobEmployeeParametersObj setUserName(String userName) {
        JobEmployeeParametersObj.userName = userName;
        return this;
    }

    public  String getUserRole() {
        return userRole;
    }

    public  JobEmployeeParametersObj setUserRole(String userRole) {
        JobEmployeeParametersObj.userRole = userRole;
        return this;
    }

    public  String getEmployeeNameJob() {
        return employeeNameJob;
    }

    public  JobEmployeeParametersObj setEmployeeNameJob(String employeeNameJob) {
        JobEmployeeParametersObj.employeeNameJob = employeeNameJob;
        return this;
    }

    public  String getStatus() {
        return status;
    }

    public  JobEmployeeParametersObj setStatus(String status) {
        JobEmployeeParametersObj.status = status;
        return this;
    }

    public  String getPaswrd() {
        return paswrd;
    }

    public  JobEmployeeParametersObj setPaswrd(String paswrd) {
        JobEmployeeParametersObj.paswrd = paswrd;
        return this;
    }
}
