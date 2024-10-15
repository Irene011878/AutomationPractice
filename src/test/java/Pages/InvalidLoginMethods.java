package Pages;

import Maps.LoginPageMap;
import Utils.CommonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class InvalidLoginMethods {

    private static final Logger logger = LogManager.getLogger(InvalidLoginMethods.class);

    CommonMethods commonMethods;
    LoginPageMap loginPageMap = new LoginPageMap();

    public InvalidLoginMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;


    }

    public void invalidLogin(String userEmail, String userPassword) {

        logger.info("Starting invalid login test");

        commonMethods.waitForElementToBePresent(loginPageMap.inputUserName);
        logger.debug("Inputting username: irene.aguilarperez@hotmail.com");
        commonMethods.sendText(loginPageMap.inputUserName, userEmail);

        logger.debug("Inputting password: 1234");
        commonMethods.sendText(loginPageMap.inputPassword, userPassword);

        logger.info("Clicking on the Sign In button");
        commonMethods.clickElement(loginPageMap.SignInBtn);

        logger.info("Invalid login test completed");
    }
}
