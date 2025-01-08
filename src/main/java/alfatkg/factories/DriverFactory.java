package alfatkg.factories;

import alfatkg.consant.FrameworkConstants;
import alfatkg.enums.Browser;
import alfatkg.enums.PropertyKey;
import alfatkg.exceptions.InvalidGridHostException;
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

    private static final EnumMap<Browser, Supplier<WebDriver>> map = new EnumMap<>(Browser.class);

    private static final Supplier<WebDriver> chrome = () -> {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--use-fake-ui-for-media-stream");
        WebDriverManager.chromedriver().setup();
        return ReadConfig.getProperty(PropertyKey.RUN_MODE).equalsIgnoreCase(FrameworkConstants.getREMOTE())
                ? new RemoteWebDriver(getGridURL(), chromeOptions) : new ChromeDriver(chromeOptions);
    };

    private static final Supplier<WebDriver> firefox = () -> {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("-private");
        WebDriverManager.firefoxdriver().setup();
        return ReadConfig.getProperty(PropertyKey.RUN_MODE).equalsIgnoreCase(FrameworkConstants.getREMOTE())
                ? new RemoteWebDriver(getGridURL(), firefoxOptions) : new FirefoxDriver(firefoxOptions);

    };

    static {
        map.put(Browser.CHROME, chrome);
        map.put(Browser.FIREFOX, firefox);
    }

    public static WebDriver getDriver(String browser) {
        return map.get(Browser.valueOf(browser.toUpperCase())).get();
    }

    public static URL getGridURL() {
        URL url;
        try {
            url = new URL(ReadConfig.getProperty(PropertyKey.GRID_URL));
        } catch (MalformedURLException e) {
            throw new InvalidGridHostException("The Grid connection is not valid. Please check the host and port");
        }
        return url;
    }

}