package alfatkg.utils;

import alfatkg.consant.FrameworkConstants;
import alfatkg.enums.PropertyKey;
import alfatkg.exceptions.InvalidPathForPropertyFileException;
import alfatkg.exceptions.PropertyFileUsageException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public final class ReadConfig {

    private ReadConfig() {
    }

    private static final Properties properties = new Properties();
    private static final Properties systemProperties = System.getProperties();
    private static final HashMap<String, String> propertyMap = new HashMap<>();

    static {
        try (InputStream inputStream = ResourceLoader.getSource(FrameworkConstants.getPROPERTY_FILE_LOCATION())) {
            properties.load(inputStream);
            properties.forEach((key, value) -> propertyMap.put(String.valueOf(key).toLowerCase(),
                    String.valueOf(value).toLowerCase().trim()));
            for (Object key : systemProperties.keySet())
                if (propertyMap.containsKey(String.valueOf(key).toLowerCase()))
                    propertyMap.put(String.valueOf(key).toLowerCase(), systemProperties.getProperty(String.valueOf(key)));
        } catch (IOException e) {
            throw new InvalidPathForPropertyFileException("The file is not found specified location");
        }
    }

    public static String getProperty(PropertyKey propertyKey) {
        if (Objects.isNull(propertyMap.get(propertyKey.name().toLowerCase())))
            throw new PropertyFileUsageException("The key is not found in the specified property file");
        return propertyMap.get(propertyKey.name().toLowerCase());
    }

}