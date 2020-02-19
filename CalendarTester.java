
import java.util.Scanner;

public class CalendarTester extends CalendarPrinter {

  /**
   * Tests the getCentury method
   * 
   * @return true if all conditions are passed
   */
  public static boolean testGetCentury() {
    if (CalendarPrinter.getCentury("2") != 0)
      return false;
    if (CalendarPrinter.getCentury("2019") != 20)
      return false;
    if (CalendarPrinter.getCentury("44444") != 444)
      return false;
    return true;
  }

  /**
   * Tests the getYearWithinCentury method
   * 
   * @return true if all conditions are passed
   */

  public static boolean testGetYearWithinCentury() {
    if (CalendarPrinter.getYearWithinCentury("2") != 2)
      return false;
    if (CalendarPrinter.getYearWithinCentury("2019") != 19)
      return false;
    if (CalendarPrinter.getYearWithinCentury("44444") != 44)
      return false;
    return true;
  }

  /**
   * Tests the getGetMonthIndex method
   * 
   * @return true if all conditions are passed
   */
  public static boolean testGetMonthIndex() {
    if (CalendarPrinter.getMonthIndex("jent") != -1)
      return false;
    if (CalendarPrinter.getMonthIndex("january") != 0)
      return false;
    if (CalendarPrinter.getMonthIndex("febuary") != 1)
      return false;
    if (CalendarPrinter.getMonthIndex("Taran") != -1)
      return false;
    return true;
  }

  /**
   * Tests the getIsLeapYear method
   * 
   * @return true if all conditions are passed
   */
  public static boolean testGetIsLeapYear() {
    if (CalendarPrinter.getIsLeapYear("2020") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("2021") != false)
      return false;
    if (CalendarPrinter.getIsLeapYear("2016") != true)
      return false;
    if (CalendarPrinter.getIsLeapYear("2018") != false)
      return false;
    return true;
  }

  /**
   * Tests the getFirstDayOfTheWeekInMonth method
   * 
   * @return true if all conditions are passed
   */
  public static boolean testGetFirstDayOfTheWeekInMonth() {
    if (CalendarPrinter.getFirstDayOfWeekInMonth("January", "2020") != 2)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("November", "2019") != 4)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("Feburary", "2020") != 5)
      return false;
    if (CalendarPrinter.getFirstDayOfWeekInMonth("January", "2020") != 2)
      return false;
    return true;
  }

  /**
   * Tests the getNumberOfDaysInMonth method
   * 
   * @return true if all conditions are passed
   */
  public static boolean testGetNumberOfDaysInMonth() {
    if (CalendarPrinter.getNumberOfDaysInMonth("feburary", "2020") != 29)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("feburary", "2019") != 28)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("may", "2020") != 31)
      return false;
    if (CalendarPrinter.getNumberOfDaysInMonth("august", "2020") != 31)
      return false;
    return true;
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


    if (testGetCentury()) {
      System.out.println("pass");
    } else {
      System.out.println("fail");
    }
    if (testGetYearWithinCentury()) {
      System.out.println("pass");
    } else {
      System.out.println("fail");
    }
    if (testGetMonthIndex()) {
      System.out.println("pass");
    } else {
      System.out.println("fail");
    }
    if (testGetIsLeapYear()) {
      System.out.println("pass");
    } else {
      System.out.println("fail");
    }
    if (testGetFirstDayOfTheWeekInMonth()) {
      System.out.println("pass");
    } else {
      System.out.println("fail");
    }
    if (testGetNumberOfDaysInMonth()) {
      System.out.println("pass");
    } else {
      System.out.println("fail");
    }

  }
}
