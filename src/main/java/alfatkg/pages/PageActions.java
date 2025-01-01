package alfatkg.pages;

import alfatkg.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.function.Consumer;

public class PageActions {

    public void customClick(By locator) {
        WaitFactory.wait(WaitStrategy.CLICKABLE, locator).click();
    }

    public void customSendKeys(By locator, String keys) {
        WaitFactory.wait(WaitStrategy.VISIBLE, locator).sendKeys(keys);
    }

    public void customSelect(Consumer<Select> selectConsumer, By locator) {
        Select select = new Select(WaitFactory.wait(WaitStrategy.VISIBLE, locator));
        selectConsumer.accept(select);
    }
}
