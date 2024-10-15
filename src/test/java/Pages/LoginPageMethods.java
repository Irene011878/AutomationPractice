package Pages;

import Maps.LoginPageMap;
import Utils.CommonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageMethods {

    CommonMethods commonMethods;
    LoginPageMap loginPageMap = new LoginPageMap();

    private static final Logger logger = LogManager.getLogger(LoginPageMethods.class);

    public LoginPageMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void login(String userEmail, String userPassword) {


        try {
            logger.info("Starting the login process...");

            commonMethods.waitForElementToBePresent(loginPageMap.inputUserName);

            logger.info("User field found.");

            commonMethods.sendText(loginPageMap.inputUserName, userEmail);

            logger.info("Username entered.");

            commonMethods.sendText(loginPageMap.inputPassword, userPassword);

            logger.info("Password entered.");

            commonMethods.clickElement(loginPageMap.SignInBtn);

            logger.info("Login button clicked.");


        } catch (Exception e) {
            logger.error("Error during login: " + e.getMessage(), e);
        }
    }
}
