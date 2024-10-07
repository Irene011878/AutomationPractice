package Tests;

import Maps.HomePageMap;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();

    ExtentTest test;

    @Test(groups = {"smoke"})

    public void loginValidCredentials() {

        test = extent.createTest("Login with Valid Credentials");


        try {

        LoginPageMethods loginPageMethods = new LoginPageMethods(commonMethods);
        loginPageMethods.login();

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
