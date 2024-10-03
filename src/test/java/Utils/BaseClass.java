package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public CommonMethods commonMethods;

    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://practice.automationtesting.in/my-account/");
        commonMethods = new CommonMethods(driver);

    }

     @AfterMethod
    public void tearDown(){
       if(driver!=null)driver.quit();

    }
}
