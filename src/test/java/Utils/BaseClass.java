package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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


    // @BeforeClass: Se ejecuta una vez antes de cualquier método de prueba
    @BeforeClass(groups = {"regression", "smoke"})
    public void setUpClass() {
        // Inicializar el reporte
        extent = ExtentManager.getInstance();
    }



    @BeforeMethod(groups = {"regression","smoke"})
                      //4 oct
    public void setUp(Method method){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://practice.automationtesting.in/my-account/");
        //4 oct
        //commonMethods = new CommonMethods(driver);

        // 4 oct Crear un nuevo ExtentTest para cada test basado en el nombre del método
        test = extent.createTest(method.getName());

        // 4 oct
        commonMethods = new CommonMethods(driver);
    }

     @AfterMethod(groups = {"regression","smoke"})
    public void tearDown(){
       if(driver!=null)driver.quit();

    }

    // @AfterClass: Se ejecuta una vez después de todas las pruebas
    @AfterClass(groups = {"regression", "smoke"})
    public void tearDownClass() {
        // Generar el reporte
        extent.flush();


        }
    }

