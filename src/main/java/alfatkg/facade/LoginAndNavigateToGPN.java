package alfatkg.facade;

import alfatkg.pages.CustomerLoginPage;
import alfatkg.pages.GPNHomePage;

public class LoginAndNavigateToGPN {

    public GPNHomePage loginToGPN() {
        return new CustomerLoginPage().customerLogin().userLogin()
                .clickSoftwareLibrary().clickGPN();
    }

}
