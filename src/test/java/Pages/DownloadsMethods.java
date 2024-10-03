package Pages;

import Maps.AddressesMap;
import Maps.DownloadsMap;
import Utils.CommonMethods;

public class DownloadsMethods {

    CommonMethods commonMethods;
    DownloadsMap downloadsMap = new DownloadsMap();

    public DownloadsMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void downloadOne(){

        commonMethods.clickElement(downloadsMap.downloadLink);
        commonMethods.clickElement(downloadsMap.goShopDwl);
        commonMethods.clickElement(downloadsMap.seleniumDwl);
        commonMethods.clickElement(downloadsMap.addSeToBasket);
        commonMethods.clickElement(downloadsMap.viewBasket);
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

