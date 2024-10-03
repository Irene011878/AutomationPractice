package Tests;

import Maps.AddressesMap;
import Maps.DownloadsMap;
import Maps.HomePageMap;
import Pages.AddressesMethods;
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

    @Test
    public void doTheDownload(){

        downloadsMethods= new DownloadsMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

        loginPageMethods.login();
        downloadsMethods.downloadOne();
        String orderSuccessfulMessage = commonMethods.getElementText(downloadsMap.orderMessage);
        Assert.assertEquals(orderSuccessfulMessage, "Thank you. Your order has been received.");

    }
}
