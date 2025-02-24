package alfatkg.pages;

import alfatkg.utils.DynamicXpath;
import org.openqa.selenium.By;

public class AlfaDOCKHomePage extends PageActions {

    private static final String DYNAMIC_LOCATOR = "//*[.='%s']";

    private static final By IMAGE_SOFTWARE_LIBRARY = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "Software Library"));

    public SoftwareLibrary clickSoftwareLibrary() {
        customClick(IMAGE_SOFTWARE_LIBRARY, "software library");
        return new SoftwareLibrary();
    }
}