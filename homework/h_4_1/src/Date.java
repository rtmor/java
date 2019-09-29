import java.text.DateFormatSymbols;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Date.java
 * 
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
public class Date {

    private int day;
    private int month;
    private int year;

    public Date(String month, String day, String year) {

        this.day = Integer.parseInt(day);
        this.month = Integer.parseInt(month);
        this.year = Integer.parseInt(year);
    }

    public Date() {

    }

    public void setDay(int currentDay) {
        this.day = currentDay;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int currentMonth) {
        this.month = currentMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int currentYear) {
        this.year = currentYear;
    }

    public int getYear() {
        return year;
    }

    /**
     * if year > 1900 and number of
     * days <= max days per month of year
     * @return dateString 
     */
    public String date2String() {

        String dateString = null;

        if (getYear() < 1900) {
            return "Year is less than 1900";
        }
        try {
            if (getDay() <= LocalDate.of(getYear(), getMonth(), getDay()).lengthOfMonth()) {
                dateString = month2String(getMonth()) + " " + getDay() + ", " + getYear();
            }
        } catch (DateTimeException e) {
            dateString = getDay() + " exceeds number of days in " + month2String(getMonth()) + " of " + getYear();
            e.printStackTrace();

        }
        return dateString;
    }

    /**
     * Convert int month to string month
     * @param month
     * @return
     */
    private String month2String(int month) {

        return new DateFormatSymbols().getMonths()[month - 1];
    }

    @Override
    public String toString() {
        try {
            return month + "/" + day + "/" + year;
        } catch (Exception e) {
            return "Error formating int(s) to string";
        }
    }

}