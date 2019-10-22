/* Author:     Noah Sims
 * Program:    Homework 6 - Exercise 13_04
 * Date:	   10/5/2019
 * Comments:
 * 		This program makes use of the Calendar and GregorianCalendar classes to display a calendar for a 
 * 		given month and year. The month and year must be passed to the main function by the String[] args.
 * 		This may be done using the windows command line using the command java Exercise13_04.java month year
 */

import java.util.*;

public class Exercise13_04 {
	public static void main(String[] args)
	{
		final String[] MONTH_NAMES = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		final int TEXT_WIDTH = 29; // the width of the calendar output
		
		// month and year are passed to main via args, month first then year
		int month = Integer.valueOf(args[0]) - 1;
		int year = Integer.valueOf(args[1]);
		
		GregorianCalendar calendar = new GregorianCalendar(year, month, 1);
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // day of the week for the first day of the month
		int daysThisMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // number of days in the month
		
		// print the calendar
		String calendarTitle = MONTH_NAMES[month] + ", " + year;
		System.out.println(centerString(calendarTitle, TEXT_WIDTH));
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
		
		// print blank spaces until the first day of the month
		int weekDayCounter;
		for(weekDayCounter = 1; weekDayCounter < dayOfWeek; weekDayCounter++)
		{
			System.out.print("    ");
		}
		// weekDayCounter is now equal to dayOfWeek
		
		// print dates until the end of the month
		int dayCounter = 1;
		while(dayCounter <= daysThisMonth)
		{
			System.out.printf("%4d", dayCounter);
			dayCounter++;
			weekDayCounter++;
			if(weekDayCounter > 7)
			{
				System.out.println();
				weekDayCounter = 1;
			}
		} // end while
	} // end main
	
	// given a string and a width, return the string centered in a string that is width long
	public static String centerString(String str, int width)
	{
		int spaceAmount = (29 - str.length()) / 2;
		String space = "";
		for(int i = 0; i < spaceAmount; i++)
		{
			space += " ";
		}
		
		return space + str + space;
	} // end centerString
} // end Exercise13_04
