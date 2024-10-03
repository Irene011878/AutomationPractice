package Maps;

import org.openqa.selenium.By;

public class OrderMap {

    public By orderLink = By.cssSelector("li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders'] a");
    public By viewOrder1 = By.xpath("//tbody/tr[1]/td[5]/a[1]");
    public By orderStatus = By.xpath("//div[@id='body']//p[1]");







}
