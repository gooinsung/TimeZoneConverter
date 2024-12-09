package ZoneId;

import format.FormatConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneConverter {

    private ZoneId zone;

    public ZoneConverter(String timeZone) {
        this.zone = getZone(timeZone);
    }
    public ZoneConverter(ZoneId zone){
        this.zone = zone;
    }

    public ZoneId getZone(String zoneId) {
        return ZoneId.of(zoneId);
    }

    public ZonedDateTime getZonedDateTime(LocalDateTime localDateTime) {
        return ZonedDateTime.of(localDateTime, this.zone);
    }

    public ZonedDateTime getZonedDateTime(String dateTime) {
        return getZonedDateTime(FormatConverter.getLocalDateTime(dateTime));
    }




}
