package Tests;

import Maps.AddressesMap;
import Maps.HomePageMap;
import Pages.AddressesMethods;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();
    AddressesMap addressesMap = new AddressesMap();
    LoginPageMethods loginPageMethods;
    AddressesMethods addressesMethods;


    public ExtentTest test;

    @Test(groups = {"regression","smoke"})
    public void testAddressInfo(){


        test = extent.createTest("Test Address Info");

        addressesMethods= new AddressesMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

        loginPageMethods.login();
        test.info("User has logged in.");

        addressesMethods.editAddress();
        test.info("Address has been edited.");

        String missingDataErrorMessage = commonMethods.getElementText(addressesMap.errorMessage);
        test.info("Error Message obtained: " + missingDataErrorMessage);

        Assert.assertEquals(missingDataErrorMessage, "Address changed successfully.");
        test.pass("The success message is correct: " + missingDataErrorMessage);


    }
}
