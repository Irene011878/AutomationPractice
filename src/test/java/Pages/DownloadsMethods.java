package Pages;

import Maps.DownloadsMap;
import Utils.CommonMethods;

public class DownloadsMethods {

    CommonMethods commonMethods;
    DownloadsMap downloadsMap = new DownloadsMap();

    public DownloadsMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void downloadOne(){

        commonMethods.clickElementByJSd(downloadsMap.downloadLink);
        commonMethods.clickElementByJSd(downloadsMap.goShopDwl);
        commonMethods.clickElementByJSd(downloadsMap.seleniumDwl);
        commonMethods.clickElementByJSd(downloadsMap.addSeToBasket);
        commonMethods.clickElementByJSd(downloadsMap.viewBasket);
        commonMethods.clickElementByJSd(downloadsMap.proceedToCheckOut);
        commonMethods.sendText(downloadsMap.firstName, "Irene");
        commonMethods.sendText(downloadsMap.lastName, "Aguilar");
        commonMethods.sendText(downloadsMap.phoneNum, "8441111245");
        commonMethods.sendText(downloadsMap.streetAddress, "Indus1265");
        commonMethods.sendText(downloadsMap.cityTown, "Delhi");
        commonMethods.sendText(downloadsMap.zipCodeDwl, "25000");
        commonMethods.clickElementByJSd(downloadsMap.payOnDeliveryBtn);
        commonMethods.clickElementByJSd(downloadsMap.placeOrderBtn);

    }
}

