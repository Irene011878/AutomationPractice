package Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageMap {

    public By inputUserName = (By.xpath("//input[@id='username']"));

    public By inputPassword = By.xpath("//input[@id='password']");

    public By SignInBtn = By.xpath("//input[@name='login']");

    public By invalidCredentialMessage = By.cssSelector("ul[class='woocommerce-error'] li");
}
