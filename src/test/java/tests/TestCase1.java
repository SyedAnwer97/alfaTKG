package tests;

import alfatkg.driver.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test()
    public void DemoTest() {
        WebElement dropDownLanguage = DriverManger.getDriver().findElement(By.xpath("//*[@id='mySelect']"));
        Select select = new Select(dropDownLanguage);
        select.selectByVisibleText("English");
        DriverManger.getDriver().findElement(By.id("username")).sendKeys("schedule-test");
        DriverManger.getDriver().findElement(By.id("password")).sendKeys("schedule-test");
        DriverManger.getDriver().findElement(By.id("logmein")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException("The timeout exception");
        }
    }

    @Test()
    public void DemoTest2() {
        WebElement dropDownLanguage = DriverManger.getDriver().findElement(By.xpath("//*[@id='mySelect']"));
        Select select = new Select(dropDownLanguage);
        select.selectByVisibleText("English");
        DriverManger.getDriver().findElement(By.id("username")).sendKeys("schedule-test");
        DriverManger.getDriver().findElement(By.id("password")).sendKeys("schedule-test");
        DriverManger.getDriver().findElement(By.id("logmein")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException("The timeout exception");
        }
    }

}