package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"irene.aguilarperez@hotmail.com", "Pipet@4707"},

        };
    }

    @DataProvider(name = "addressData")
    public Object[][] getAddressData() {
        return new Object[][]{
                {"Irene", "Aguilar", "8441111245", "Indus1265", "Delhi"},

        };
    }

    @DataProvider(name = "loginInvalidData")
    public Object[][] getLoginInvalidData() {
        return new Object[][]{
                {"irene.aguilarperez@hotmail.com", "1234"},

        };
    }
    @DataProvider(name = "addressInvalidPhoneData")
    public Object[][] getAddressInvalidPhoneData() {
        return new Object[][]{
                {"Irene", "Aguilar", "invalid", "Indus1265", "Delhi"},

        };
    }

}
//Added on october 14
