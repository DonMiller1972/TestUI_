import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.FluentWait;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.SignInPage;
import webdriver.WebDriverFactory;

import java.nio.file.Paths;
import java.time.Duration;

import pages.*;


public class finalTestNG {

    private static WebDriver driver;
    private static String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static String login = "Admin";
    private static String password = "admin123";

    private static String tittle = "New Super Account Assistent";
    private static String description = "Don't worry, it so easy";
    private static String note = "it's a terrible job but you'll get experience and maybe money ";
    private static String fileName = Paths.get("./book.pdf").toFile().getAbsolutePath();
    private static String xputTittle = "//*[text()="+"'" + tittle +"'"+"]";

    private static String xputDescription =  "//div[text() ="+"'" + tittle +"'"+"]"+"/../../div[3]/div/span";

    private static String firstName  = "First";

    private static String middleName = "Mid";

    private static String lastName = "Laster";

    private static String employeeId = "0913";

    private static String fistMidl = firstName + " " + middleName;
    private static String xputUserName = "//*[text()="+"'" + fistMidl + "'"+"]";

    private static String userName  = "Abujabar";
    private static String xputNameEmployee = "//*[text()="+"'" + userName + "'"+"]";

   private static String userRole = "Admin";
    private static String employeeNameJob = firstName + " " + lastName;
    private static String status = "Enabled";
    private static String paswrd = "123456789Qz";

    static void randomizer(){


    }

    @BeforeClass
    static void initWebDriver() {
        driver = WebDriverFactory.getWebDriver(URL);
    }


    @Test
    @Description("This is login test")
    @Story("Login")
    @Feature("Login to account")

    public void testLoginToPage() {
        SignInPage signInPage = new SignInPage(driver);
        SignInPageParametersObg signInPageParametersObg = new SignInPageParametersObg();
        signInPageParametersObg.setUserLogin(login).setUserPassword(password);
        SignInPage.loginToSite(signInPageParametersObg);

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", currentURL, "It's a wrong Webpage");
    }

    @Test(dependsOnMethods = "testLoginToPage")
    @Description("This is a New Job's create test")
    @Story("Admin")
    @Feature("Create new job's tittle")
    public void testAddAdminJbTitle() {
        AdminPage adminPage = new AdminPage(driver);
        JobTittleParameterObj jobTittleParameterObj = new JobTittleParameterObj();
        jobTittleParameterObj.setTitle(tittle).setDescription(description).setFileName(fileName)
                .setNote(note).setXput(xputTittle);
        AdminPage.addJobTittle(jobTittleParameterObj);

        WebElement title = driver.findElement(By.xpath(xputTittle));
        WebElement descript = driver.findElement(By.xpath(xputDescription));


        Assert.assertEquals(tittle, title.getText(),tittle + " not found ");
        Assert.assertEquals(description, descript.getText(),tittle + " not found ");
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .until(d -> {
                    driver.findElement(By.xpath(xputTittle)).isEnabled();
                    return true;
                });
        Assert.assertEquals(tittle, driver
                .findElement(By.xpath(xputTittle))
                .getText(), "Record not present");

    }

    @Test(dependsOnMethods = "testAddAdminJbTitle")
    @Description("This is the Employee's create test")
    @Story("PIM")
    @Feature("Create new Employee")
    public void testAddEmployee(){
        long  startTime;
         PimPage pimPage = new PimPage(driver);
         EmployeeParametersObj employeeParametersObj = new EmployeeParametersObj();
         employeeParametersObj.setFirstName(firstName).setMiddleName(middleName)
                 .setLastName(lastName).setEmployeeId(employeeId).setXputUserName(xputUserName);

        PimPage.addEmployee(employeeParametersObj);


         startTime = System.currentTimeMillis();
          while (System.currentTimeMillis() - startTime < 1*1000) {}


        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofSeconds(2))
                .until(driver ->
                        driver.findElement(By.xpath("//div[1]/div[1]/header/div[2]/nav/ul/li[2]")).isDisplayed());

        WebElement employeeListButton = driver
                .findElement(By.xpath("//div[1]/div[1]/header/div[2]/nav/ul/li[2]"));
        employeeListButton.click();

        WebElement id = driver.findElement(By.xpath("//div[text() ="+ "'" + employeeId +"'"+"]"));
        WebElement firstAndMiddleName = driver.findElement(By.xpath("//div[text() ="+ "'" + employeeId +"'"+"]"+"/../../div[3]/div"));
        Assert.assertEquals(employeeId, id.getText(),"Not found");
        //String firstNameMiddleName = firstName + " " + middleName;
        Assert.assertEquals(fistMidl, firstAndMiddleName.getText(),"Not found");
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofMillis(300))
                .until(d -> {
                    driver.findElement(By.xpath("//div[text() ="+ "'" + employeeId +"'"+"]")).isEnabled();
                    return true;
                });
        Assert.assertEquals(employeeId, driver
                .findElement(By.xpath("//div[text() ="+ "'" + employeeId +"'"+"]"))
                .getText(), "Record not present");
    }

    @Test(dependsOnMethods = "testAddEmployee")
    @Description("This is the User's create test")
    @Story("Admin")
    @Feature("Create new User for Employee")
    public void testAddJobEmploye() {
        AdminPage adminPage = new AdminPage(driver);
        JobEmployeeParametersObj jobEmployeeParametersObj = new JobEmployeeParametersObj();
        jobEmployeeParametersObj.setXputNameEmployee(xputNameEmployee).setEmployeeNameJob(employeeNameJob)
                .setUserName(userName).setPaswrd(paswrd).setStatus(status).setUserRole(userRole);

        AdminPage.addJobEmployee(jobEmployeeParametersObj);

        WebElement name = driver.findElement(By.xpath("//div[text() ="+ "'" + userName +"'"+"]"));
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
    public void quitWebDriver(){
        if(driver!=null){
            driver.quit();
        }
   }


}



