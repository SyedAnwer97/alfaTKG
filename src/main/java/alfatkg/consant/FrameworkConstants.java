package alfatkg.consant;

import lombok.Getter;

public class FrameworkConstants {

    private FrameworkConstants() {
    }


    @Getter
    private static final String PROPERTY_FILE_LOCATION = "property/config.properties";
    @Getter
    private static final String REMOTE = "remote";
    @Getter
    private static final String EXTENT_TEST_REPORT_PATH = "extent-test-output/index.html";
    @Getter
    private static final String GPN_TITLE = "SI Scheduler";
    @Getter
    private static final String ALFADOCK_TITLE = "alfaDOCK";
    @Getter
    private static final String AI_REPORT_TITLE = "AiReport";
}