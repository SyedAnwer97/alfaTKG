package alfatkg.utils;

import alfatkg.driver.DriverManger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUtils {

    private ScreenShotUtils() {
    }

    public static String getScreenShot() {
        return ((TakesScreenshot) DriverManger.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}