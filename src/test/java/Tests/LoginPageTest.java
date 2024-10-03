package Tests;

import Maps.HomePageMap;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();

    @Test

    public void loginValidCredentials() {

        LoginPageMethods loginPageMethods = new LoginPageMethods(commonMethods);
        loginPageMethods.login();

        commonMethods.clickElement(homePageMap.signOutBtn);
        Assert.assertEquals(driver.getCurrentUrl(), "https://practice.automationtesting.in/my-account/");

    }



}
