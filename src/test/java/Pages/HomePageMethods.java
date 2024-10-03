package Pages;

import Maps.HomePageMap;
import Utils.CommonMethods;

public class HomePageMethods {

    CommonMethods commonMethods;
    HomePageMap homePageMap = new HomePageMap();

    public HomePageMethods(CommonMethods commonMethods) {

        this.commonMethods = commonMethods;
    }

    public void homePageElement(){



        commonMethods.clickElement(homePageMap.signOutBtn);

    }
}
