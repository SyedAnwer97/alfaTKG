package alfatkg.pages;

import alfatkg.driver.DriverManger;
import org.openqa.selenium.By;

public class AlfaDOCKHomePage extends PageActions{

    private static final By IMAGE_COMPANY_LOGO = By.xpath("//img[@src='assets/icons/logo.png']");

    public void verifyCompanyLogo() {
        DriverManger.getDriver().findElement(IMAGE_COMPANY_LOGO).isDisplayed();
    }

}
