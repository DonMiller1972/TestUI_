package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;

    @FindBy(xpath="//input[@name='username']")
    private static  WebElement userIDField;

    @FindBy(xpath="//input[@name='password']")
    private static WebElement passwordField;

    @FindBy(xpath="//button[text()=' Login ']")
    private static WebElement loginButton;

    @FindBy(xpath="//span[text()='Admin']")
    private static WebElement adminButton;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void loginToSite(SignInPageParametersObg signInPageParametersObg){
        userIDField.sendKeys(signInPageParametersObg.getUserLogin());
        passwordField.sendKeys(signInPageParametersObg.getUserPassword());
        loginButton.click();


    }



}
