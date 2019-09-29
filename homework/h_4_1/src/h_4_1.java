import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * H.4.1: Create a class that stores the current date. Add fields for day,
 * month, and year. Add getters and setters for all fields. Add a toString to
 * return a string representation of the date in the following format:
 * 01/02/2019. Add a method which returns the date in the following format:
 * "January 2, 2019". Add a constructor that takes all three fields as
 * parameters. Validate the input for month and day (i.e. February 30th should
 * not be allowed, but February 29th should be allowed in leap years). For year,
 * validate that the year is greater than 1900. Create a main which thoroughly
 * tests all of the functionality of your class including validation.
 */
public class h_4_1 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        
        DateTimeFormatter dtfYear = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter dtfMonth = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dtfDay = DateTimeFormatter.ofPattern("dd");

        String year = dtfYear.format(localDate);
        String month = dtfMonth.format(localDate);
        String day = dtfDay.format(localDate);

        /**
         * Initialize constructor
         */
        Date currentDate = new Date(month, day, year);

        /**
         * Return date in numberical string
         * Return date in string format
         */
        System.out.println(currentDate.toString());
        System.out.println(currentDate.date2String());

        /**
         * Leap Year Validation - Pass
         */
        currentDate.setDay(29);
        currentDate.setMonth(2);
        currentDate.setYear(2020);
        System.out.println(currentDate.date2String());

        /**
         * Leap Year Validation - Fail
         */
        currentDate.setYear(2019);
        System.out.println(currentDate.date2String());

        /**
         * Date Validation - Fail
         */
        currentDate.setYear(1800);
        System.out.println(currentDate.date2String());

    }
}