package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseClass {


    public WebDriver driver;
    public CommonMethods commonMethods;
    public ExtentReports extent;
    public ExtentTest test;


    @BeforeClass(groups = {"regression", "smoke"})
    public void setUpClass() {
        // Inicializar el reporte
        extent = ExtentManager.getInstance();
    }



    @BeforeMethod(groups = {"regression","smoke"})
                      //4 oct
    public void setUp(Method method){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--windows-size=1920, 1080");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://practice.automationtesting.in/my-account/");


        test = extent.createTest(method.getName());

        commonMethods = new CommonMethods(driver);
    }

     @AfterMethod(groups = {"regression","smoke"})
    public void tearDown(){
       if(driver!=null)driver.quit();

    }


    @AfterClass(groups = {"regression", "smoke"})
    public void tearDownClass() {
        // Generar el reporte
        extent.flush();


        }
    }

