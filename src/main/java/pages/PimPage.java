package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class PimPage {
    static private  WebDriver driver;
    @FindBy(xpath = "//span[text()='PIM'] ")
    static private WebElement pimButton;
    @FindBy(xpath = "//button[text()=\" Add \"] ")
    static private WebElement addEmployeeButton;

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    static private WebElement firstNameField;

    @FindBy(xpath = "//input[@name=\"middleName\"]")
    static private WebElement middleNameField;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    static private WebElement lastNameField;

    @FindBy(xpath = "//label[text()='Employee Id']/../..//div/input")
    static private WebElement employeeIdField;

    @FindBy(xpath = "//button[text()=\" Save \"]")
    static private WebElement saveEmployeeButton;

    @FindBy(xpath = "//button[text()=\" Cancel \"]")
    static private WebElement cancelEmployeeButton;

    long  startTime;

    public void waitFewSeconds1(int wait){
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < wait*1000) { }

    }

    public PimPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public static void addEmployee(EmployeeParametersObj employeeParametersObj) {

        String xputUserName = "//*[text()='First Mid']";
        String firstName = "First";
        String middleName = "Mid";
        String lastName = "Laster";
        String employeeId = "0913";

        long startTime;

        pimButton.click();

        List<WebElement> listOfElements = driver
                .findElements(By.xpath(employeeParametersObj.getXputUserName()));

        if (listOfElements.size() > 0) {
            WebElement userElement = driver.findElement(By.xpath(employeeParametersObj.getXputUserName()));
            System.out.println("Employee Id :" + employeeParametersObj.getEmployeeId() + " is present. Skip ");
        } else {
            addEmployeeButton.click();
            firstNameField.sendKeys(employeeParametersObj.getFirstName());
            middleNameField.sendKeys(employeeParametersObj.getMiddleName());
            lastNameField.sendKeys(employeeParametersObj.getLastName());
            employeeIdField.sendKeys(Keys.CONTROL + "a");
            employeeIdField.sendKeys(Keys.DELETE);

            employeeIdField.sendKeys(employeeParametersObj.getEmployeeId());
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).
                    pollingEvery(Duration.ofMillis(300));
            wait.until(l -> {
                saveEmployeeButton.click();
                return true;
            });


        }

    }
}
