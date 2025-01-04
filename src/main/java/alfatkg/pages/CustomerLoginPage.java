package alfatkg.pages;

import alfatkg.enums.PropertyKey;
import alfatkg.utils.DynamicXpath;
import alfatkg.utils.ReadConfig;
import org.openqa.selenium.By;

public final class CustomerLoginPage extends PageActions {

    private static final String DYNAMIC_LOCATOR = "//*[@id='%s']";

    private static final By dropDropLanguageSelection = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "mySelect"));
    private static final By textBoxCustomerName = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "username"));
    private static final By textBoxPassword = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "password"));
    private static final By buttonCustomerLogin = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "logmein"));

    public CustomerLoginPage selectLanguage() {
        customSelect(a -> a.selectByVisibleText("English"), dropDropLanguageSelection);
        return new CustomerLoginPage();
    }

    public CustomerLoginPage enterCustomerName() {
        customSendKeys(textBoxCustomerName, ReadConfig.getProperty(PropertyKey.CUSTOMER_NAME));
        return new CustomerLoginPage();
    }

    public CustomerLoginPage enterCustomerPassword() {
        customSendKeys(textBoxPassword, ReadConfig.getProperty(PropertyKey.CUSTOMER_PASSWORD));
        return new CustomerLoginPage();
    }

    public UserLoginPage clickLogin() {
        customClick(buttonCustomerLogin);
        return new UserLoginPage();
    }

    public UserLoginPage customerLogin() {
        return selectLanguage().enterCustomerName().enterCustomerPassword().clickLogin();
    }

}