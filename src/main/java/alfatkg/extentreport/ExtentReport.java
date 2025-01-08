package alfatkg.extentreport;

import alfatkg.consant.FrameworkConstants;
import alfatkg.enums.PropertyKey;
import alfatkg.utils.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Objects;

public class ExtentReport {

    private ExtentReport() {
    }

    private static ExtentReports extentReports;
    private static ExtentSparkReporter extentSparkReporter;

    public static void initReport() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            extentSparkReporter = new ExtentSparkReporter(new File(FrameworkConstants.getEXTENT_TEST_REPORT_PATH()));
            setReportProperties();
            extentReports.attachReporter(extentSparkReporter);
            extentReports.setSystemInfo("Executed on OS & Java: ", System.getProperty("os.name") + " Java : " + System.getProperty("java.version"));
            extentReports.setSystemInfo("Executed on Environment: ", ReadConfig.getProperty(PropertyKey.URL));
            extentReports.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
        }
    }

    public static void createTest(String testName) {
        ExtentTest test = extentReports.createTest(testName);
        ExtentManager.setExtentTest(test);
    }


    public static void flushReport() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
            ExtentManager.extentTestUnload();
        }
    }

    private static void setReportProperties() {
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("GPN Test Report");
        extentSparkReporter.config().setReportName("GPN Automation Report");
        extentSparkReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
    }

}