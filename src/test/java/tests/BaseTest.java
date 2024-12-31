package tests;

import alfatkg.driver.Driver;
import alfatkg.driver.DriverManger;
import alfatkg.utils.ReadConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private String runMode = ReadConfig.getProperty("RUNMODE");

    @BeforeMethod
    public void beforeMethod() {
        Driver.initDriver();
        DriverManger.getDriver().get(ReadConfig.getProperty("URL"));
        DriverManger.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        DriverManger.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public static void AfterMethod() {
        Driver.tearDown();
    }
}
