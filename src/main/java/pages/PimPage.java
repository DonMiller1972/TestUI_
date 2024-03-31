package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.security.Key;
import java.time.Duration;

public class PimPage {
    private WebDriver driver;
    @FindBy(xpath = "//ul/li[2]/a")
    private WebElement pimButton;
    @FindBy(xpath = "//div[2]/nav/ul/li[3]/a")
    private WebElement addEmployeeButton;

    @FindBy(xpath = "//div[2]/div[1]/div[2]/input")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/input")
    private WebElement middleNameField;

    @FindBy(xpath = "//div[2]/div[3]/div[2]/input")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[2]/div/div/div[2]/input")
    private WebElement employeeIdField;

    @FindBy(xpath = "//div[2]/div/div/form/div[2]/button[2]")
    private WebElement saveEmployeeButton;

    @FindBy(xpath = "//div[2]/div/div/form/div[2]/button[1]")
    private WebElement cancelEmployeeButton;

    long  startTime;

    public void waitFewSeconds1(int wait){
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < wait*1000) {
            //   System.out.print(startTime - System.currentTimeMillis());
        }

    }

    public PimPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void addEmployee(String firstName, String middleName, String lastName, String employeeId, String xput){
        pimButton.click();
        try {
            System.out.println(xput);
            WebElement userElement = driver.findElement(By.xpath(xput));
            System.out.println("Employee Id :" + employeeId + " is present. Skip ");
        }catch (NoSuchElementException e){
            addEmployeeButton.click();
            firstNameField.sendKeys(firstName);
            middleNameField.sendKeys(middleName);
            lastNameField.sendKeys(lastName);
            for (int i = 0; i < 5; i++) {
                employeeIdField.sendKeys(Keys.BACK_SPACE);
            }
            employeeIdField.sendKeys(employeeId);

            waitFewSeconds1(4);
            saveEmployeeButton.click();
            waitFewSeconds1(4);


        }
        String a = "Record : " + firstName + " " + lastName+ " "+ employeeId +" ";
        AdminPage.recordIsPresent(driver, xput, a+"is present",a +" is not present");



    }

}
