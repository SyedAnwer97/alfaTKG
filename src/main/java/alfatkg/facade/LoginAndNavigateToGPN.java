package alfatkg.facade;

import alfatkg.consant.FrameworkConstants;
import alfatkg.factories.WaitFactory;
import alfatkg.pages.AlfaDOCKHomePage;
import alfatkg.pages.CustomerLoginPage;
import alfatkg.pages.GPNHomePage;
import alfatkg.pages.PageActions;
import lombok.SneakyThrows;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class LoginAndNavigateToGPN extends PageActions {

    public GPNHomePage loginToGPN() {
        return new CustomerLoginPage().customerLogin().userLogin()
                .clickSoftwareLibrary().clickGPN();
    }

    @SneakyThrows
    public <T> T loginToGPN(Map<String, String> data, Class<T> clazz) {
        if (data.containsKey("landingpage")) {
            new CustomerLoginPage().customerLogin(data).userLogin(data, clazz);
            WaitFactory.wait(a->a.until(ExpectedConditions.titleIs(FrameworkConstants.getGPN_TITLE())));
            return clazz.getDeclaredConstructor().newInstance();
        } else {
            clazz = (Class<T>) AlfaDOCKHomePage.class;
            return (T) ((AlfaDOCKHomePage) new CustomerLoginPage().customerLogin(data).userLogin(data, clazz)).clickSoftwareLibrary().clickGPN();
        }
    }

}
