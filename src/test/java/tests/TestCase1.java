package tests;

import alfatkg.pages.CustomerLoginPage;
import alfatkg.pages.UserLoginPage;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 extends BaseTest {

    @Test()
    public void DemoTest() {
        new CustomerLoginPage().customerLogin().userLogin();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    @Test()
    public void DemoTest2() {
        new CustomerLoginPage().customerLogin();
        new UserLoginPage().userLogin();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

}