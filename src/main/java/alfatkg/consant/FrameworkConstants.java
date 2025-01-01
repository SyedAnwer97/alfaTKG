package alfatkg.consant;

public class FrameworkConstants {

    private static final String PROPERTY_FILE_LOCATION = "property/config.properties";
    private static final String REMOTE = "remote";

    public static String getPropertyFileLocation() {
        return PROPERTY_FILE_LOCATION;
    }

    public static String getRemote() {
        return REMOTE;
    }
}
