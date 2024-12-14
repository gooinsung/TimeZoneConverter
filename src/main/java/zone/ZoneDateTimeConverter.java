package zone;

import date.StringDateConverter;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
* String, Timestamp, Instant 객체를 원하는 ZoneId의 ZonedDateTime 객체로 손쉽게 변환하기 위한 클래스
* */
public class ZoneDateTimeConverter {

    private ZoneId zone;
    private final String DEFAULT_TIME_ZONE = "Asia/Seoul";

    /*
     * 원하는 타임존을 설정합니다.
     * */
    public ZoneDateTimeConverter(String timeZone) {
        this.zone = getZone(timeZone);
    }

    public ZoneDateTimeConverter(ZoneId zone) {
        this.zone = zone;
    }

    /*
    * Default time zone 으로 초기화.
    * */
    public ZoneDateTimeConverter() {
        this.zone = ZoneId.of(DEFAULT_TIME_ZONE);
    }

    /*
    * 해당 객체의 ZoneId 를 변경.
    * */
    public void changeZone(String timeZone) {
        this.zone = getZone(timeZone);
    }

    public void changeZone(ZoneId zone) {
        this.zone = zone;
    }

    /*
    * 해당 객체의 ZoneId 를 반환.
    * */
    private ZoneId getZone(String zoneId) {
        return ZoneId.of(zoneId);
    }

    public static ZoneId makeZoneId(String zoneId) {
        return ZoneId.of(zoneId);
    }

    public ZoneId getZone() {
        return this.zone;
    }

    /*
     * 요청 객체를 설정해둔 timeZone 으로 설정된 ZonedDateTime 객체로 변환합니다.
     * */
    public ZonedDateTime makeZonedDateTime(LocalDateTime localDateTime) {
        return ZonedDateTime.of(localDateTime, this.zone);
    }

    public ZonedDateTime makeZonedDateTime(String dateTime) {
        return makeZonedDateTime(StringDateConverter.getLocalDateTime(dateTime));
    }

    public ZonedDateTime makeZonedDateTime(Instant instant) {
        return instant.atZone(this.zone);
    }

    public ZonedDateTime makeZonedDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime().atZone(this.zone);
    }

    /*
     * 해당 ZonedDateTime 객체의 타임존을 로컬 타임 기준으로 변경합니다.
     * */
    public ZonedDateTime changeTimeZone(ZonedDateTime zonedDateTime) {
        return zonedDateTime.withZoneSameLocal(this.zone);
    }

    public static ZonedDateTime toZone(ZonedDateTime zonedDateTime, ZoneId targetZoneId) {
        return zonedDateTime.withZoneSameLocal(targetZoneId);
    }

}
