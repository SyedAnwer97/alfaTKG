package alfatkg.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private static int count = 0;
    private static final int retryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        boolean value = false;
        value = count < retryCount;
        count++;
        return value;
    }
}
