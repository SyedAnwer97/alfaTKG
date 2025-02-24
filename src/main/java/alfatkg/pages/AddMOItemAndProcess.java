package alfatkg.pages;

import alfatkg.factories.WaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddMOItemAndProcess extends PageActions {

    private static final By DROPDOWN_CUSTOMER = By.xpath("//*[@filter='filter']");
    private static final By TEXTBOX_PO_NUMBER = By.xpath("//label[text()='PO Number*:']/following-sibling::input");
    private static final By TEXTBOX_DELIVERY_PLACE = By.xpath("//label[text()='Delivery Place:']/following-sibling::input");
    private static final By BUTTON_ADD_MO = By.xpath("//button[.='Add MO']");
    private static final String LIST_CUSTOMER_NAME = "(//*[@class='ui-dropdown-items-wrapper']/ul)[2]/li[%s]";
    private static final By SVG_PROGRESSBAR = By.xpath("(//*[name()='svg']//*[name()='circle'])[1]");

    private static final By TEXTBOX_SEARCH_BAR = By.id("testInput");
    private static final By TEXTBOX_PRODUCT_NUMBER = By.xpath("//label[.='Product No* :']/../input");
    private static final By BUTTON_ADD_ITEM_DETAILS = By.xpath("//button[.='Add Item Details']");

    public AddMOItemAndProcess addMO() {
        customClick(DROPDOWN_CUSTOMER, "customer name dropdown");
        customClick(By.xpath(String.format(LIST_CUSTOMER_NAME, "1")), "customer name");
        customSendKeys(TEXTBOX_PO_NUMBER, "TestPO", "product number");
        customSendKeys(TEXTBOX_DELIVERY_PLACE, "japan", "location");
        customClick(BUTTON_ADD_MO, "add MO button");
        return new AddMOItemAndProcess();
    }

    public void addMOItem() {
        WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
        customSendKeys(TEXTBOX_SEARCH_BAR, "TestPO" + Keys.ENTER, "searchbar");
        WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
        customAction(a -> a.moveByOffset(736, 228).click().build().perform());
        customSendKeys(TEXTBOX_PRODUCT_NUMBER, "TestPONum", "product number text box");
        customClick(BUTTON_ADD_ITEM_DETAILS, "product number test box");
    }
}