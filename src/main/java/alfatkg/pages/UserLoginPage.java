package alfatkg.pages;

import alfatkg.enums.PropertyKey;
import alfatkg.factories.WaitFactory;
import alfatkg.utils.DynamicXpath;
import alfatkg.utils.ReadConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class UserLoginPage extends PageActions {

    private static final String DYNAMIC_LOCATOR = "//*[@id='%s']";

    private static final By TEXT_BOX_USERNAME = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "username"));
    private static final By TEXT_BOX_PASSWORD = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "password"));
    private static final By BUTTON_LOGIN = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "login"));
    private static final By BUTTON_LOGOUT = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "logout"));

    public UserLoginPage enterUsername() {
        WaitFactory.wait(a -> a.until(ExpectedConditions.titleIs("UserLogin")));
        customSendKeys(TEXT_BOX_USERNAME, ReadConfig.getProperty(PropertyKey.USERNAME), "user name");
        return new UserLoginPage();
    }

    public UserLoginPage enterUserPassword() {
        customSendKeys(TEXT_BOX_PASSWORD, ReadConfig.getProperty(PropertyKey.USER_PASSWORD), "user password");
        return new UserLoginPage();
    }

    public AlfaDOCKHomePage clickUserLogin() {
        customClick(BUTTON_LOGIN, "login button");
        return new AlfaDOCKHomePage();
    }

    public CustomerLoginPage clickUserLogout() {
        customClick(BUTTON_LOGOUT, "logout button");
        return new CustomerLoginPage();
    }

    public AlfaDOCKHomePage userLogin() {
        return enterUsername().enterUserPassword().clickUserLogin();
    }

    public CustomerLoginPage userLogout() {
        return clickUserLogout();
    }

    public UserLoginPage enterUsername(Map<String, String> data) {
        WaitFactory.wait(a -> a.until(ExpectedConditions.titleIs("UserLogin")));
        customSendKeys(TEXT_BOX_USERNAME, data.get("username"), "user name");
        return new UserLoginPage();
    }

    public UserLoginPage enterUserPassword(Map<String, String> data) {
        customSendKeys(TEXT_BOX_PASSWORD, data.get("userpass"), "user password");
        return new UserLoginPage();
    }

    @SneakyThrows
    public <T> T clickUserLogin(Class<T> clazz) {
        customClick(BUTTON_LOGIN, "login button");
        return clazz.getDeclaredConstructor().newInstance();
    }

    public <T> T userLogin(Map<String, String> data, Class<T> clazz) {
        return enterUsername(data).enterUserPassword(data).clickUserLogin(clazz);
    }

}
