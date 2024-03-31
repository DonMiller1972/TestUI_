package org.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AdminPage;
import pages.PimPage;
import pages.SignInPage;
import webdriver.WebDriverFactory;

import java.time.Duration;

public class MainApp {

    private static WebDriver browser;

    private static String userLogin = "Admin";

    private static String userPassword = "admin123";

   private static SignInPage signInPage;

    private static AdminPage adminPage;

    private static PimPage pimPage;

    /* ADMIN Block data for Job Titles */

    private static String tittle = "New Super Account Assistent";

    private static String description = "Don't worry, it so easy";

    private static String note = "it's a terrible job but you'll get experience and maybe money ";

    private static String fileName = "C:\\Users\\DonK\\IdeaProjects\\HomeWorkLesson9\\futures.pdf";

    private static String xputTittle = "//*[text()='New Super Account Assistent']";

    /*ADMIN Block data for User Managment*/

    private static String xputNameEmployee = "//*[text()='Abujabar']";

    private static String userName  = "Abujabar";
    private static String userRole = "Admin";
    private static String employeeNameJob = "First Mid Laster";
    private static String status = "Enabled";
    private static String paswrd = "123456789Qz";





    /*PIM Block data for Employee Information*/

    private static String xputUserName = "//*[text()='First Mid']";

    private static String firstName  = "First";

    private static String middleName = "Mid";

    private static String lastName = "Laster";

    private static String employeeId = "0500";



    public void main(String[] args) {
        browser  = WebDriverFactory.getWebDriver();
        signInPage = new SignInPage(browser);
        signInPage.loginToSite(userLogin, userPassword);
        adminPage = new AdminPage(browser);
        adminPage.addJobTittle(tittle, description,note, fileName, xputTittle);
        pimPage = new PimPage(browser);
        pimPage.addEmployee(firstName, middleName, lastName, employeeId, xputUserName);
        adminPage = new AdminPage(browser);
        adminPage.addJobEmployee(userName, userRole, employeeNameJob, status, paswrd, xputNameEmployee);
        WebDriverFactory.quitWebDriver();
    }
}
