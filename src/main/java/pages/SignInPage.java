package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;

    @FindBy(xpath="//form/div[1]/div/div[2]/input")
    private static WebElement userIDField;

    @FindBy(xpath="//form/div[2]/div/div[2]/input")
    private static WebElement passwordField;

    @FindBy(xpath="//form/div[3]/button")
    private static WebElement loginButton;

    @FindBy(xpath="//ul/li[1]/a")
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
