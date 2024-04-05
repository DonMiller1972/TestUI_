package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import webdriver.WebDriverFactory;

import java.lang.System.*;
import java.lang.System.*;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminPage {
    private static WebDriver driver;

    @FindBy(xpath="//span[text()='Admin']")
    private static WebElement adminButton;

    @FindBy(xpath = "//span[text()='User Management ']")
    private static WebElement adminUserMngmtButton;

    @FindBy(xpath = "//ul/li/a[text()='Users']")
    private static WebElement usersButton;

    @FindBy(xpath = "//button[text()=' Add ']")
    private static WebElement addUsersSystemButton;

    @FindBy(xpath = "//span[text()='Job ']")
    private static WebElement jobMenuButton;

    @FindBy(xpath ="//a[text()='Job Titles']" )
    private static WebElement jobTittlesButton;


    @FindBy(xpath = "//button[text()=' Add ']")
    private static WebElement addJobTittlesButton;

    @FindBy(xpath = " //div[2]/input[@class='oxd-input oxd-input--active']")
    private static WebElement jobTittleInput;

    @FindBy(xpath = "//div[2]/div/div[2]/textarea")
    private static WebElement jobDescriptionField;
    @FindBy(xpath = "//input[@type='file']")
    private static WebElement jobUpLoadFileField;

    @FindBy(xpath = "//div[text()='No file chosen']")
    private static WebElement jobFieldUpLoadFile;

    @FindBy(xpath = "//form/div[4]/div/div[2]/textarea")
    private static WebElement jobAddNoteField;

    @FindBy(xpath = "//button[text()=' Save ']")
    private static  WebElement jobSaveButton;



    //JobTittle control
    @FindBy(xpath = "//div[16]/div/div[2]/div")
    private static WebElement jobTittleControle;

    @FindBy(xpath = "//div/div[2]/div[16]/div/div[3]/div")
    private static WebElement jobDescriptionControle;

    //UserRole
    @FindBy(xpath = "//div[1]/div/div[1]/div/div[2]/div/div/div[1]")
    private static WebElement userRoleField;
    @FindBy(xpath = "//div[2]/div/div[2]/div[2]")
    private static WebElement adminRole;

    @FindBy(xpath = "//div[2]/div/div[2]/div[3]")
    private static WebElement essRole;

    //Status user
    @FindBy(xpath = "//div/div[3]/div/div[2]/div/div/div[1]")
    private static WebElement statusUserField;

    @FindBy(xpath = "//div[2]/div/div[2]/div[2]")
    private static WebElement statusEnabled;

    @FindBy(xpath = "//div[2]/div/div[2]/div[3]")
    private static WebElement statusDisabled;

    @FindBy(xpath = "//div[2]/div/div[2]/div/div/input")
    private static WebElement employeeNameField;

    @FindBy(xpath = "//div[2]/div/div[2]/div/div[2]/div[1]")
    private static WebElement employeeNameFirst;
    private static String employeeNameFirstS = "//div[2]/div/div[2]/div/div[2]/div[1]";

    @FindBy(xpath ="//div[4]/div/div[2]/input")
    private static WebElement userNameField;

    @FindBy(xpath ="//div[1]/div/div[2]/input")
    private static WebElement passwordField;

    @FindBy(xpath ="//div[2]/div/div[2]/input")
    private static WebElement confirmPasswordField;

    @FindBy(xpath ="//div[3]/button[2]")
    private static WebElement saveButtonAddForm;

   // @FindBy(xpath = "//*[text()='Abujabar']")
   // private static WebElement nameEmployee;

    @FindBy(xpath = "//*[text()='First Mid']")
    private static WebElement userName;
    long  startTime;
    private static String JobTitleSerch= "//*[text()='New Super Account Assistent']";

    private static String nameEmployee = "//*[text()='Abujabar']";
    public void waitFewSeconds(int wait){
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < wait*1000) {
            //   System.out.print(startTime - System.currentTimeMillis());*/
        }

    }
    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void recordIsPresent(WebDriver driver, String field1, String field2, String field3 ){

        try{

            WebElement userElement = driver.findElement(By.xpath(field1));
            System.out.println(field2);
        }catch (NoSuchElementException e) {
            System.out.println(field3);
        }
        }


    public void clickMenuButton(WebElement menu, WebElement subMenu){
        menu.click();
        subMenu.click();
    }

    public static void addJobTittle(JobTittleParameterObj jobTittleParameterObj){

        adminButton.click();

        jobMenuButton.click();

        jobTittlesButton.click();

        List<WebElement> listOfElements = driver.findElements(By.xpath(JobTitleSerch));
        if(listOfElements.size()>0){
            WebElement userElement = driver.findElement(By.xpath(JobTitleSerch));
            System.out.println("Job Title :" + jobTittleParameterObj.getTitle() + "is present. Skip.");
        }else {

            addJobTittlesButton.click();

            jobTittleInput.sendKeys(jobTittleParameterObj.getTitle());

            jobDescriptionField.sendKeys(jobTittleParameterObj.getDescription());

            jobUpLoadFileField.sendKeys(jobTittleParameterObj.getFileName());

            jobAddNoteField.sendKeys(jobTittleParameterObj.getNote());
            WebElement jobSaveButton = driver.findElement(By.xpath("//form/div[5]/button[2]"));
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2)).
                    pollingEvery(Duration.ofMillis(300));
            wait.until(d -> {
                jobSaveButton.click();
                return true;
            });
        }
    }

    public static void addJobEmployee(JobEmployeeParametersObj jobEmployeeParametersObj) {
        long startTime;

        adminButton.click();

        adminUserMngmtButton.click();

        usersButton.click();
        List<WebElement> listOfElements = driver
                .findElements(By.xpath(nameEmployee));
        if(listOfElements.size()>0){
            WebElement userElement = driver.findElement(By.xpath(nameEmployee));
            System.out.println("Employee Id :" + userElement.getText() + " is present. Skip ");
        }else {
            addUsersSystemButton.click();

            userRoleField.click();
            if(jobEmployeeParametersObj.getUserRole().equals("Admin")){
                adminRole.click();
            }else{
                essRole.click();
            }

            statusUserField.click();
            if(jobEmployeeParametersObj.getStatus().equals("Enabled")) {
                statusEnabled.click();
            }else{
                statusDisabled.click();
            }
            //startTime = System.currentTimeMillis();
            //while (System.currentTimeMillis() - startTime < 1*1000) {}

            employeeNameField.sendKeys(jobEmployeeParametersObj.getEmployeeNameJob());

            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 2*1000) {}

            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(1000))
                    .until(driver ->
                            driver.findElement(By.xpath(employeeNameFirstS)).isDisplayed());

            Wait<WebDriver> wait =
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).
                    pollingEvery(Duration.ofMillis(1000));
            wait.until(l -> {
                employeeNameFirst.click();
                return true;
            });

            userNameField.sendKeys(jobEmployeeParametersObj.getUserName());
            passwordField.sendKeys(jobEmployeeParametersObj.getPaswrd());
            confirmPasswordField.sendKeys(jobEmployeeParametersObj.getPaswrd());
            saveButtonAddForm.click();

        }










    }
}
