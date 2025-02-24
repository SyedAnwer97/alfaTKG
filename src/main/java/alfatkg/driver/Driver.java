package alfatkg.driver;

import alfatkg.enums.PropertyKey;
import alfatkg.factories.DriverFactory;
import alfatkg.utils.ReadConfig;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(DriverManger.getDriver())) {
            WebDriver driver = DriverFactory.getDriver(ReadConfig.getProperty(PropertyKey.BROWSER));
            DriverManger.setDriver(driver);
            DriverManger.getDriver().manage().window().maximize();
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(DriverManger.getDriver())) {
            DriverManger.getDriver().quit();
            DriverManger.unloadDriver();
        }
    }

}