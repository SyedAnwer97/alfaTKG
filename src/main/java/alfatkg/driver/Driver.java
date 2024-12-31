package alfatkg.driver;

import alfatkg.utils.ReadConfig;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    public static void initDriver() {
        if (Objects.isNull(DriverManger.getDriver())) {
            driver = DriverFactory.getDriver(ReadConfig.getProperty("BROWSER"));
            DriverManger.setDriver(driver);
        }
    }

    public static void tearDown() {
        if (Objects.nonNull(DriverManger.getDriver())) {
            DriverManger.getDriver().quit();
            DriverManger.unloadDriver();
        }
    }
}