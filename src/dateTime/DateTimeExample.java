package dateTime;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeExample {
    public static void main(String[] args) {
        // класс Date()
        Date date = new Date();
        Date other = new Date();
        date.after(other); // boolean
        date.before(other); // boolean
        date.compareTo(other); //int
        System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("такой вот день dd.MM+yyyy HH:mm");
        System.out.println(format.format(date));
        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = new GregorianCalendar(2019, Calendar.APRIL, 12);
        calendar1.add(Calendar.DAY_OF_MONTH, 2);
        calendar1.add(Calendar.MONTH, -2);
        System.out.println(calendar1.get(Calendar.MONTH));
        System.out.println(calendar1.getTime());

        // Java 8 Date Time API
        // LocalDate // для работы с датой
        // LocalTime // для работы со временем
        // LocalDateTime
        // Period промежуток дат
        // Duration промежуток времени
        System.out.println("Java 8 Date Time API");
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);
        LocalDate someDate = LocalDate.of(1981, Month.APRIL, 24);
        System.out.println(someDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String strDate = "14/04/2018";
        LocalDate parseDate = LocalDate.parse(strDate,dateTimeFormatter);
        System.out.println(parseDate);
        /*
        List<LocalDate> dates = LocalDate.now().
                datesUntil(LocalDate.parse("2025-06-12")).collect(Collectors.toList());
*/
        System.out.println(dateNow.plusDays(1));
        dateNow.plusMonths(2).plusYears(1).minus(2, ChronoUnit.DAYS);

        DayOfWeek dayOfWeek = LocalDate.parse("2018-07-12").getDayOfWeek();
        System.out.println(dayOfWeek);
        int dayOfMonth = LocalDate.parse("2018-07-12").getDayOfMonth();
        System.out.println(dayOfMonth);

        // LocalTime
        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);
        LocalTime setTime = LocalTime.of(6,39);
        System.out.println(setTime);
        System.out.println(LocalTime.parse("12:10"));

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.minusMonths(1).getMonth().getDisplayName(TextStyle.FULL, Locale.JAPANESE));

        LocalDate startState =  LocalDate.parse("2016-04-12");
        LocalDate finaleDate = startState.plus(Period.ofDays(67));
        int between = Period.between(finaleDate, startState).getDays();
        System.out.println(between);
        long between2 = ChronoUnit.DAYS.between(finaleDate, startState);
        System.out.println(between2);

        LocalTime localTime = LocalTime.of(7,23);
        LocalTime localTime1 = localTime.plus(Duration.ofMinutes(23));
 Set<String> allZone = ZoneId.getAvailableZoneIds();
        System.out.println(allZone);
        ZoneId zoneId = ZoneId.of("America/Marigot");
    }
}
