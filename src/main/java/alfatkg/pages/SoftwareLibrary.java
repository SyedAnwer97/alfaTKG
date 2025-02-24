package alfatkg.pages;

import alfatkg.consant.FrameworkConstants;
import alfatkg.utils.DynamicXpath;
import org.openqa.selenium.By;

public class SoftwareLibrary extends PageActions {

    private static final String DYNAMIC_LOCATOR = "//*[.='%s']//input";

    private static final By IMAGE_GAIA_PROCESS_NAVI = By.xpath(DynamicXpath.xpath(DYNAMIC_LOCATOR, "GAIA Process NAVI"));

    public GPNHomePage clickGPN() {
        customClick(IMAGE_GAIA_PROCESS_NAVI, "GAIA Process NAVI");
        switchToTab(FrameworkConstants.getGPN_TITLE());
        closeTheTab(FrameworkConstants.getALFADOCK_TITLE());
        return new GPNHomePage();
    }
}
