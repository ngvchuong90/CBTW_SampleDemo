package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    public static String getConfigFilePath(String env) {
        String projectPath = System.getProperty("user.dir"); // Get project root
        return Paths.get(projectPath, "config", env + ".properties").toString(); // Auto-handles OS-specific separators
    }

    private static void loadProperties() {
        String env = System.getProperty("env", "qa"); // Default to "qa" if not provided
        String filePath = System.getProperty("user.dir") + "/config/" + env + ".properties";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
