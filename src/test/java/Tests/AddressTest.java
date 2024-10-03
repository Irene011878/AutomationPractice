package Tests;

import Maps.AddressesMap;
import Maps.HomePageMap;
import Pages.AddressesMethods;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();
    AddressesMap addressesMap = new AddressesMap();
    LoginPageMethods loginPageMethods;
    AddressesMethods addressesMethods;

    @Test
    public void testAddressInfo(){

        addressesMethods= new AddressesMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

        loginPageMethods.login();
        addressesMethods.editAddress();
        String missingDataErrorMessage = commonMethods.getElementText(addressesMap.errorMessage);
        Assert.assertEquals(missingDataErrorMessage, "Address changed successfully.");


    }
}
