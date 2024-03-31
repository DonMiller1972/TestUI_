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

import java.time.Duration;

public class AdminPage {
    private WebDriver driver;

    @FindBy(xpath="//ul/li[1]/a")
    private static WebElement adminButton;


    @FindBy(xpath = "//nav/ul/li[1]/span")
    private WebElement adminMenuButton;

    @FindBy(xpath = "//li[1]/ul/li/a")
    private WebElement usersButton;

    @FindBy(xpath = "//div[2]/div/div[2]/div[1]/button")
    private WebElement addUsersSystemButton;

    @FindBy(xpath = "//ul/li[2]/span/i")
    private WebElement jobMenuButton;

    @FindBy(css = "ul > li.--active.oxd-topbar-body-nav-tab.--parent > ul > li:nth-child(1) > a ")
    private WebElement jobTittlesButton;

    @FindBy(css = " div > div > div.orangehrm-header-container > div > button")
    private WebElement addJobTittlesButton;

    @FindBy(xpath = "//div[1]/div/div[2]/input")
    private WebElement jobTittleInput;

    @FindBy(xpath = "//div[2]/div/div[2]/textarea")
    private WebElement jobDescriptionField;

    //@FindBy(xpath = "//form/div[3]/div/div/div[2]/div/div[2]")
    //@FindBy(xpath = "//div[@class = \"oxd-file-input-div\"]")
    @FindBy(xpath = "//div[3]/div/div[2]/input")
    private WebElement jobUpLoadFileField;

    @FindBy(xpath = "//form/div[3]/div/div[2]/div/div[2]")
    private WebElement jobFieldUpLoadFile;

    @FindBy(xpath = "//form/div[4]/div/div[2]/textarea")
    private WebElement jobAddNoteField;

    @FindBy(xpath = "//form/div[5]/button[2]")
    private WebElement jobSaveButton;

    @FindBy(xpath = "//div[1]/div/div[1]/div/div[2]/div/div/div[1]")
    private WebElement userRoleField;

    //JobTittle control
    @FindBy(xpath = "//div[16]/div/div[2]/div")
    private WebElement jobTittleControle;

    @FindBy(xpath = "//div/div[2]/div[16]/div/div[3]/div")
    private WebElement jobDescriptionControle;

    //UserRole

    @FindBy(xpath = "//div[2]/div/div[2]/div[2]")
    private WebElement adminRole;

    @FindBy(xpath = "//div[2]/div/div[2]/div[3]")
    private WebElement essRole;

    //Status user
    @FindBy(xpath = "//div/div[3]/div/div[2]/div/div/div[1]")
    private WebElement statusUserField;

    @FindBy(xpath = "//div[2]/div/div[2]/div[2]")
    private WebElement statusEnabled;

    @FindBy(xpath = "//div[2]/div/div[2]/div[3]")
    private WebElement statusDisabled;

    @FindBy(xpath = "//div[2]/div/div[2]/div/div/input")
    private WebElement employeeNameField;

    @FindBy(xpath = "//div[2]/div/div[2]/div/div[2]/div[1]")
    private WebElement employeeNameFirst;

    @FindBy(xpath ="//div[4]/div/div[2]/input")
    private WebElement userNameField;

    @FindBy(xpath ="//div[1]/div/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath ="//div[2]/div/div[2]/input")
    private WebElement confirmPasswordField;

    @FindBy(xpath ="//div[3]/button[2]")
    private WebElement saveButtonAddForm;

    @FindBy(xpath = "//*[text()[contains(.,'Abujabar')]]")
    private WebElement nameEmployee;

    @FindBy(xpath = "//*[text()[contains(.,'First Mid')]]")
    private WebElement userName;
    long  startTime;

    public void waitFewSeconds(int wait){
        startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < wait*1000) {
            //   System.out.print(startTime - System.currentTimeMillis());
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

    public void addJobTittle(String title, String description, String note, String fileName, String xput){
        adminButton.click();
        clickMenuButton(jobMenuButton, jobTittlesButton);

        try {
            WebElement userElement = driver.findElement(By.xpath(xput));
            System.out.println("Job Title :" + title + "is present. Skip.");
        } catch (NoSuchElementException e) {
            addJobTittlesButton.click();
            jobTittleInput.sendKeys(title);
            System.out.println("Length of Tittle equal " + title.length() + ", max length - 100 simbols and can't be empty");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            jobDescriptionField.sendKeys(description);
            System.out.println("Length of description equal " + description.length() + ", max length - 400 simbols");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            jobUpLoadFileField.sendKeys(fileName);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            jobAddNoteField.sendKeys(note);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Length of note equal " + note.length() + ", max length - 400 simbols");
            Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(2)).
                    pollingEvery(Duration.ofMillis(300));
            wait.until(d->{ jobSaveButton.click(); return true ;});

        }
        recordIsPresent(driver, xput, "Record : New Super Account Assistent is present","Record : New Super Account Assistent is not present");



    }

    public void addJobEmployee(String userName, String userRole,
                               String employeeNameJob, String status, String paswrd, String xputUserName) {
        adminButton.click();
        clickMenuButton(adminMenuButton, usersButton);
        waitFewSeconds(5);
        try {
            WebElement userElement = driver.findElement(By.xpath(xputUserName));
            System.out.println("Пользователь с userName 'Abujabar' существует. Skip.");
        } catch (NoSuchElementException e) {
            addUsersSystemButton.click();
            userRoleField.click();
            if (userRole.equals("Admin")){
                adminRole.click();
            }else{
                essRole.click();
            }
            statusUserField.click();
            if (status.equals("Enabled")) {
                statusEnabled.click();
            }else{
                statusDisabled.click();
            }
            employeeNameField.sendKeys(employeeNameJob);
            waitFewSeconds(3);
            employeeNameFirst.click();
            waitFewSeconds(3);
            userNameField.sendKeys(userName);
            waitFewSeconds(3);
            passwordField.sendKeys(paswrd);
            confirmPasswordField.sendKeys(paswrd);
            waitFewSeconds(3);
            saveButtonAddForm.click();
            waitFewSeconds(5);
        }
        String a = "Record : " + userName + " " + employeeNameJob+ " "+ status +" ";
        recordIsPresent(driver, xputUserName, a+ " is present",a+ " is not present");






    }
}
