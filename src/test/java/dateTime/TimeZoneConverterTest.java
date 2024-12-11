package dateTime;

import org.junit.jupiter.api.Test;
import zonedDateTime.TimeZoneConverter;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class TimeZoneConverterTest {

    @Test
    void zonedDateTimeConvertTest(){
        // given
        String date = "2024-12-09 15:30:45 +0900";
        String originFormat = "yyyy-MM-dd HH:mm:ss Z";
        String originTimeZone = "Asia/Seoul";
        String targetZone = "America/New_York";
        // when
        ZonedDateTime result = TimeZoneConverter.zonedDateTimeConvert(date, originFormat, originTimeZone, targetZone);
        // then
        assertEquals(result.getZone().toString(), targetZone);
        assertEquals(result.getYear(), 2024);
        assertEquals(result.getMonthValue(), 12);
        assertEquals(result.getDayOfMonth(), 9);
        assertEquals(result.getHour(), 1);
        assertEquals(result.getMinute(), 30);
        assertEquals(result.getSecond(), 45);
        assertEquals(result.getOffset().getId(), "-05:00");
    }

    @Test
    void convertToFormattedStringTest(){
        // given
        String date = "2024-12-09 15:30:45 +0900";
        String originTimeZone = "Asia/Seoul";
        String targetTimeZone = "America/New_York";
        String targetFormat = "yy/MM/dd HH:mm:ss Z";
        // when
        String result = TimeZoneConverter.convertToFormattedString(date, originTimeZone, targetTimeZone, targetFormat);
        // then
        assertEquals(result, "24/12/09 01:30:45 -0500");
    }
}
