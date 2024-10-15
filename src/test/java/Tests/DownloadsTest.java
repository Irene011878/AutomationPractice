package Tests;

import Maps.AddressesMap;
import Maps.DownloadsMap;
import Maps.HomePageMap;
import Pages.DownloadsMethods;
import Pages.LoginPageMethods;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadsTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();
    AddressesMap addressesMap = new AddressesMap();
    DownloadsMap downloadsMap = new DownloadsMap();
    LoginPageMethods loginPageMethods;
    DownloadsMethods downloadsMethods;


    @Test(groups = {"maintenance"})
    public void doTheDownload() {

        downloadsMethods = new DownloadsMethods(commonMethods);
        loginPageMethods = new LoginPageMethods(commonMethods);

        loginPageMethods.login(" irene.aguilarperez@hotmail.com", "Pipet@4707");
        test.info("User has logged in successfully.");

        downloadsMethods.downloadOne("Irene", "Aguilar", "8441111245", "Indus1265", "Delhi", "25050");
        test.info("File downloaded successfully.");

        String orderSuccessfulMessage = commonMethods.getElementText(downloadsMap.orderMessage);
        test.info("Success message obtained: " + orderSuccessfulMessage);

        try {
            Assert.assertEquals(orderSuccessfulMessage, "Thank you. Your order has been received.");
            test.pass("The orden message is correct: " + orderSuccessfulMessage);
        } catch (AssertionError e) {
            test.fail("Order message validation failed: " + e.getMessage());
            throw e;

        }
    }
}
