package alfatkg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ReadConfig {

    private static Properties properties = new Properties();

    public static String getProperty(String Key) {
        try {
            InputStream inputStream = ResourceLoader.getSource("propertyfile/config.properties");

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.get(Key).toString();
    }

}