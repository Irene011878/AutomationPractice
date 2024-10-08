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


    @Test(groups = {"regression","smoke"}, enabled = false)
    public void testTheCart(){

        test = extent.createTest("Order Test - Cart verification");

        orderMethods = new OrderMethods(commonMethods);
        loginPageMethods= new LoginPageMethods(commonMethods);

       loginPageMethods.login();
        test.info("User has logged in successfully.");

       orderMethods.seeOrder();
        test.info("Viewing the order placed.");

        String orderMessageStatus = commonMethods.getElementText(orderMap.orderStatus);
        test.info("Obtained Order Status Message: " + orderMessageStatus);

    try{
        Assert.assertEquals(orderMessageStatus, "Order #26554 was placed on October 7, 2024 and is currently Processing.");
        test.pass("Order Status is correct: " + orderMessageStatus);
    } catch (AssertionError e) {
        test.fail("Order Status Validation Error: " + e.getMessage());
        throw e;
    }
    }

    }

