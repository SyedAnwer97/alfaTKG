package alfatkg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {

    public static InputStream getSource(String path) {
        InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if (Objects.nonNull(inputStream)) return inputStream;
        try {
            return Files.newInputStream(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
