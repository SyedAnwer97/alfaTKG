package alfatkg.listeners;

import alfatkg.enums.Logs;
import alfatkg.extentreport.ExtentFactory;
import alfatkg.extentreport.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.log(Logs.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentFactory.log(Logs.FAIL_SCREENSHOT, result.getMethod().getMethodName() + " FAILED");
        ExtentFactory.logThrowable(Logs.THROWABLE, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentFactory.log(Logs.SKIP, result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }
}
