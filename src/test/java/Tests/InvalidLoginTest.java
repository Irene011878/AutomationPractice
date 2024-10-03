package Tests;

import Maps.AddressesMap;
import Maps.HomePageMap;
import Maps.LoginPageMap;
import Pages.InvalidLoginMethods;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();
    LoginPageMap loginPageMap = new LoginPageMap();

    @Test
    public void invalidCredentials (){

        InvalidLoginMethods invalidLoginMethods = new InvalidLoginMethods(commonMethods);
        invalidLoginMethods.invalidLogin();

        String unsuccesfullLogin = commonMethods.getElementText(loginPageMap.invalidCredentialMessage);
        Assert.assertEquals(unsuccesfullLogin, "Error: The password you entered for the username irene.aguilarperez@hotmail.com is incorrect. Lost your password?");
    }
}
