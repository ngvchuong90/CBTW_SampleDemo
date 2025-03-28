package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
    public static String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.now().format(formatter);
    }
}
