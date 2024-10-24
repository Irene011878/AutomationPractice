package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;
import org.apache.logging.log4j.Logger;


public class BaseClass {


    public WebDriver driver;
    public CommonMethods commonMethods;
    public ExtentReports extent;
    public ExtentTest test;


    private static final Logger logger = LogManager.getLogger(BaseClass.class);


    public BaseClass() {
        logger.info("Log4j2 is initialized and the log file should be created.");
    }


    @BeforeClass(groups = {"regression", "smoke"})
    public void setUpClass() {

        extent = ExtentManager.getInstance();

        logger.info("The Extent report has been initialized.");
    }



    @BeforeMethod(groups = {"regression","smoke"})

    public void setUp(Method method){


        logger.info("Configuring the browser for the test: " + method.getName());


        try {

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


            logger.info("The browser was configured correctly.");
        } catch (Exception e) {
            logger.error("Error configuring browser: " + e.getMessage());
        }
    }

     @AfterMethod(groups = {"regression","smoke"})
    public void tearDown(){


       if(driver!=null) {
           logger.info("Closing the Browser.");
           driver.quit();


       }else{
           logger.warn("The browser was already closed or was not initialized.");

       }

    }


    @AfterClass(groups = {"regression", "smoke"})
    public void tearDownClass() {

        extent.flush();

        logger.info("The Extent report has been generated and finalized.");

        }
    }

