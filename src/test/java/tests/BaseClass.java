package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {

    private String URL = "https://www.alfadock-pack.com/";
    private WebDriver driver;
    private String runMode = "local";

    @Test
    public void DemoTest() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        URL url = new URL("http://hub:4444/");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = runMode == "remote" ? new ChromeDriver() : new RemoteWebDriver(url, chromeOptions);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        WebElement dropDownLanguage = driver.findElement(By.xpath("//*[@id='mySelect']"));
        Select select = new Select(dropDownLanguage);
        select.selectByVisibleText("English");
        driver.findElement(By.id("username")).sendKeys("schedule-test");
        driver.findElement(By.id("password")).sendKeys("schedule-test");
        driver.findElement(By.id("logmein")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException("The timeout exception");
        }
        driver.quit();
    }
}
