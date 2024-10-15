package Tests;

import Maps.HomePageMap;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import Utils.DataProviderClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();

    ExtentTest test;

    @Test(groups = {"regression","test"}, dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
    public void loginValidCredentials(String email, String password ) {

        test = extent.createTest("Login with Valid Credentials");


        try {

        LoginPageMethods loginPageMethods = new LoginPageMethods(commonMethods);
        loginPageMethods.login(email, password);

            test.log(Status.INFO, "Login attempted with valid credentials");

        commonMethods.clickElement(homePageMap.signOutBtn);
        Assert.assertEquals(driver.getCurrentUrl(), "https://practice.automationtesting.in/my-account/");

            test.log(Status.PASS, "Login successful and user redirected to the correct URL.");
        } catch (Exception e) {

            test.log(Status.FAIL, "Login failed: " + e.getMessage());
            Assert.fail("Login test failed: " + e.getMessage());
        }

    }

}
