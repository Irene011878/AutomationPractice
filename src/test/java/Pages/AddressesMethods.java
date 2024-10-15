package Pages;

import Maps.AddressesMap;
import Utils.CommonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddressesMethods {

    private static final Logger logger = LogManager.getLogger(AddressesMethods.class);

    CommonMethods commonMethods;
    AddressesMap addressesMap = new AddressesMap();

    public AddressesMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void editAddress(String firstName, String lastName, String phone, String streetName, String city){

        logger.info("Editing address with the following details:");
        logger.info("First Name: " + firstName);
        logger.info("Last Name: " + lastName);
        logger.info("Phone: " + phone);
        logger.info("Street Name: " + streetName);
        logger.info("City: " + city);

    commonMethods.clickElement(addressesMap.addressesBtn);
        logger.debug("Clicked on the 'Addresses' button");

    commonMethods.clickElement(addressesMap.editBillingAddressBtn);
        logger.debug("Clicked on the 'Edit Billing Address' button");

    commonMethods.sendText(addressesMap.firstNameBox, firstName);
        logger.debug("Entered first name: " + firstName);

    commonMethods.sendText(addressesMap.lastNameBox, lastName);
        logger.debug("Entered last name: " + lastName);

    commonMethods.sendText(addressesMap.phoneBox, phone);
        logger.debug("Entered phone number: " + phone);

        commonMethods.sendText(addressesMap.streetAddress, streetName);
        logger.debug("Entered street name: " + streetName);

    commonMethods.sendText(addressesMap.billingCity, city);
        logger.debug("Entered city: " + city);

    commonMethods.clickElement(addressesMap.saveAddress);
        logger.debug("Clicked on the 'Save Address' button");

        logger.info("Address successfully updated.");


    }
}
