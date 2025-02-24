package alfatkg.pages;

import alfatkg.driver.DriverManger;
import alfatkg.enums.Logs;
import alfatkg.enums.WaitStrategy;
import alfatkg.extentreport.ExtentFactory;
import alfatkg.factories.WaitFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.function.Consumer;

public class PageActions {

    private final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManger.getDriver();

    protected WebElement customFindElement(By locator, WaitStrategy waitStrategy) {
        return WaitFactory.wait(waitStrategy, locator);
    }

    protected void customClick(By locator, String elementName) {
        try {
            WaitFactory.wait(WaitStrategy.CLICKABLE, locator).click();
        } catch (TimeoutException e) {
            javascriptExecutor.executeScript("arguments[0].click();", DriverManger.getDriver().findElement(locator));
        }
        ExtentFactory.log(Logs.INFO, elementName.concat(" is get clicked."));
    }

    protected void customSendKeys(By locator, String keys, String elementName) {
        WaitFactory.wait(WaitStrategy.VISIBLE, locator).sendKeys(keys);
        ExtentFactory.log(Logs.INFO, elementName.concat(" is passed with " + keys));
    }

    protected void customSelect(Consumer<Select> selectConsumer, By locator, String value) {
        Select select = new Select(WaitFactory.wait(WaitStrategy.VISIBLE, locator));
        selectConsumer.accept(select);
        ExtentFactory.log(Logs.INFO, value.concat(" is selected in the dropdown"));
    }

    protected void switchToTab(String title) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));

        for (String windowHandle : DriverManger.getDriver().getWindowHandles())
            if (DriverManger.getDriver().switchTo().window(windowHandle).getTitle().equalsIgnoreCase(title) ||
                    DriverManger.getDriver().switchTo().window(windowHandle).getTitle().equalsIgnoreCase("SI スケジューラー")) {
                ExtentFactory.log(Logs.INFO, "The tab with the " + title + " is displayed");
                return;
            }
        throw new NoSuchWindowException("No such window with " + title + " title is available in the driver");
    }

    protected void closeTheTab(String title) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        String activeTab = DriverManger.getDriver().getWindowHandle();
        for (String windowHandle : DriverManger.getDriver().getWindowHandles())
            if (DriverManger.getDriver().switchTo().window(windowHandle).getTitle().equalsIgnoreCase(title))
                DriverManger.getDriver().close();
        DriverManger.getDriver().switchTo().window(activeTab);
    }

    protected boolean isElementDisplayed(WaitStrategy waitStrategy, By locator) {
        return WaitFactory.wait(waitStrategy, locator).isDisplayed();
    }

    protected void customClearText(By locator) {
        WaitFactory.wait(WaitStrategy.VISIBLE, locator).clear();
    }

    protected void customAction(Consumer<Actions> actionsConsumer) {
        Actions actions = new Actions(DriverManger.getDriver());
        actionsConsumer.accept(actions);
    }
}