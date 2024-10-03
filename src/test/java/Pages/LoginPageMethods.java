package Pages;

import Maps.LoginPageMap;
import Utils.CommonMethods;

public class LoginPageMethods {

    CommonMethods commonMethods;
    LoginPageMap loginPageMap = new LoginPageMap();

    public LoginPageMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void login() {

        commonMethods.waitForElementToBePresent(loginPageMap.inputUserName);
        commonMethods.sendText(loginPageMap.inputUserName, "irene.aguilarperez@hotmail.com");
        commonMethods.sendText(loginPageMap.inputPassword, "Pipet@4707");
        commonMethods.clickElement(loginPageMap.SignInBtn);

    }
}
