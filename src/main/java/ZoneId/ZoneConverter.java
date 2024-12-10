package ZoneId;

import format.FormatConverter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneConverter {

    private ZoneId zone;

    /*
     * 원하는 타임존을 설정합니다.
     * */
    public ZoneConverter(String timeZone) {
        this.zone = getZone(timeZone);
    }

    public ZoneConverter(ZoneId zone) {
        this.zone = zone;
    }

    public void changeZone(String timeZone) {
        this.zone = getZone(timeZone);
    }

    public void changeZone(ZoneId zone) {
        this.zone = zone;
    }

    public ZoneId getZone(String zoneId) {
        return ZoneId.of(zoneId);
    }

    /*
     * 요청 객체를 설정해둔 timeZone 으로 설정된 ZonedDateTime 객체로 변환합니다.
     * */
    public ZonedDateTime getZonedDateTime(LocalDateTime localDateTime) {
        return ZonedDateTime.of(localDateTime, this.zone);
    }

    public ZonedDateTime getZonedDateTime(String dateTime) {
        return getZonedDateTime(FormatConverter.getLocalDateTime(dateTime));
    }

    public ZonedDateTime getZonedDateTime(Instant instant) {
        return instant.atZone(this.zone);
    }

    public ZonedDateTime getZonedDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime().atZone(this.zone);
    }

    /*
     * 해당 ZonedDateTime 객체의 타임존을 로컬 타임 기준으로 변경합니다.
     * */
    public ZonedDateTime changeTimeZone(ZonedDateTime zonedDateTime) {
        return zonedDateTime.withZoneSameLocal(this.zone);
    }

}
