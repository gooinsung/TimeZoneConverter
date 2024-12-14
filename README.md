# TimeZoneConverter

## 개요
타임존에 관련된 편의 기능을 제공하는 라이브러리 입니다.
크게 3개의 클래스로 구성되어 있으며

1. StringDateConverter : String 으로 된 date time 을 LocalDateTime 객체로 변환합니다.(자주 사용되는 format은 기본 제공으로 format 입력 없이도 사용이 가능합니다.)
2. ZoneDateTimeConverter : 설정해둔 TimeZone(ZoneId) 을 기준으로 String, LocalDateTime, Instant, Timestamp 객체를 ZonedDateTime 객체로 변환합니다.
3. TimeZoneConverter : Origin time zone 에서의 date time 시간을 Target time zone 의 동시간대 ZonedDateTime 객체로 변환합니다.



## 사용법

1. gradle
```
repositories{
  maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.gooinsung:TimeZoneConverter:Tag'
}
```

2. maven
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.gooinsung</groupId>
	    <artifactId>TimeZoneConverter</artifactId>
	    <version>Tag</version>
	</dependency>
```

의존성 설정 이후
ZoneDateTimeConverter 는 생성 시 String timeZone 이나 ZoneId zone 을 주입받아 사용합니다. 기본 생성자로 생성 시 DEFAULT_TIME_ZONE = "Asia/Seoul" 타임존을 사용합니다.
```
        ZoneDateTimeConverter converter = new ZoneDateTimeConverter();
        ZonedDateTime seoulZonedDateTime = converter.makeZonedDateTime("2024-12-09 15:30:45 +0900");

        ZonedDateTime newYorkZonedDateTime = ZoneDateTimeConverter.toZone(seoulZonedDateTime, ZoneId.of("America/New_York"));
        System.out.println("Seoul ZonedDateTime : " + seoulZonedDateTime);
        System.out.println("NewYork ZonedDateTime : " + newYorkZonedDateTime);
```

StringDateConverter
```
        String date = "2024-12-09 15:30:45 +0900";

        LocalDateTime convertedLocalDateTime = StringDateConverter.getLocalDateTime(date);
        System.out.println("ConvertedLocalDateTime : " + convertedLocalDateTime);
```

TimeZoneConverter

```
        String date = "2024-12-09 15:30:45 +0900";
        String originTimeZone = "Asia/Seoul";
        String targetTimeZone = "America/New_York";

        ZonedDateTime zonedDateTime = TimeZoneConverter.zonedDateTimeConvert(date, originTimeZone, targetTimeZone);

        System.out.println("Seoul time '" + date + "' to NewYork time : " + zonedDateTime);
```
