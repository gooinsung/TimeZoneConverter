package zonedDateTime;

import format.FormatConverter;
import zone.ZoneDateTimeConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {
    private TimeZoneConverter() {}

    public static ZonedDateTime zonedDateTimeConvert(String dateTime, String originFormat, String originTimeZone, String targetTimeZone) {
        LocalDateTime originLocalDateTime = FormatConverter.getLocalDateTime(dateTime, originFormat);

        ZoneId originZoneId = ZoneDateTimeConverter.makeZoneId(originTimeZone);
        ZoneId targetZoneId = ZoneDateTimeConverter.makeZoneId(targetTimeZone);

        return zonedDateTimeConvert(originLocalDateTime, originZoneId, targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(String dateTime, String originTimeZone, String targetTimeZone) {

        ZoneId originZoneId = ZoneDateTimeConverter.makeZoneId(originTimeZone);
        ZoneId targetZoneId = ZoneDateTimeConverter.makeZoneId(targetTimeZone);

        return zonedDateTimeConvert(dateTime, originZoneId, targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(LocalDateTime localDateTime, String originTimeZone, String targetTimeZone) {

        ZoneId originZoneId = ZoneDateTimeConverter.makeZoneId(originTimeZone);
        ZoneId targetZoneId = ZoneDateTimeConverter.makeZoneId(targetTimeZone);

        return zonedDateTimeConvert(localDateTime, originZoneId, targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(String dateTime, ZoneId originZoneId, ZoneId targetZoneId) {

        LocalDateTime originLocalDateTime = FormatConverter.getLocalDateTime(dateTime);

        return zonedDateTimeConvert(ZonedDateTime.of(originLocalDateTime, originZoneId), targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(LocalDateTime localDateTime, ZoneId originZoneId, ZoneId targetZoneId) {
        ZonedDateTime originZonedDateTime = ZonedDateTime.of(localDateTime, originZoneId);
        return zonedDateTimeConvert(originZonedDateTime, targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(ZonedDateTime zonedDateTime, ZoneId targetZone) {
        return zonedDateTime.withZoneSameInstant(targetZone);
    }

    public static String convertToFormattedString(String dateTime, String originTimeZone, String targetTimeZone, String targetFormat) {
        LocalDateTime originLocalDateTime = FormatConverter.getLocalDateTime(dateTime);
        ZonedDateTime convertedZonedDateTime = zonedDateTimeConvert(originLocalDateTime, originTimeZone, targetTimeZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(targetFormat);
        return formatter.format(convertedZonedDateTime);
    }

}
