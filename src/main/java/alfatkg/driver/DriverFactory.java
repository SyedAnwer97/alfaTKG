package alfatkg.driver;

import alfatkg.consant.FrameworkConstants;
import alfatkg.enums.Browser;
import alfatkg.enums.PropertyKey;
import alfatkg.utils.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory() {
    }

    private static EnumMap<Browser, Supplier<WebDriver>> map = new EnumMap<>(Browser.class);
    private static WebDriver driver = null;
    private static URL url;

    private static Supplier<WebDriver> chrome = () -> {
        if (ReadConfig.getProperty(PropertyKey.RUN_MODE).equalsIgnoreCase(FrameworkConstants.getRemote())) {
            ChromeOptions chromeOptions = new ChromeOptions();
            try {
                url = new URL(ReadConfig.getProperty(PropertyKey.GRID_URL));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver = new RemoteWebDriver(url, chromeOptions);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    };

    private static Supplier<WebDriver> firefox = () -> {
        if (ReadConfig.getProperty(PropertyKey.RUN_MODE).equalsIgnoreCase(FrameworkConstants.getRemote())) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            try {
                url = new URL(ReadConfig.getProperty(PropertyKey.GRID_URL));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver = new RemoteWebDriver(url, firefoxOptions);
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    };

    static {
        map.put(Browser.CHROME, chrome);
        map.put(Browser.FIREFOX, firefox);
    }

    public static WebDriver getDriver(String browser) {
        return map.get(Browser.valueOf(browser.toUpperCase())).get();
    }

}