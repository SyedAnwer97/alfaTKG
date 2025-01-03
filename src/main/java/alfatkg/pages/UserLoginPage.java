package alfatkg.pages;

import alfatkg.enums.PropertyKey;
import alfatkg.factories.WaitFactory;
import alfatkg.utils.DynamicXpath;
import alfatkg.utils.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserLoginPage extends PageActions {

    private static final String DYNAMIC_LOCATOR = "//*[@id='%s']";

    private static final By TEXT_BOX_USERNAME = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "username"));
    private static final By TEXT_BOX_PASSWORD = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "password"));
    private static final By BUTTON_LOGIN = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "login"));
    private static final By BUTTON_LOGOUT = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "logout"));

    public UserLoginPage enterUsername() {
        WaitFactory.wait(a -> a.until(ExpectedConditions.titleIs("UserLogin")));
        customSendKeys(TEXT_BOX_USERNAME, ReadConfig.getProperty(PropertyKey.USERNAME));
        return new UserLoginPage();
    }

    public UserLoginPage enterUserPassword() {
        customSendKeys(TEXT_BOX_PASSWORD, ReadConfig.getProperty(PropertyKey.USER_PASSWORD));
        return new UserLoginPage();
    }

    public AlfaDOCKHomePage clickUserLogin() {
        customClick(BUTTON_LOGIN);
        return new AlfaDOCKHomePage();
    }

    public CustomerLoginPage clickUserLogout() {
        customClick(BUTTON_LOGOUT);
        return new CustomerLoginPage();
    }

    public AlfaDOCKHomePage userLogin() {
        enterUsername().enterUserPassword().clickUserLogin();
        return new AlfaDOCKHomePage();
    }

    public CustomerLoginPage userLogout() {
        clickUserLogout();
        return new CustomerLoginPage();
    }
}
