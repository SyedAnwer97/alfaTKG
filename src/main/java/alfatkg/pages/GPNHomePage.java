package alfatkg.pages;

import alfatkg.consant.FrameworkConstants;
import alfatkg.enums.WaitStrategy;
import alfatkg.factories.WaitFactory;
import alfatkg.utils.DynamicXpath;
import alfatkg.utils.FakerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class GPNHomePage extends PageActions {

    private static final String TOOLBAR_ICONS_DYNAMIC_LOCATOR = "(//div//ul[@class='toolbar']//*[@title='Reports'])[1]";

    private static final By ICON_HOME = By.xpath("//*[@class='menu-item pi pi-home']");
    private static final By ICON_SCANNER = By.xpath("//*[@class='glyphicon glyphicon-barcode']/parent::button");
    private static final By DIALOG_SCANNER = By.xpath(("//*[.='Barcode Scan']"));
    private static final By DATE_PICKER_FROM_DATE = By.xpath("(//app-ui-daterangepicker[1]//input)[1]");
    private static final By DATE_PICKER_TO_DATE = By.xpath("(//app-ui-daterangepicker[1]//input)[2]");
    private static final By SVG_PROGRESSBAR = By.xpath("(//*[name()='svg']//*[name()='circle'])[1]");

    private static final By ICON_AI_REPORT = By.xpath(DynamicXpath.xpath(TOOLBAR_ICONS_DYNAMIC_LOCATOR, "Reports"));

    public AlfaDOCKHomePage clickHomeIcon() {
        customClick(ICON_HOME);
        switchToTab(FrameworkConstants.getALFADOCK_TITLE());
        return new AlfaDOCKHomePage();
    }

    public GPNHomePage clickScannerIcon() {
        customClick(ICON_SCANNER);
        return new GPNHomePage();
    }

    public Boolean isScannerDialogDisplayed() {
        return isElementDisplayed(WaitStrategy.VISIBLE, DIALOG_SCANNER);
    }

    public void pickFromAndToDate() {
        Map<String, String> fromDateAndToDate = FakerUtils.getFromDateAndToDate();
        //customClearText(DATE_PICKER_FROM_DATE);
        //customSendKeys(DATE_PICKER_FROM_DATE, "00" + fromDateAndToDate.get("fromDate"));
        //WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
        //customClearText(DATE_PICKER_TO_DATE);
        //customSendKeys(DATE_PICKER_TO_DATE, "00" + fromDateAndToDate.get("toDate"));
        //WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
    }

    public void clickAiReportIcon() {
        customClick(ICON_AI_REPORT);
        WaitFactory.wait(a -> a.until(ExpectedConditions.titleIs(FrameworkConstants.getAI_REPORT_TITLE())));
    }

}
