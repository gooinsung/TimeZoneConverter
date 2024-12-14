package examples;

import zone.ZoneDateTimeConverter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeConverterExample {
    public static void main(String[] args) {
        convertStringToZonedDateTime();
        changeZoneId();
    }

    public static void changeZoneId() {
        ZoneDateTimeConverter converter = new ZoneDateTimeConverter();
        ZonedDateTime seoulZonedDateTime = converter.makeZonedDateTime("2024-12-09 15:30:45 +0900");

        ZonedDateTime newYorkZonedDateTime = ZoneDateTimeConverter.toZone(seoulZonedDateTime, ZoneId.of("America/New_York"));
        System.out.println("Seoul ZonedDateTime : " + seoulZonedDateTime);
        System.out.println("NewYork ZonedDateTime : " + newYorkZonedDateTime);
    }

    public static void convertStringToZonedDateTime() {
        String date = "2024-12-09 15:30:45 +0900";

        ZoneDateTimeConverter converter = new ZoneDateTimeConverter();

        ZonedDateTime seoulZonedDateTime = converter.makeZonedDateTime(date);

        converter.changeZone("America/New_York");

        ZonedDateTime newYorkZonedDateTime = converter.makeZonedDateTime(date);

        System.out.println("Seoul ZonedDateTime : " + seoulZonedDateTime);
        System.out.println("NewYork ZonedDateTime : " + newYorkZonedDateTime);
    }
}
