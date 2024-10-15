package Tests;

import Maps.AddressesMap;
import Maps.HomePageMap;
import Pages.AddressesMethods;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import Utils.DataProviderClass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();
    AddressesMap addressesMap = new AddressesMap();
    LoginPageMethods loginPageMethods;
    AddressesMethods addressesMethods;


    public ExtentTest test;

    @Test(groups = {"regression", "smoke"}, dataProvider = "addressData", dataProviderClass = DataProviderClass.class)
    public void testAddressInfo(String firstName, String lastName, String phone, String address, String city){


        test = extent.createTest("Test Address Info");

        addressesMethods= new AddressesMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

        loginPageMethods.login("irene.aguilarperez@hotmail.com", "Pipet@4707");
        test.info("User has logged in.");

        addressesMethods.editAddress(firstName,  lastName, phone, address, city);
        test.info("Address has been edited.");

        String missingDataErrorMessage = commonMethods.getElementText(addressesMap.errorMessage);
        test.info("Error Message obtained: " + missingDataErrorMessage);

        Assert.assertEquals(missingDataErrorMessage, "Address changed successfully.");
        test.pass("The success message is correct: " + missingDataErrorMessage);


    }

    @Test(groups = {"regression", "smoke"}, dataProvider = "addressInvalidPhoneData", dataProviderClass = DataProviderClass.class)
    public void testInvalidPhoneInAddressInfo(String firstName, String lastName, String phone, String address, String city){


        test = extent.createTest("Test Invalid Address Info");

        addressesMethods= new AddressesMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

        loginPageMethods.login(" irene.aguilarperez@hotmail.com", "Pipet@4707");
        test.info("User has logged in.");

        addressesMethods.editAddress(firstName, lastName, phone, address, city);
        test.info("Address has been edited.");

        String invalidPhoneMessage = commonMethods.getElementText(addressesMap.invalidphonemessage);
        test.info("Error Message obtained: " + invalidPhoneMessage);

        Assert.assertEquals(invalidPhoneMessage, "Phone");
        test.pass("The success message is correct: " + invalidPhoneMessage);

    }
}
