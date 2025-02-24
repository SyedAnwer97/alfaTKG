package tests;

import alfatkg.driver.Driver;
import alfatkg.driver.DriverManger;
import alfatkg.enums.PropertyKey;
import alfatkg.utils.ReadConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    @BeforeMethod
    protected void beforeMethod() {
        Driver.initDriver();
        DriverManger.getDriver().get(ReadConfig.getProperty(PropertyKey.URL));
    }

    @AfterMethod
    protected static void afterMethod() {
        Driver.tearDown();
    }

}