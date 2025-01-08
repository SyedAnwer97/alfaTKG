package alfatkg.pages;

import alfatkg.driver.DriverManger;
import alfatkg.enums.WaitStrategy;
import alfatkg.factories.WaitFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.function.Consumer;

public class PageActions {

    private JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManger.getDriver();

    public WebElement customFindElement(By locator, WaitStrategy waitStrategy) {
        return WaitFactory.wait(waitStrategy, locator);
    }

    public void customClick(By locator) {
        try {
            WaitFactory.wait(WaitStrategy.CLICKABLE, locator).click();
        } catch (TimeoutException e) {
            javascriptExecutor.executeScript("arguments[0].click();", DriverManger.getDriver().findElement(locator));
        }
    }

    public void customSendKeys(By locator, String keys) {
        WaitFactory.wait(WaitStrategy.VISIBLE, locator).sendKeys(keys);
    }

    public void customSelect(Consumer<Select> selectConsumer, By locator) {
        Select select = new Select(WaitFactory.wait(WaitStrategy.VISIBLE, locator));
        selectConsumer.accept(select);
    }

    public void switchToTab(String title) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        for (String windowHandle : DriverManger.getDriver().getWindowHandles())
            if (DriverManger.getDriver().switchTo().window(windowHandle).getTitle().equalsIgnoreCase(title)) return;
        throw new NoSuchWindowException("No such window with " + title + " title is available in the driver");
    }

    public void closeTheTab(String title) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        String activeTab = DriverManger.getDriver().getWindowHandle();
        for (String windowHandle : DriverManger.getDriver().getWindowHandles())
            if (DriverManger.getDriver().switchTo().window(windowHandle).getTitle().equalsIgnoreCase(title))
                DriverManger.getDriver().close();
        DriverManger.getDriver().switchTo().window(activeTab);
    }

    public boolean isElementDisplayed(WaitStrategy waitStrategy, By locator) {
        return WaitFactory.wait(waitStrategy, locator).isDisplayed();
    }

    public void customClearText(By locator) {
        WaitFactory.wait(WaitStrategy.VISIBLE, locator).clear();
    }
}