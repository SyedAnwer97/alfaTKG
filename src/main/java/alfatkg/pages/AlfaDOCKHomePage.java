package alfatkg.pages;

import alfatkg.driver.DriverManger;
import alfatkg.utils.DynamicXpath;
import org.openqa.selenium.By;

public class AlfaDOCKHomePage extends PageActions{

    private static final String DYNAMIC_LOCATOR = "//*[.='%s']";

    private static final By IMAGE_SOFTWARE_LIBRARY = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "Software Library"));
    private static final By IMAGE_COMPANY_LOGO = By.xpath("//img[@src='assets/icons/logo.png']");

    public void verifyCompanyLogo() {
        DriverManger.getDriver().findElement(IMAGE_COMPANY_LOGO).isDisplayed();
    }

    public SoftwareLibrary clickSoftwareLibrary() {
        customClick(IMAGE_SOFTWARE_LIBRARY);
        return new SoftwareLibrary();
    }

}
