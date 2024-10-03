package Maps;

import org.openqa.selenium.By;

public class DownloadsMap {

    public By downloadLink = (By.cssSelector("a[href='https://practice.automationtesting.in/my-account/downloads/']"));
    public By goShopDwl = (By.cssSelector(".woocommerce-Button.button"));
    public By seleniumDwl = (By.xpath("//a[contains(text(),'selenium')]"));
    public By addSeToBasket = (By.xpath("//a[contains(text(),'Add to basket')]"));
    public By viewBasket = (By.xpath("(//i[@class='wpmenucart-icon-shopping-cart-0'])[1]"));
    public By proceedToCheckOut = (By.xpath("//a[contains(text(),'Proceed to Checkout')]"));
    public By firstName = By.xpath("//input[@id='billing_first_name']");
    public By lastName= By.xpath("//input[@id='billing_last_name']");
    public By phoneNum = By.xpath("//input[@id='billing_phone']");
    public By streetAddress = By.cssSelector("#billing_address_1");
    public By cityTown = By.xpath("//input[@id='billing_city']");
    public By zipCodeDwl = By.xpath("//input[@id='billing_postcode']");
    public By payOnDeliveryBtn = By.xpath("//input[@id='payment_method_cod']");
    public By placeOrderBtn = By.xpath("//input[@id='place_order']");
    public By orderMessage = By.xpath("//p[contains(text(),'Thank you. Your order has been received.')]");



}
