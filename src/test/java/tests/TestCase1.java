package tests;

import alfatkg.consant.FrameworkConstants;
import alfatkg.driver.DriverManger;
import alfatkg.facade.LoginAndNavigateToGPN;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestCase1 extends BaseClass {

    @Test()
    public void homeIconNavigationTest() {
        new LoginAndNavigateToGPN().loginToGPN().clickHomeIcon();
        Assertions.assertThat(DriverManger.getDriver().getWindowHandles().size()).isGreaterThan(1).isLessThan(3);
        Assertions.assertThat(DriverManger.getDriver().getTitle()).isEqualToIgnoringCase(FrameworkConstants.getALFADOCK_TITLE());
    }

    @Test
    public void scannerCameraPopupTest() {
        boolean isScannerDialogDisplayed = new LoginAndNavigateToGPN().loginToGPN().clickScannerIcon().isScannerDialogDisplayed();
        Assertions.assertThat(isScannerDialogDisplayed).isTrue();
    }

    @Test
    public void selectDateRangeTest() {
        new LoginAndNavigateToGPN().loginToGPN().pickFromAndToDate();
    }

    @Test
    public void aiReportNavigation() {
        new LoginAndNavigateToGPN().loginToGPN().clickAiReportIcon();
        Assertions.assertThat(DriverManger.getDriver().getTitle()).isEqualToIgnoringCase(FrameworkConstants.getAI_REPORT_TITLE());
    }

}