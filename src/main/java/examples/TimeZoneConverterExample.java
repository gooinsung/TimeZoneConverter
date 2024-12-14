package examples;

import zonedDateTime.TimeZoneConverter;

import java.time.ZonedDateTime;

public class TimeZoneConverterExample {
    public static void main(String[] args) {
        convertStringToZonedDateTimeWithOutFormat();
        getZoneConvertedString();
    }

    public static void convertStringToZonedDateTimeWithOutFormat() {
        String date = "2024-12-09 15:30:45 +0900";
        String originTimeZone = "Asia/Seoul";
        String targetTimeZone = "America/New_York";

        ZonedDateTime zonedDateTime = TimeZoneConverter.zonedDateTimeConvert(date, originTimeZone, targetTimeZone);

        System.out.println("Seoul time '" + date + "' to NewYork time : " + zonedDateTime);
    }

    public static void getZoneConvertedString() {
        String date = "2024-12-09 15:30:45 +0900";
        String originTimeZone = "Asia/Seoul";
        String targetTimeZone = "America/New_York";
        String targetFormat = "yy/MM/dd HH:mm:ss Z";

        String convertedDate = TimeZoneConverter.convertToFormattedString(date, originTimeZone, targetTimeZone, targetFormat);

        System.out.println("Seoul time '" + date + "' to NewYork time target format String : " + convertedDate);
    }
}
