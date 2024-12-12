package format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class FormatConverter {
    private FormatConverter() {}

    private static final List<String> GENERAL_FORMAT_LIST = List.of(
            "yyyy-MM-dd HH:mm:ss",      // 예: 2024-12-09 15:30:45
            "yyyy-MM-dd HH:mm:ss Z",    // 예: 2024-12-09 15:30:45 +0900
            "yyyy-MM-dd HH:mm:ss z",    // 예: 2024-12-09 15:30:45 KST
            "yyyy-MM-dd'T'HH:mm:ssX",   // 예: 2024-12-09T15:30:45+09
            "yyyy-MM-dd HH:mm:ss ZZZZ", // 예: 2024-12-09 15:30:45 GMT+09:00
            "yyyy-MM-dd HH:mm:ss O",    // 예: 2024-12-09 15:30:45 UTC+09:00
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ", // 예: 2024-12-09T15:30:45.123+0900
            "yyyy-MM-dd HH:mm:ss.SSS z", // 예: 2024-12-09 15:30:45.123 KST
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", // 예: 2024-12-09T15:30:45.123+09:00
            "yyyy-MM-dd HH:mm:ss.SSS O"  // 예: 2024-12-09 15:30:45.123 UTC+09:00
    );

    public static LocalDateTime getLocalDateTime(String dateTime) {
        DateTimeFormatter formatter;
        LocalDateTime result = null;
        for (String format : GENERAL_FORMAT_LIST) {
            try {
                formatter = DateTimeFormatter.ofPattern(format);
                result = LocalDateTime.parse(dateTime, formatter);
                break;
            } catch (Exception e) {
                // do nothing
            }
        }
        if (Objects.isNull(result)) {
            throw new IllegalArgumentException("Not supported date format");
        }
        return result;
    }

    public static LocalDateTime getLocalDateTime(String dateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime, formatter);
    }
}
