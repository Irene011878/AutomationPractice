package Pages;

import Maps.LoginPageMap;
import Utils.CommonMethods;

public class InvalidLoginMethods {

    CommonMethods commonMethods;
    LoginPageMap loginPageMap = new LoginPageMap();

    public InvalidLoginMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;


    }

    public void invalidLogin() {

        commonMethods.waitForElementToBePresent(loginPageMap.inputUserName);
        commonMethods.sendText(loginPageMap.inputUserName, "irene.aguilarperez@hotmail.com");
        commonMethods.sendText(loginPageMap.inputPassword, "1234");
        commonMethods.clickElement(loginPageMap.SignInBtn);
    }
}
