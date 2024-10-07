package Pages;

import Maps.OrderMap;
import Utils.BaseClass;
import Utils.CommonMethods;


public class OrderMethods extends BaseClass {

    CommonMethods commonMethods;
    OrderMap orderMap = new OrderMap();

    public OrderMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void seeOrder() {

        commonMethods.clickElement(orderMap.orderLink);
        commonMethods.clickElement(orderMap.viewOrder1);


    }
}
