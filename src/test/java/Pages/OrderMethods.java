package Pages;

import Maps.OrderMap;
import Utils.BaseClass;
import Utils.CommonMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class OrderMethods extends BaseClass {

    private static final Logger logger = LogManager.getLogger(OrderMethods.class);

    CommonMethods commonMethods;
    OrderMap orderMap = new OrderMap();

    public OrderMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void seeOrder() {

        logger.info("Starting 'seeOrder' process");

        commonMethods.clickElement(orderMap.orderLink);
        logger.debug("Clicked on 'Order Link'");

        commonMethods.clickElement(orderMap.viewOrder1);
        logger.debug("Clicked on 'View Order'");

        logger.info("Completed 'seeOrder' process");

    }
}
