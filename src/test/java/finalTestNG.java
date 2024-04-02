import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;


public class finalTestNG {

    private static WebDriver driver;
    private static String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static String login = "Admin";
    private static String password = "admin123";

    static void randomizer(){


    }

    @BeforeClass
    static void initWebDriver() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("--download-default-directory=C:\\Users\\DonK\\IdeaProjects\\HomeWorkLesson9");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(URL);
    }


    @Test
    static void loginToPage() {
        WebElement loginField = driver.findElement(By.xpath("//form/div[1]/div/div[2]/input"));
        loginField.sendKeys(login);
        WebElement passwordField = driver.findElement(By.xpath("//form/div[2]/div/div[2]/input"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//form/div[3]/button"));
        loginButton.click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", currentURL, "It's a wrong Webpage");
    }

    @Test(dependsOnMethods = "loginToPage")
    static void addAdminJobTitle() {
        String tittle = "New Super Account Assistent";
        String description = "Don't worry, it so easy";
        String note = "it's a terrible job but you'll get experience and maybe money ";
        String fileName = Paths.get("./Книга1.xlsx").toFile().getAbsolutePath();
        String xputTittle = "//*[text()="+"'New Super Account Assistent'"+"]";

        WebElement adminButton = driver.findElement(By.xpath("//ul/li[1]/a"));
        adminButton.click();
        WebElement jobMenuButton = driver.findElement(By.xpath("//ul/li[2]/span/i"));
        jobMenuButton.click();
        WebElement jobTittlesButton = driver.findElement(By.cssSelector("ul > li.--active.oxd-topbar-body-nav-tab.--parent > ul > li:nth-child(1) > a "));
        jobTittlesButton.click();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[text()='New Super Account Assistent']"));
        if(listOfElements.size()>0){
            WebElement userElement = driver.findElement(By.xpath("//*[text()='New Super Account Assistent']"));
            System.out.println("Job Title :" + tittle + "is present. Skip.");
        }else {
            WebElement addJobTittlesButton = driver.findElement(By.cssSelector(" div > div > div.orangehrm-header-container > div > button"));
            addJobTittlesButton.click();
            WebElement jobTittleInput = driver.findElement(By.xpath("//div[1]/div/div[2]/input"));
            jobTittleInput.sendKeys(tittle);
            WebElement jobDescriptionField = driver.findElement(By.xpath("//div[2]/div/div[2]/textarea"));
            jobDescriptionField.sendKeys(description);
            WebElement jobUpLoadFileField = driver.findElement(By.xpath("//div[3]/div/div[2]/input"));
            jobUpLoadFileField.sendKeys(fileName);
            WebElement jobAddNoteField = driver.findElement(By.xpath("//form/div[4]/div/div[2]/textarea"));
            jobAddNoteField.sendKeys(note);
            WebElement jobSaveButton = driver.findElement(By.xpath("//form/div[5]/button[2]"));
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2)).
                    pollingEvery(Duration.ofMillis(300));
            wait.until(d -> {
                jobSaveButton.click();
                return true;
            });
        }
        WebElement title = driver.findElement(By.xpath("//div[text() ='New Super Account Assistent']"));
        WebElement descript = driver.findElement(By.xpath("//div[text() ='New Super Account Assistent']/../../div[3]/div/span"));
        //div[text() ='New Super Account Assistent']/../../div[3]/div/span
        System.out.println("Title:" + title.getText());
        System.out.println("Desription: " +descript.getText());
        Assert.assertEquals(tittle, title.getText(),tittle + " not found ");
        Assert.assertEquals(description, descript.getText(),tittle + " not found ");
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .until(d -> {
                    driver.findElement(By.xpath("//div[text() ='New Super Account Assistent']")).isEnabled();
                    return true;
                });
        Assert.assertEquals(tittle, driver
                .findElement(By.xpath("//div[text() ='New Super Account Assistent']"))
                .getText(), "Record not present");

    }

    @Test(dependsOnMethods = "loginToPage")
    public void addEmployee(){
         String xputUserName = "//*[text()='First Mid']";

         String firstName  = "First";

         String middleName = "Mid";

         String lastName = "Laster";

         String employeeId = "0913";

         long  startTime;

        WebElement pimButton = driver.findElement(By.xpath("//ul/li[2]/a"));
        pimButton.click();
        List<WebElement> listOfElements = driver
                .findElements(By.xpath("//*[text()='0913']"));

        if(listOfElements.size()>0){
            WebElement userElement = driver.findElement(By.xpath("//*[text()='0913']"));
            System.out.println("Employee Id :" + employeeId + " is present. Skip ");
        }else {
            WebElement addEmployeeButton = driver.findElement(By.xpath("//div[2]/nav/ul/li[3]/a"));
            addEmployeeButton.click();
            WebElement firstNameField = driver.findElement(By.xpath("//div[2]/div[1]/div[2]/input"));
            firstNameField.sendKeys(firstName);
            WebElement middleNameField = driver.findElement(By.xpath("//div[2]/div[2]/div[2]/input"));
            middleNameField.sendKeys(middleName);
            WebElement lastNameField = driver.findElement(By.xpath("//div[2]/div[3]/div[2]/input"));
            lastNameField.sendKeys(lastName);
            WebElement employeeIdField = driver.findElement(By.xpath("//div[2]/div/div/div[2]/input"));
            employeeIdField.sendKeys(Keys.CONTROL + "a");
            employeeIdField.sendKeys(Keys.DELETE);
            employeeIdField.sendKeys(employeeId);
            WebElement saveEmployeeButton = driver
                    .findElement(By.xpath("//div[2]/div/div/form/div[2]/button[2]"));
            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).
                    pollingEvery(Duration.ofMillis(300));
            wait.until(l -> {
                saveEmployeeButton.click();
                return true;
            });

          startTime = System.currentTimeMillis();
          while (System.currentTimeMillis() - startTime < 1*1000) {}
        }

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofSeconds(2))
                .until(driver ->
                        driver.findElement(By.xpath("//div[1]/div[1]/header/div[2]/nav/ul/li[2]")).isDisplayed());

        WebElement employeeListButton = driver
                .findElement(By.xpath("//div[1]/div[1]/header/div[2]/nav/ul/li[2]"));
        employeeListButton.click();

        WebElement id = driver.findElement(By.xpath("//div[text() ='0913']"));
        WebElement firstAndMiddleName = driver.findElement(By.xpath("//div[text() ='0913']/../../div[3]/div"));
        Assert.assertEquals(employeeId, id.getText(),"Not found");
        String firstNameMiddleName = firstName + " " + middleName;
        Assert.assertEquals(firstNameMiddleName, firstAndMiddleName.getText(),"Not found");
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofMillis(300))
                .until(d -> {
                    driver.findElement(By.xpath("//div[text() ='0913']")).isEnabled();
                    return true;
                });
        Assert.assertEquals(employeeId, driver
                .findElement(By.xpath("//div[text() ='0913']"))
                .getText(), "Record not present");
    }

    @Test(dependsOnMethods = "addEmployee")
    public void addJobEmployee() {
        String xputNameEmployee = "//*[text()='Abujabar']";

        String userName  = "Abujabar";
        String userRole = "Admin";
        String employeeNameJob = "First Laster";
        String status = "Enabled";
        String paswrd = "123456789Qz";
        long startTime;

        WebElement adminButton = driver.findElement(By.xpath("//ul/li[1]/a"));
        adminButton.click();
        WebElement adminMenuButton = driver.findElement(By.xpath("//nav/ul/li[1]/span"));
        adminMenuButton.click();
        WebElement usersButton = driver.findElement(By.xpath("//li[1]/ul/li/a"));
        usersButton.click();
        List<WebElement> listOfElements = driver
                .findElements(By.xpath("//*[text()='Abujabar']"));
        if(listOfElements.size()>0){
            WebElement userElement = driver.findElement(By.xpath("//*[text()='Abujabar']"));
            System.out.println("Employee Id :" + userElement.getText() + " is present. Skip ");
        }else {
            WebElement addUsersSystemButton = driver.findElement(By
                    .xpath("//div[2]/div/div[2]/div[1]/button"));
            addUsersSystemButton.click();
            WebElement userRoleField = driver.findElement(By
                    .xpath("//div[1]/div/div[1]/div/div[2]/div/div/div[1]"));
            userRoleField.click();

            WebElement adminRole = driver.findElement(By
                    .xpath("//div[2]/div/div[2]/div[2]"));
                adminRole.click();
            WebElement statusUserField = driver.findElement(By
                    .xpath("//div/div[3]/div/div[2]/div/div/div[1]"));
            statusUserField.click();
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 1*1000) {}

            WebElement statusEnabled = driver.findElement(By
                    .xpath("//div[2]/div/div[2]/div[2]"));
            statusEnabled.click();
            WebElement employeeNameField = driver.findElement(By
                    .xpath("//div[2]/div/div[2]/div/div/input"));
            employeeNameField.sendKeys("First Laster");

            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 2*1000) {}

            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(5000))
                    .until(driver ->
                            driver.findElement(By.xpath("//div[2]/div/div[2]/div/div[2]/div[1]")).isDisplayed());
            WebElement employeeNameFirst = driver.findElement(By
                    .xpath("//div[2]/div/div[2]/div/div[2]/div[1]"));

            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).
                    pollingEvery(Duration.ofMillis(1000));
            wait.until(l -> {
                employeeNameFirst.click();
                return true;
            });

            WebElement userNameField = driver.findElement(By
                    .xpath("//div[4]/div/div[2]/input"));
            userNameField.sendKeys( "Abujabar");
            WebElement passwordField = driver.findElement(By
                    .xpath("//div[1]/div/div[2]/input"));
            passwordField.sendKeys(paswrd);
            WebElement confirmPasswordField = driver.findElement(By
                    .xpath("//div[2]/div/div[2]/input"));
            confirmPasswordField.sendKeys(paswrd);
            WebElement saveButtonAddForm = driver.findElement(By
                    .xpath("//div[3]/button[2]"));
            saveButtonAddForm.click();

        }

        WebElement name = driver.findElement(By.xpath("//div[text() ='Abujabar']"));
        WebElement useRoleB = driver.findElement(By
                .xpath("//div[text() ='Abujabar']/../../div[3]/div"));
        WebElement employeeNameB = driver.findElement(By
                .xpath("//div[text() ='Abujabar']/../../div[4]/div"));
        WebElement statusJobB = driver.findElement(By
                .xpath("//div[text() ='Abujabar']/../../div[5]/div"));
        System.out.println("Name:" + name.getText() + " role: " + useRoleB.getText()+" employee name: "+ employeeNameB.getText()+" status job: " +statusJobB.getText());
        Assert.assertEquals(userName,name.getText(), "\"Record not present\"");
        Assert.assertEquals(userRole,useRoleB.getText(), "\"Record not present\"");
        Assert.assertEquals(employeeNameJob,employeeNameB.getText(), "\"Record not present\"");
        Assert.assertEquals(status,statusJobB.getText(), "\"Record not present\"");

        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(2000))
                .until(d -> {
                    driver.findElement(By.xpath("//div[text() ='Abujabar']")).isEnabled();
                    return true;
                });
        Assert.assertEquals(userName, driver
                .findElement(By.xpath("//div[text() ='Abujabar']"))
                .getText(), "Record not present");


    }

    @AfterClass
    public static void quitWebDriver(){
        if(driver!=null){
            driver.quit();
        }
   }


}



