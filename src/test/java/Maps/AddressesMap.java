package Maps;

import org.openqa.selenium.By;

public class AddressesMap {


    public By addressesBtn = By.cssSelector("li[class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address'] a");
    public By editBillingAddressBtn = By.xpath("//a[@href='https://practice.automationtesting.in/my-account/edit-address/billing']");
    public By firstNameBox = By.xpath("//input[@id='billing_first_name']");
    public By lastNameBox = By.xpath("//input[@id='billing_last_name']");
    public By phoneBox = By.xpath("//input[@id='billing_phone']");
    //public  By countrySelection = (By.xpath("//input[@id='s2id_autogen1_search']"));
    public  By streetAddress = (By.cssSelector("#billing_address_1"));
    public By billingCity = (By.cssSelector("#billing_city"));
    public By stateCountry = (By.xpath("//div[@id='select2-drop-mask']"));
    public By saveAddress = (By.xpath("//input[@name='save_address']"));
    public By errorMessage= (By.xpath("//div[contains(text(),'Address changed successfully.')]"));
}
