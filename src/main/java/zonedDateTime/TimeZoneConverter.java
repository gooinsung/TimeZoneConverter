package zonedDateTime;

import format.FormatConverter;
import zoneId.ZoneDateTimeConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConverter {

    public ZonedDateTime zonedDateTimeConvert(String dateTime, String originFormat, String originTimeZone, String targetTimeZone) {
        LocalDateTime originLocalDateTime = FormatConverter.getLocalDateTime(dateTime, originFormat);

        ZoneDateTimeConverter zoneDateTimeConverter = new ZoneDateTimeConverter();

        ZoneId originZoneId = zoneDateTimeConverter.getZone(originTimeZone);
        ZoneId targetZoneId = zoneDateTimeConverter.getZone(targetTimeZone);

        return zonedDateTimeConvert(originLocalDateTime, originZoneId, targetZoneId);
    }

    public ZonedDateTime zonedDateTimeConvert(String dateTime, String originTimeZone, String targetTimeZone) {

        ZoneDateTimeConverter zoneConverter = new ZoneDateTimeConverter();

        ZoneId originZoneId = zoneConverter.getZone(originTimeZone);
        ZoneId targetZoneId = zoneConverter.getZone(targetTimeZone);

        return zonedDateTimeConvert(dateTime, originZoneId, targetZoneId);
    }

    public ZonedDateTime zonedDateTimeConvert(LocalDateTime localDateTime, String originTimeZone, String targetTimeZone) {
        ZoneDateTimeConverter zoneConverter = new ZoneDateTimeConverter();

        ZoneId originZoneId = zoneConverter.getZone(originTimeZone);
        ZoneId targetZoneId = zoneConverter.getZone(targetTimeZone);

        return zonedDateTimeConvert(localDateTime, originZoneId, targetZoneId);
    }

    public ZonedDateTime zonedDateTimeConvert(String dateTime, ZoneId originZoneId, ZoneId targetZoneId) {

        LocalDateTime originLocalDateTime = FormatConverter.getLocalDateTime(dateTime);

        return zonedDateTimeConvert(ZonedDateTime.of(originLocalDateTime, originZoneId), targetZoneId);
    }

    public ZonedDateTime zonedDateTimeConvert(LocalDateTime localDateTime, ZoneId originZoneId, ZoneId targetZoneId) {
        ZonedDateTime originZonedDateTime = ZonedDateTime.of(localDateTime, originZoneId);
        return zonedDateTimeConvert(originZonedDateTime, targetZoneId);
    }

    public ZonedDateTime zonedDateTimeConvert(ZonedDateTime zonedDateTime, ZoneId targetZone) {
        return zonedDateTime.withZoneSameLocal(targetZone);
    }

}
