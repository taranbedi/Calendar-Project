
import java.util.Scanner;

public class CalendarPrinter {

  private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
  private final static String[] MONTHS_OF_YEAR =
      {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};


  /**
   * Calculates the number of centuries (rounded down) that is represented by the specified year
   * (ie. the integer part of year/100).
   * 
   * @param year to compute the century of (based on the Gregorian Calendar AD) * String must
   *             contain the digits of a single non-negative int for year.
   * @return number of centuries in the specified year
   */
  public static int getCentury(String year) {
    // parses String year
    int num = Integer.parseInt(year);
    return num / 100;
  }

  /**
   * Calculates the number of years between the specified year, and the first year in the specified
   * year's century. This number is always between 0 - 99. * @param year to compute the year within
   * century of (Gregorian Calendar AD) String must contain the digits of a single non-negative int
   * for year.
   * 
   * @return number of years since first year in the current century
   */
  public static int getYearWithinCentury(String year) {
    if (year.length() >= 2) {
      // finds last two digits of year entered
      String lastTwoNumbers = year.substring(year.length() - 2);
      int num = Integer.parseInt(lastTwoNumbers);
      return num;
    } else {
      return Integer.parseInt(year);
    }
  }

  /**
   * This method computes whether the specified year is a leap year or not. * @param yearString is
   * the year that is being checked for leap-year-ness * String must contain the digits of a single
   * non-negative int for year. * @return true when the specified year is a leap year, and false
   * otherwise
   */
  public static boolean getIsLeapYear(String yearString) {
    // Note implementation tips in Appendix I below.
    int num = Integer.parseInt(yearString);
    if (num % 4 != 0) {
      return false;
    } else if (num % 100 != 0) {
      return true;
    } else if (num % 400 != 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Converts the name or abbreviation for any month into the index of that * month's abbreviation
   * within MONTHS_OF_YEAR. Matches the specified month * based only on the first three characters,
   * and is case in-sensitive.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters *
   * @return the index within MONTHS_OF_YEAR that a match is found at
   * 
   *         and returns -1, when no match is found
   */
  public static int getMonthIndex(String month) {
    if (month.length() >= 3) {
      // takes first 3 characters of String
      String abrv = month.substring(0, 3);
      // sets the 3 characters to upper case
      abrv = abrv.toUpperCase();
      for (int i = 0; i < MONTHS_OF_YEAR.length; i++) {
        String current = MONTHS_OF_YEAR[i];
        // finds when string entered matches the index of MONTHS_OF_YEAR
        if (abrv.equals(current)) {
          return i;
        }

      }
    }

    return -1;
  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified year is a leap year.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month that days are being counted for (Gregorian Calendar AD) * String must
   *              contain the digits of a single non-negative int for year.
   * @return the number of days in the specified month (between 28-31)
   */
  public static int getNumberOfDaysInMonth(String month, String year) {
    int x = CalendarPrinter.getMonthIndex(month);
    if (x == 0) {
      return 31;
    }
    if (x == 1 && !CalendarPrinter.getIsLeapYear(year)) {
      return 28;
    }
    if (x == 1 && CalendarPrinter.getIsLeapYear(year)) {
      return 29;
    }
    if (x == 2) {
      return 31;
    }
    if (x == 3) {
      return 30;
    }
    if (x == 4) {
      return 31;
    }
    if (x == 5) {
      return 30;
    }
    if (x == 6) {
      return 31;
    }
    if (x == 7) {
      return 31;
    }
    if (x == 8) {
      return 30;
    }
    if (x == 9) {
      return 31;
    }
    if (x == 10) {
      return 30;
    }
    if (x == 11) {
      return 31;
    }


    return -1;
  }

  /**
   * Calculates the index of the first day of the week in a specified month. The index returned
   * corresponds to position of this first day of the week within the DAYS_OF_WEEK class field.
   * 
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month to determine the first day from (Gregorian Calendar AD) * String must
   *              contain the digits of a single non-negative int for year.
   * @return index within DAYS_OF_WEEK of specified month's first day
   */
  public static int getFirstDayOfWeekInMonth(String month, String year) { // Note implementation
                                                                          // tips in Appendix I
                                                                          // below.

    int q = 1;
    int m = CalendarPrinter.getMonthIndex(month);
    int j = CalendarPrinter.getCentury(year);
    int k = CalendarPrinter.getYearWithinCentury(year);
    // if month is equal to January or Feburary, add 13 and reduce the year by 1
    if (m == 0 || m == 1) {
      m = m + 13;
      k = k - 1;
    } else {
      m = m + 1;
    }

    int day = ((q) + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + 5 * j) % 7;
    // makes sure ever day is the correct index
    day = (day + 5) % 7;
    return day;

  }

  /**
   * Creates and initializes a 2D String array to reflect the specified month. The first row of this
   * array [0] should contain labels representing the days * of the week, starting with Monday, as
   * abbreviated in DAYS_OF_WEEK. Every later row should contain dates under the corresponding days
   * of week. Entries with no corresponding date in the current month should be filled with a single
   * period. There should not be any extra rows that are either blank, unused, or completely filled
   * with periods. For example, the contents for September of 2019 should look as follows, where
   * each horizontal row is stored in different array within the 2d result: * MON TUE WED THU FRI
   * SAT SUN ......1 2345678 9 101112131415 16 17 18 19 20 21 22
   *
   *
   *
   *
   *
   *
   * @return 2d array of strings depicting the contents of a calendar 23 24 25 26 27 28 29 30 . . .
   *         . . .
   * @param month which may or may not be abbreviated to 3 or more characters
   * @param year  of month generate calendar for (Gregorian Calendar AD) String must contain the
   *              digits of a single non-negative int for year.
   */

  public static String[][] generateCalendar(String month, String year) {

    int rows = (getNumberOfDaysInMonth(month, year) / 7) + 1;
    rows = (int) (Math.ceil(rows) + 1);
    String[][] tsCalendar = new String[rows + 1][7];

    // add days of the week in the first row
    for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
      tsCalendar[0][i] = DAYS_OF_WEEK[i] + " ";
    }
    int day = 1;
    // adds periods before first day of the month and fills out the rest of the 2nd row
    for (int i = 0; i < 7; i++) {
      if (i < CalendarPrinter.getFirstDayOfWeekInMonth(month, year)) {
        tsCalendar[1][i] = ".  ";
      } else {
        tsCalendar[1][i] = String.valueOf(day + "   ");
        day++;
      }
    }
    // Fills out the remaining days in calendar and adds periods to fill out the remaining of the
    // last row
    for (int i = 2; i < rows; i++) {
      for (int j = 0; j < 7; j++) {
        if (day > getNumberOfDaysInMonth(month, year)) {
          tsCalendar[i][j] = (".  ");
        } else if (day < 10) {
          tsCalendar[i][j] = String.valueOf(day + "  ");
          day++;
        } else {
          tsCalendar[i][j] = String.valueOf(day + " ");
          day++;

        }
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < 7; j++) {
        System.out.print(tsCalendar[i][j]);
      }
      System.out.println();
    }


    return tsCalendar;
  }

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("================================");
    System.out.println("Enter the month to print: ");
    String inMonth = "";
    inMonth = scnr.next();
    System.out.println("Enter the year to print: ");
    String inYear = "";
    inYear = scnr.next();
    generateCalendar(inMonth, inYear);
    System.out.println("================================");
    System.out.println("Thanks, and have a nice day.");
    scnr.close();

  }
}
