package alfatkg.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManger {

    private DriverManger() {
    }

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        webDriverThreadLocal.set(webDriver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void unloadDriver() {
        webDriverThreadLocal.remove();
    }
}