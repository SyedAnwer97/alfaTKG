package alfatkg.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        int retryCount = 1;
        boolean value;
        value = count < retryCount;
        count++;
        return value;
    }

}