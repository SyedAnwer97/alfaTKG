package alfatkg.extentreport;

import alfatkg.enums.Logs;
import alfatkg.utils.ScreenShotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import java.util.EnumMap;
import java.util.function.Consumer;

public final class ExtentFactory {

    private ExtentFactory() {
    }

    private static final EnumMap<Logs, Consumer<String>> map = new EnumMap<>(Logs.class);
    private static final EnumMap<Logs, Consumer<Throwable>> THROWABLE_HASH_MAP = new EnumMap<>(Logs.class);

    private static final Consumer<String> PASS = logText -> ExtentManager.getExtentTest().log(Status.PASS, logText);
    private static final Consumer<String> FAIL = logText -> ExtentManager.getExtentTest().log(Status.FAIL, logText);
    private static final Consumer<String> SKIP = logText -> ExtentManager.getExtentTest().log(Status.SKIP, logText);
    private static final Consumer<String> INFO = logText -> ExtentManager.getExtentTest().log(Status.INFO, logText);
    private static final Consumer<String> FAIL_SCREENSHOT = logText -> ExtentManager.getExtentTest().log(Status.FAIL, MediaEntityBuilder
            .createScreenCaptureFromBase64String(ScreenShotUtils.getScreenShot()).build());
    private static final Consumer<Throwable> FAIL_EXCEPTION = exception -> ExtentManager.getExtentTest()
            .log(Status.FAIL, exception);

    static {
        map.put(Logs.PASS, PASS);
        map.put(Logs.FAIL, FAIL);
        map.put(Logs.SKIP, SKIP);
        map.put(Logs.INFO, INFO);
        map.put(Logs.FAIL_SCREENSHOT, FAIL.andThen(FAIL_SCREENSHOT));
        THROWABLE_HASH_MAP.put(Logs.THROWABLE, FAIL_EXCEPTION);
    }

    public static void log(Logs log, String logText) {
        map.get(log).accept(logText);
    }

    public static void logThrowable(Logs log, Throwable throwable) {
        THROWABLE_HASH_MAP.get(log).accept(throwable);
    }

}