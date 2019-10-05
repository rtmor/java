import java.text.DateFormatSymbols;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * @Date.java
 * @author Ryan T. Moran
 * 
 *         H.4.1: Create a class that stores the current date. Add fields for
 *         day, month, and year. Add getters and setters for all fields. Add a
 *         toString to return a string representation of the date in the
 *         following format: 01/02/2019. Add a method which returns the date in
 *         the following format: "January 2, 2019". Add a constructor that takes
 *         all three fields as parameters. Validate the input for month and day
 *         (i.e. February 30th should not be allowed, but February 29th should
 *         be allowed in leap years). For year, validate that the year is
 *         greater than 1900. Create a main which thoroughly tests all of the
 *         functionality of your class including validation.
 */
public class Date {

    private int day;
    private int month;
    private int year;

    /**
     * Date Constructor transforms @param month,day,year to int because of LocalDate
     * return type {@link #main}
     * 
     * @param month
     * @param day
     * @param year
     */
    public Date(String month, String day, String year) {

        setMonth(Integer.parseInt(month));
        setYear(Integer.parseInt(year));
        setDay(Integer.parseInt(day));
    }

    public Date() {

    }

    public void setDay(int currentDay) {
        this.day = currentDay;
        try {
            if (currentDay <= LocalDate.of(getYear(), getMonth(), currentDay).lengthOfMonth()) {
                this.day = currentDay;
            }
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
            this.day = -1;
        }
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int currentMonth) {
        if (currentMonth >= 1 && currentMonth <= 12) {
            this.month = currentMonth;
        } else {
            this.month = -1;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int currentYear) {
        if (currentYear >= 1900) {
            this.year = currentYear;
        } else {
            this.year = -1;
        }
    }

    public int getYear() {
        return year;
    }

    /**
     * if year > 1900 and number of days <= max days per month of year
     * 
     * @return dateString
     * @exception e checks for leap year; exceeded days per month
     */
    public String date2String() {

        String dateString = null;

        if (getYear() == -1) {
            return "Not a valid Year";
        }
        try {
            if (getDay() <= LocalDate.of(getYear(), getMonth(), getDay()).lengthOfMonth()) {
                dateString = month2String(getMonth()) + " " + getDay() + ", " + getYear();
            }
        } catch (DateTimeException e) {
            return e.getMessage();

        }
        return dateString;
    }

    /**
     * Convert int month to string month
     * 
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