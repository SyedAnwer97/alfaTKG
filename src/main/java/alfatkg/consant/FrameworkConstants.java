package alfatkg.consant;

public class FrameworkConstants {

    private static final String PROPERTY_FILE_LOCATION = "property/config.properties";
    private static final String REMOTE = "remote";
    private static final String EXTENT_TEST_REPORT_PATH = "extent-test-output/index.html";

    public static String getExtentTestReportPath() {
        return EXTENT_TEST_REPORT_PATH;
    }

    public static String getPropertyFileLocation() {
        return PROPERTY_FILE_LOCATION;
    }

    public static String getRemote() {
        return REMOTE;
    }
}
