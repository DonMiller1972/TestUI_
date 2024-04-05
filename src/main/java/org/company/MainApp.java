package org.company;

import org.openqa.selenium.WebDriver;

import pages.*;
import webdriver.WebDriverFactory;

import java.nio.file.Paths;
import java.time.Duration;

public class MainApp {

    private static WebDriver browser;

    private static final String userLogin = "Admin";

    private static final String userPassword = "admin123";

   private static SignInPage signInPage;

    private static AdminPage adminPage;

    private static PimPage pimPage;

    /* ADMIN Block data for Job Titles */

    private static final String tittle = "New Super Account Assistent";

    private static final String description = "Don't worry, it so easy";

    private static final String note = "it's a terrible job but you'll get experience and maybe money ";

    private static final String fileName = Paths.get("./Книга1.xlsx").toFile().getAbsolutePath();

    private static final String xputTittle = "//*[text()='New Super Account Assistent']";

    /*ADMIN Block data for User Managment*/

    private static final String xputNameEmployee = "//*[text()='Abujabar']";

    private static final String userName  = "Abujabar";
    private static final String userRole = "Admin";
    private static final String employeeNameJob = "First Mid Laster";
    private static final String status = "Enabled";
    private static final String paswrd = "123456789Qz";

    /*PIM Block data for Employee Information*/

    private static final String xputUserName = "//*[text()='First Mid']";

    private static final String firstName  = "First";

    private static final String middleName = "Mid";

    private static final String lastName = "Laster";

    private static final String employeeId = "0500";

private static final String URL =  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public static void main(String[] args) {
        browser  = WebDriverFactory.getWebDriver(URL);
        SignInPage signInPage = new SignInPage(browser);
        SignInPageParametersObg signInPageParametersObg = new SignInPageParametersObg();
        signInPageParametersObg.setUserLogin(userLogin).setUserPassword(userPassword);
        SignInPage.loginToSite(signInPageParametersObg);
        adminPage = new AdminPage(browser);
        JobTittleParameterObj jobTittleParameterObj = new JobTittleParameterObj();
        jobTittleParameterObj.setTitle(tittle).setDescription(description).setNote(note)
                .setFileName(fileName).setXput(xputTittle);
        adminPage.addJobTittle( jobTittleParameterObj);
        pimPage = new PimPage(browser);
        EmployeeParametersObj employeeParametersObj= new EmployeeParametersObj();
        employeeParametersObj.setEmployeeId(employeeId).setFirstName(firstName).setLastName(lastName)
                .setMiddleName(middleName).setXputUserName(xputUserName);
        pimPage.addEmployee(employeeParametersObj);
        adminPage = new AdminPage(browser);
        JobEmployeeParametersObj jobEmployeeParametersObj = new JobEmployeeParametersObj();
        jobEmployeeParametersObj.setUserName(userName).setUserRole(userRole)
                .setEmployeeNameJob(employeeNameJob).setStatus(status).setPaswrd(paswrd)
                        .setXputNameEmployee(xputNameEmployee);


        adminPage.addJobEmployee(jobEmployeeParametersObj);
        WebDriverFactory.quitWebDriver();
    }
}
