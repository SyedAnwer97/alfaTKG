package tests;

import alfatkg.consant.FrameworkConstants;
import alfatkg.driver.DriverManger;
import alfatkg.facade.LoginAndNavigateToGPN;
import alfatkg.pages.GPNHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void aiReportNavigationTest() {
        new LoginAndNavigateToGPN().loginToGPN().clickAiReportIcon();
        Assertions.assertThat(DriverManger.getDriver().getTitle()).isEqualToIgnoringCase(FrameworkConstants.getAI_REPORT_TITLE());
    }

    @Test
    public void addMoTest() {
        new LoginAndNavigateToGPN().loginToGPN().clickAddMOButton().addMO().addMOItem();
    }

    @Test(dataProvider = "testData")
    public void gpnAllModesLoadingTest(Map<String, String> data) {
        new LoginAndNavigateToGPN().loginToGPN(data, GPNHomePage.class).switchBetweenTheModes();
    }

    @DataProvider(parallel = true)
    public static Object[] testData() {
        Map<String, String> unozawa = Map.of("customerName", "unozawa", "password", "unozawa", "username", "admin", "userpass", "admin");
        Map<String, String> nakanoya = Map.of("customerName", "nakanoya", "password", "nakanoya", "username", "admin", "userpass", "admin", "landingpage", "GPN");
        Map<String, String> tanakasangyo = Map.of("customerName", "tanakasangyo", "password", "9771836", "username", "admin", "userpass", "service701");
        Map<String, String> yoshimi = Map.of("customerName", "yoshimi", "password", "yoshimi", "username", "admin", "userpass", "service701");
        Map<String, String> akaishik = Map.of("customerName", "akaishik", "password", "7586", "username", "admin", "userpass", "admin");
        Map<String, String> sunrise = Map.of("customerName", "sr", "password", "20", "username", "admin", "userpass", "admin");
        Map<String, String> uni = Map.of("customerName", "uni", "password", "7241", "username", "admin", "userpass", "admin");
        Map<String, String> asuna = Map.of("customerName", "asuna", "password", "123", "username", "admin", "userpass", "service701");
        Map<String, String> ohashi = Map.of("customerName", "ohashi", "password", "ohashi1916", "username", "admin", "userpass", "admin");
        Map<String, String> sds = Map.of("customerName", "sds", "password", "0037", "username", "admin", "userpass", "admin");
        Map<String, String> eiwakiko = Map.of("customerName", "eiwakiko", "password", "Reborn-eiwa", "username", "admin", "userpass", "admin");
        Map<String, String> kurosaka = Map.of("customerName", "kurosaka", "password", "kurosaka123", "username", "admin", "userpass", "admin");

        Map<String, String> okabe = Map.of("customerName", "okabe", "password", "okabe123", "username", "admin", "userpass", "admin");
        Map<String, String> kms = Map.of("customerName", "kms01", "password", "j2019imr", "username", "AlfaTKG", "userpass", "AD15a18", "landingpage", "GPN");
        Map<String, String> axis = Map.of("customerName", "axis", "password", "axis10061952", "username", "admin", "userpass", "admin");
        Map<String, String> MakabeA = Map.of("customerName", "Makabe-A", "password", "makabea123", "username", "admin", "userpass", "admin");
        Map<String, String> MakabeI = Map.of("customerName", "Makabe-I", "password", "makabei123", "username", "admin", "userpass", "admin");
        Map<String, String> Nakagawa = Map.of("customerName", "Nakagawa", "password", "nakagawa12345", "username", "admin", "userpass", "service701");
        Map<String, String> oaksystem = Map.of("customerName", "oaksystem", "password", "oak123", "username", "admin", "userpass", "service701");
        Map<String, String> TSTanaka = Map.of("customerName", "TS-Tanaka", "password", "tanaka123", "username", "admin", "userpass", "admin");
        Map<String, String> Ohkuma = Map.of("customerName", "Ohkuma", "password", "ohkuma123", "username", "admin", "userpass", "admin");
        Map<String, String> hayashi = Map.of("customerName", "hayashi-mfg", "password", "hys884", "username", "backupsocket ", "userpass", "service701 ");
        Map<String, String> REFORCE = Map.of("customerName", "RE.FORCE", "password", "re.force123", "username", "admin ", "userpass", "admin");
        Map<String, String> fujipro = Map.of("customerName", "fujipro ", "password", "fujiprotec123", "username", "admin ", "userpass", "admin3102");
        Map<String, String> AOKI = Map.of("customerName", "AOKI ", "password", "m-aoki123", "username", "admin ", "userpass", "service701");
        Map<String, String> araki = Map.of("customerName", "araki ", "password", "arakis", "username", "admin ", "userpass", "admin");
        Map<String, String> masuda = Map.of("customerName", "masuda ", "password", "masuda2086", "username", "admin ", "userpass", "admin");
        Map<String, String> kygiken = Map.of("customerName", "kygiken ", "password", "0430", "username", "admin ", "userpass", "admin");
        Map<String, String> kyoei = Map.of("customerName", "kyoei-k ", "password", "kyoei5304", "username", "admin ", "userpass", "admin");
        Map<String, String> morokumass = Map.of("customerName", "morokumass ", "password", "S34730", "username", "admin ", "userpass", "admin");
        Map<String, String> arcadia = Map.of("customerName", "arcadia ", "password", "arcadia0034", "username", "admin ", "userpass", "admin");
        Map<String, String> nasa = Map.of("customerName", "nasa  ", "password", "nasa123", "username", "admin ", "userpass", "7373admin");

        List<Map<String, String>> data = new ArrayList<>();
        data.add(unozawa);
        data.add(nakanoya);
        data.add(tanakasangyo);
        data.add(yoshimi);
        data.add(akaishik);
        data.add(sunrise);
        data.add(uni);
        data.add(asuna);
        data.add(ohashi);
        data.add(sds);
        data.add(eiwakiko);
        data.add(kurosaka);

        data.add(okabe);
        data.add(kms);
        data.add(axis);
        data.add(MakabeA);
        data.add(MakabeI);
        data.add(Nakagawa);
        data.add(oaksystem);
        data.add(TSTanaka);
        data.add(Ohkuma);
        data.add(hayashi);
        data.add(REFORCE);
        data.add(fujipro);
        data.add(AOKI);
        data.add(araki);
        data.add(masuda);
        data.add(kygiken);
        data.add(kyoei);
        data.add(morokumass);
        data.add(arcadia);
        data.add(nasa);
        return data.toArray();
    }

}