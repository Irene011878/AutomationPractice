package Tests;

import Maps.HomePageMap;
import Maps.OrderMap;
import Pages.DownloadsMethods;
import Pages.LoginPageMethods;
import Pages.OrderMethods;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseClass {

    HomePageMap homePageMap = new HomePageMap();
    OrderMap orderMap = new OrderMap();
    LoginPageMethods loginPageMethods;
    DownloadsMethods downloadsMethods;
    OrderMethods orderMethods;


    @Test
    public void testTheCart(){
        orderMethods = new OrderMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

       loginPageMethods.login();
       orderMethods.seeOrder();
        String orderMessageStatus = commonMethods.getElementText(orderMap.orderStatus);
        Assert.assertEquals(orderMessageStatus, "Order #26486 was placed on September 27, 2024 and is currently Processing.");


    }
}
