package format;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormatConverterTest {

    private FormatConverter formatConverter = new FormatConverter();
    @Test
    void getLocalDateTimeTest() {
        // given
        List<String> formatPossibleDateList = List.of(
                "2024-12-09 15:30:45 +0900",
                "2024-12-09 15:30:45 KST",
                "2024-12-09T15:30:45+09",
                "2024-12-09 15:30:45 GMT+09:00",
                "2024-12-09 15:30:45 UTC+09:00",
                "2024-12-09T15:30:45.123+0900",
                "2024-12-09 15:30:45.123 KST",
                "2024-12-09T15:30:45.123+09:00",
                "2024-12-09 15:30:45.123 UTC+09:00"
        );
        // when
        List<LocalDateTime> formmatedDateList =
                formatPossibleDateList.stream()
                        .map(x -> {
                            return FormatConverter.getLocalDateTime(x);
                        })
                        .toList();
        // then
        assertEquals(formmatedDateList.size(), formatPossibleDateList.size());
    }

    @Test
    void notMatchedDateFormat() {
        // given
        String notMatchedFormat = "2024-12-09 15:30:45";

        // when
        // then
        assertThrows(NullPointerException.class, () -> {
            FormatConverter.getLocalDateTime(notMatchedFormat);
        });
    }
}
