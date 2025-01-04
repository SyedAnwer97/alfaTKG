package tests;

import alfatkg.driver.Driver;
import alfatkg.driver.DriverManger;
import alfatkg.enums.PropertyKey;
import alfatkg.utils.ReadConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseClass {

    @BeforeMethod
    public void beforeMethod(Method method) {
        Driver.initDriver();
        DriverManger.getDriver().get(ReadConfig.getProperty(PropertyKey.URL));
        DriverManger.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverManger.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public static void AfterMethod() {
        Driver.tearDown();
    }

}
