package alfatkg.pages;

import alfatkg.driver.DriverManger;
import alfatkg.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Consumer;

public final class WaitFactory {

    private WaitFactory() {
    }

    private static WebElement element = null;
    private static WebDriverWait wait;

    public static void wait(Consumer<WebDriverWait> waitConsumer) {
        wait = new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(10));
        waitConsumer.accept(wait);
    }

    public static WebElement wait(WaitStrategy waitStrategy, By locator) {
        wait = new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(10));

        switch (waitStrategy) {
            case CLICKABLE -> {
                element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                return element;
            }
            case VISIBLE -> {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                return element;
            }
            case PRESENCE -> {
                element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return element;
            }
            case NONE -> {
                element = DriverManger.getDriver().findElement(locator);
                return element;
            }
            default -> {
                DriverManger.getDriver().findElement(locator);
                return element;
            }
        }
    }
}
