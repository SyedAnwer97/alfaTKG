package alfatkg.driver;

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
import java.util.HashMap;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory() {
    }

    private static HashMap<String, Supplier<WebDriver>> map = new HashMap<>();
    private static WebDriver driver = null;
    private static URL url;

    private static Supplier<WebDriver> chrome = () -> {
        if (ReadConfig.getProperty("RUNMODE").equalsIgnoreCase("remote")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            try {
                url = new URL(ReadConfig.getProperty("GRIDURL"));
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
        if (ReadConfig.getProperty("RUNMODE").equalsIgnoreCase("remote")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            try {
                url = new URL(ReadConfig.getProperty("GRIDURL"));
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
        map.put("chrome", chrome);
        map.put("firefox", firefox);
    }

    public static WebDriver getDriver(String browserName) {
        return map.get(browserName.toLowerCase()).get();
    }

}