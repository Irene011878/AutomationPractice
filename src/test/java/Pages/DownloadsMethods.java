package Pages;

import Maps.DownloadsMap;
import Utils.CommonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DownloadsMethods {

    private static final Logger logger = LogManager.getLogger(DownloadsMethods.class);

    CommonMethods commonMethods;
    DownloadsMap downloadsMap = new DownloadsMap();

    public DownloadsMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void downloadOne(String firstName, String lastName, String phone, String streetName, String city, String zipCode ){

        logger.info("Starting download process for customer: {} {}", firstName, lastName);

        commonMethods.clickElementByJSd(downloadsMap.downloadLink);
        logger.debug("Clicked on 'Download Link'");

        commonMethods.clickElementByJSd(downloadsMap.goShopDwl);
        logger.debug("Clicked on 'Go to Shop'");

        commonMethods.clickElementByJSd(downloadsMap.seleniumDwl);
        logger.debug("Clicked on 'Selenium Download'");

        commonMethods.clickElementByJSd(downloadsMap.addSeToBasket);
        logger.debug("Added Selenium to basket");

        commonMethods.clickElementByJSd(downloadsMap.viewBasket);
        logger.debug("Viewed the basket");

        commonMethods.clickElementByJSd(downloadsMap.proceedToCheckOut);
        logger.debug("Viewed the basket");

        commonMethods.sendText(downloadsMap.firstName, firstName);
        logger.debug("Entered first name: " + firstName);

        commonMethods.sendText(downloadsMap.lastName, lastName);
        logger.debug("Entered last name: " + lastName);

        commonMethods.sendText(downloadsMap.phoneNum, phone);
        logger.debug("Entered phone number: " + phone);

        commonMethods.sendText(downloadsMap.streetAddress, streetName);
        logger.debug("Entered street address: " + streetName);

        commonMethods.sendText(downloadsMap.cityTown, city);
        logger.debug("Entered city: " + city);

        commonMethods.sendText(downloadsMap.zipCodeDwl, zipCode);
        logger.debug("Entered zip code: " + zipCode);

        commonMethods.clickElementByJSd(downloadsMap.payOnDeliveryBtn);
        logger.debug("Selected 'Pay on Delivery' option");

        commonMethods.clickElementByJSd(downloadsMap.placeOrderBtn);
        logger.debug("Placed the order");

        logger.info("Download process completed for customer: {} {}", firstName, lastName);

    }
}

