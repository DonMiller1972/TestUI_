package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static WebDriver driver;

    private WebDriverFactory(){

    }
    public static WebDriver getWebDriver(String URL){
        if (driver == null){

            initializeWebDriver(URL);
        }
        return driver;
    }

    private static void initializeWebDriver(String URL){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get(URL);
    }


    public static void quitWebDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }



}
