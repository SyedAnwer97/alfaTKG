package alfatkg.pages;

import alfatkg.consant.FrameworkConstants;
import alfatkg.driver.DriverManger;
import alfatkg.enums.Logs;
import alfatkg.enums.WaitStrategy;
import alfatkg.extentreport.ExtentFactory;
import alfatkg.factories.WaitFactory;
import alfatkg.utils.DynamicXpath;
import alfatkg.utils.FakerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class GPNHomePage extends PageActions {

    private static final String TOOLBAR_ICONS_DYNAMIC_LOCATOR = "(//div//ul[@class='toolbar']//*[@title='%s'])[1]";
    private static final String MODES_LIST = "((//p-dropdown)[1]//span[contains(text(),'Mode') or contains(text(),'Plan')])[%s]";

    private static final By ICON_HOME = By.xpath("//*[@class='menu-item pi pi-home']");
    private static final By ICON_SCANNER = By.xpath("//*[@class='glyphicon glyphicon-barcode']/parent::button");
    private static final By DIALOG_SCANNER = By.xpath(("//*[.='Barcode Scan']"));
    private static final By DATE_PICKER_FROM_DATE = By.xpath("(//app-ui-daterangepicker[1]//input)[1]");
    private static final By DATE_PICKER_TO_DATE = By.xpath("(//app-ui-daterangepicker[1]//input)[2]");
    private static final By SVG_PROGRESSBAR = By.xpath("(//*[name()='svg']//*[name()='circle'])[1]");
    private static final By ICON_AI_REPORT = By.xpath(DynamicXpath.xpath(TOOLBAR_ICONS_DYNAMIC_LOCATOR, "Reports"));
    private static final By ICON_ADD_MO = By.xpath(DynamicXpath.xpath(TOOLBAR_ICONS_DYNAMIC_LOCATOR, "Add MO"));
    private static final By DROPDOWN_MODE_LIST = By.xpath("(//p-dropdown)[1]");
    private static final By NUMBER_OF_MODES = By.xpath("(//p-dropdown)[1]//*[contains(text(),'Mode') or contains(text(),'Plan')]");

    public AlfaDOCKHomePage clickHomeIcon() {
        customClick(ICON_HOME, "home icon");
        switchToTab(FrameworkConstants.getALFADOCK_TITLE());
        return new AlfaDOCKHomePage();
    }

    public GPNHomePage clickScannerIcon() {
        customClick(ICON_SCANNER, "scanner icon");
        return new GPNHomePage();
    }

    public Boolean isScannerDialogDisplayed() {
        return isElementDisplayed(WaitStrategy.VISIBLE, DIALOG_SCANNER);
    }

    public void pickFromAndToDate() {
        Map<String, String> fromDateAndToDate = FakerUtils.getFromDateAndToDate();
        customClearText(DATE_PICKER_FROM_DATE);
        customSendKeys(DATE_PICKER_FROM_DATE, "00" + fromDateAndToDate.get("fromDate"), "from date");
        WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
        customClearText(DATE_PICKER_TO_DATE);
        customSendKeys(DATE_PICKER_TO_DATE, "00" + fromDateAndToDate.get("toDate"), "to date");
        WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
    }

    public void clickAiReportIcon() {
        customClick(ICON_AI_REPORT, "AI report icon");
        WaitFactory.wait(a -> a.until(ExpectedConditions.titleIs(FrameworkConstants.getAI_REPORT_TITLE())));
    }

    public AddMOItemAndProcess clickAddMOButton() {
        customClick(ICON_ADD_MO, "add mo");
        return new AddMOItemAndProcess();
    }

    public void switchBetweenTheModes() {
        try {
            WaitFactory.wait(a -> a.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NUMBER_OF_MODES)));
        } catch (Exception e) {
            ExtentFactory.log(Logs.INFO, "The multiple modes are not enabled for the this customers");
        }
        int numberOfModes = DriverManger.getDriver().findElements(NUMBER_OF_MODES).size();
        ExtentFactory.log(Logs.INFO, "There is : " + numberOfModes + " modes Enabled in the GPN");
        for (int i = 1; i <= numberOfModes; i++) {
            WaitFactory.wait(a -> a.until(ExpectedConditions.invisibilityOfElementLocated(SVG_PROGRESSBAR)));
            customClick(DROPDOWN_MODE_LIST, "modesDropdown");
            customClick(By.xpath(DynamicXpath.xpath(MODES_LIST, String.valueOf(i))), "ModeList");
        }
    }

}
