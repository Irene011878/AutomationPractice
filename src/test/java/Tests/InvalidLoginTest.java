package Tests;

import Maps.HomePageMap;
import Maps.LoginPageMap;
import Pages.InvalidLoginMethods;
import Utils.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;



public class InvalidLoginTest extends BaseClass {


    HomePageMap homePageMap = new HomePageMap();
    LoginPageMap loginPageMap = new LoginPageMap();
    ExtentTest test;

    @Test(groups = {"smoke"})
    public void invalidCredentials (){
        test = extent.createTest("Invalid Login Test");

    try{
        InvalidLoginMethods invalidLoginMethods = new InvalidLoginMethods(commonMethods);
        invalidLoginMethods.invalidLogin();

        test.log(Status.INFO, "Attempting to log in with invalid credentials.");

        String unsuccesfullLogin = commonMethods.getElementText(loginPageMap.invalidCredentialMessage);
        Assert.assertEquals(unsuccesfullLogin, "Error: The password you entered for the username irene.aguilarperez@hotmail.com is incorrect. Lost your password?");

        test.log(Status.PASS, "Invalid login attempt resulted in the expected error message.");

    } catch (AssertionError ae) {

        test.log(Status.FAIL, "Login failed: " + ae.getMessage());
        throw ae;
    } catch (Exception e) {

        test.log(Status.FAIL, "An unexpected error occurred: " + e.getMessage());
        throw e;
    }
    }
}
