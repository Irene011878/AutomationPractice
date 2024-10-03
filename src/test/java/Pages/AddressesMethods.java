package Pages;

import Maps.AddressesMap;
import Maps.HomePageMap;
import Utils.CommonMethods;
import org.openqa.selenium.By;

public class AddressesMethods {

    CommonMethods commonMethods;
    AddressesMap addressesMap = new AddressesMap();

    public AddressesMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void editAddress(){

    commonMethods.clickElement(addressesMap.addressesBtn);
    commonMethods.clickElement(addressesMap.editBillingAddressBtn);
    commonMethods.sendText(addressesMap.firstNameBox, "Irene");
    commonMethods.sendText(addressesMap.lastNameBox, "Aguilar");
    commonMethods.sendText(addressesMap.phoneBox, "8441111245");
    commonMethods.sendText(addressesMap.streetAddress, "Indus1265");
    commonMethods.sendText(addressesMap.billingCity, "Delhi");
    commonMethods.clickElement(addressesMap.saveAddress);

    }
}
