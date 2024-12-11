package zoneId;

import org.junit.jupiter.api.Test;
import zone.ZoneDateTimeConverter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZoneDateTimeConverterTest {

    @Test
    void createZoneDateTimeConverterTest() {
        // given
        String newYorkTimeZone = "America/New_York";
        ZoneId seoulZoneId = ZoneDateTimeConverter.makeZoneId("Asia/Seoul");
        ZoneId newYorkZoneId = ZoneDateTimeConverter.makeZoneId(newYorkTimeZone);
        // when
        ZoneDateTimeConverter zoneDateTimeConverterWithNoArgument = new ZoneDateTimeConverter();
        ZoneDateTimeConverter zoneDateTimeConverterWithArgument = new ZoneDateTimeConverter(newYorkZoneId);
        ZoneDateTimeConverter zoneDateTimeConverterWithStringArgument = new ZoneDateTimeConverter(newYorkTimeZone);
        // then
        assertEquals(zoneDateTimeConverterWithNoArgument.getZone(), seoulZoneId);
        assertEquals(zoneDateTimeConverterWithArgument.getZone(), newYorkZoneId);
        assertEquals(zoneDateTimeConverterWithStringArgument.getZone(), newYorkZoneId);
    }

    @Test
    void getZoneTest() {
        // given
        ZoneDateTimeConverter zoneDateTimeConverterWithNoArgument = new ZoneDateTimeConverter();
        ZoneDateTimeConverter zoneDateTimeConverterWithArgument = new ZoneDateTimeConverter("America/New_York");
        // when
        ZoneId noArgumentZone = zoneDateTimeConverterWithNoArgument.getZone();
        ZoneId argumentZone = zoneDateTimeConverterWithArgument.getZone();
        // then
        assertEquals(noArgumentZone, ZoneDateTimeConverter.makeZoneId("Asia/Seoul"));
        assertEquals(argumentZone, ZoneDateTimeConverter.makeZoneId("America/New_York"));
    }

    @Test
    void makeZoneIdTest() {
        // given
        String newYorkTimeZone = "America/New_York";
        // when
        ZoneId zoneId = ZoneDateTimeConverter.makeZoneId(newYorkTimeZone);
        // then
        assertEquals(zoneId, ZoneId.of(newYorkTimeZone));
    }

    @Test
    void changeZoneTest() {
        // given
        String newYorkTimeZone = "America/New_York";
        ZoneId newYorkZoneId = ZoneDateTimeConverter.makeZoneId(newYorkTimeZone);
        // when
        ZoneDateTimeConverter zoneDateTimeConverter = new ZoneDateTimeConverter();
        zoneDateTimeConverter.changeZone(newYorkZoneId);
        // then
        assertEquals(zoneDateTimeConverter.getZone(), newYorkZoneId);
    }

    @Test
    void changeTimeZone(){
        // given
        ZoneDateTimeConverter seoulZoneDateTimeConverter = new ZoneDateTimeConverter();
        ZonedDateTime zonedDateTime = seoulZoneDateTimeConverter.makeZonedDateTime("2024-12-09 15:30:45");

        ZoneDateTimeConverter newYorkZoneDateTimeConverter = new ZoneDateTimeConverter("America/New_York");
        // when
        zonedDateTime = newYorkZoneDateTimeConverter.changeTimeZone(zonedDateTime);
        // then
        assertEquals(newYorkZoneDateTimeConverter.getZone(), zonedDateTime.getZone());
    }

    @Test
    void toZoneTest() {
        // given
        ZoneDateTimeConverter zoneDateTimeConverter = new ZoneDateTimeConverter();
        ZonedDateTime zonedDateTime = zoneDateTimeConverter.makeZonedDateTime("2024-12-09 15:30:45");
        ZoneId newYorkZoneId = ZoneDateTimeConverter.makeZoneId("America/New_York");
        // when
        zonedDateTime = ZoneDateTimeConverter.toZone(zonedDateTime, newYorkZoneId);
        // then
        assertEquals(zonedDateTime.getZone(), newYorkZoneId);
    }

    @Test
    void makeZonedDateTimeTest() {
        // given
        ZoneDateTimeConverter converter = new ZoneDateTimeConverter();

        String dateTime = "2024-12-09 15:30:45";
        LocalDateTime localDateTime = LocalDateTime.of(2024, 12, 9, 15, 30, 45);
        Instant instant = Instant.ofEpochSecond(1234567890);
        Timestamp timestamp = Timestamp.valueOf("2024-12-09 15:30:45");
        // when
        ZonedDateTime stringZonedDateTime = converter.makeZonedDateTime(dateTime);
        ZonedDateTime localDateTimeZonedDateTime = converter.makeZonedDateTime(localDateTime);
        ZonedDateTime instantZonedDateTime = converter.makeZonedDateTime(instant);
        ZonedDateTime timestampZonedDateTime = converter.makeZonedDateTime(timestamp);
        // then
        assertEquals(stringZonedDateTime, ZonedDateTime.of(localDateTime, converter.getZone()));
        assertEquals(localDateTimeZonedDateTime, ZonedDateTime.of(localDateTime, converter.getZone()));
        assertEquals(instantZonedDateTime, instant.atZone(converter.getZone()));
        assertEquals(timestampZonedDateTime, timestamp.toLocalDateTime().atZone(converter.getZone()));
    }

}
