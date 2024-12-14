package examples;

import date.StringDateConverter;

import java.time.LocalDateTime;

public class StringDateConverterExample {
    public static void main(String[] args) {
        withOutFormat();
        withFormat();
    }

    public static void withOutFormat() {
        String date = "2024-12-09 15:30:45 +0900";

        LocalDateTime convertedLocalDateTime = StringDateConverter.getLocalDateTime(date);
        System.out.println("ConvertedLocalDateTime : " + convertedLocalDateTime);
    }

    public static void withFormat(){
        String date = "2024-12-09 15:30:45 +0900";
        String format = "yyyy-MM-dd HH:mm:ss Z";

        LocalDateTime convertedLocalDateTime = StringDateConverter.getLocalDateTime(date, format);
        System.out.println("ConvertedLocalDateTime : " + convertedLocalDateTime);
    }
}
