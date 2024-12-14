package zonedDateTime;

import date.StringDateConverter;
import zone.ZoneDateTimeConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    private TimeZoneConverter() {}

    /*
    * String 으로 된 dateTime 을 ZonedDateTime 으로 변환
    * */
    public static ZonedDateTime zonedDateTimeConvert(String dateTime, String originFormat, String originTimeZone, String targetTimeZone) {
        LocalDateTime originLocalDateTime = StringDateConverter.getLocalDateTime(dateTime, originFormat);

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
        LocalDateTime originLocalDateTime = StringDateConverter.getLocalDateTime(dateTime);

        return zonedDateTimeConvert(ZonedDateTime.of(originLocalDateTime, originZoneId), targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(LocalDateTime localDateTime, ZoneId originZoneId, ZoneId targetZoneId) {
        ZonedDateTime originZonedDateTime = ZonedDateTime.of(localDateTime, originZoneId);

        return zonedDateTimeConvert(originZonedDateTime, targetZoneId);
    }

    public static ZonedDateTime zonedDateTimeConvert(ZonedDateTime zonedDateTime, ZoneId targetZone) {
        return zonedDateTime.withZoneSameInstant(targetZone);
    }

}
