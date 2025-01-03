package tests;

import alfatkg.enums.Logs;
import alfatkg.extentreport.ExtentFactory;
import alfatkg.pages.CustomerLoginPage;
import alfatkg.pages.UserLoginPage;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 extends BaseTest {

    @Test()
    public void DemoTest() {
        new CustomerLoginPage().customerLogin().userLogin();
        ExtentFactory.log(Logs.INFO, "this is test 1");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    @Test()
    public void DemoTest2() {
        new CustomerLoginPage().customerLogin();
        ExtentFactory.log(Logs.INFO, "this is test 2");
        new UserLoginPage().userLogin();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

}