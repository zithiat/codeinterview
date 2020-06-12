package the100challenges;

import java.util.Random;

public class C016DayOfTheProgrammer {

	/**
	 * Problem:		In the following problem, the question talks about Georgian Calendar [1700–1917] 
	 * 				and Julian Calendar[1919–2700]. At the first look, you could not guess what is missing, 
	 * 				but here the year 1918 is left off. We have to find out the 256th day of this year also. 
	 * 				Which is not specifically mentioned in the conditions listed. This is relied upon us to find out. 
	 * 				Therefore, the tip is to Always look ahead for an implied condition.
	 * 				Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on 
	 * 				the Day of the Programmer (256th the day of the year) during a year in the inclusive range from 1700 to 2700.
	 * 				From 1700 ,to 1917 Russia’s official calendar was the Julian calendar; 
	 * 				since 1919 they used the Gregorian calendar system. The transition from the Julian 
	 * 				to Gregorian calendar system occurred in 1918, when the next day after January 31st 
	 * 				was February 14th. This means that in 1918, February 14th was the 32nd day of the year in Russia.  
	 * 				In both calendar systems, February is the only month with a variable amount of days; 
	 * 				it has 29 days during a leap year, and 28 days during all other years. In the Julian calendar, 
	 * 				leap years are divisible by 4; in the Gregorian calendar, leap years are either of the following:
	 * 				- Divisible by 400.
	 * 				- Divisible by 4 and not divisible by 100.
	 * 				Given a year, y, find the date of the 256th day of that year according to the official Russian calendar during that year. 
	 * 				Then print it in the format dd.mm.yyyy, where dd is the two-digit day, mm is the two-digit month, and yyyy is.
	 * Input:		A single integer denoting year y.
	 * Output:		Print the full date of Day of the Programmer during year y in the format dd.mm.yyyy, 
	 * 				where dd is the two-digit day, mm is the two-digit month, and yyyy is y.
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int n = 10;
		for (int i = 0; i < n; i++) {
			int y = r.nextInt(2700 - 1700) + 1700;
			findDayOfTheProgrammer(y);
		}
		findDayOfTheProgrammer(1918);
	}

	/**
	 * We will use the brute force to count the 256th day of the year.
	 * If leap year, Feb has 29 days, otherwise, 28 days. 
	 * So the calculation: 
	 * - Leap year: 31(Jan) + 29(Feb) + 31(Mar) + 30(Apr) + 31(May) + 30(Jun) + 31(Jul) + 31(Aug) + 12(Sep)
	 * - Non-leap: 31(Jan) + 28(Feb) + 31(Mar) + 30(Apr) + 31(May) + 30(Jun) + 31(Jul) + 31(Aug) + 13(Sep)
	 * - Year 1918: 31(Jan) + 15(Feb from 14th to 28th) + 31(Mar) + 30(Apr) + 31(May) + 30(Jun) + 31(Jul) + 31(Aug) + 26(Sep)
	 * @param y
	 */
	private static void findDayOfTheProgrammer(int y) {
		System.out.print("y=" + y);
		if (y >= 1919 || (y < 1918 && y >= 1700)) {
			if (checkLeapYear(y))
				System.out.println("\n\tThe 256th day of the year is 12.09." + y); // day 256th of the leap year
			else
				System.out.println("\n\tThe 256th day of the year is 13.09." + y); // day 256th of the non-leap year
		} else { // Feb 14th is the 32nd day in the year 1918.
			System.out.println("\n\tThe 256th day of the year is 26.09." + y);
		}
	}
	
	private static boolean checkLeapYear(int y) {
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
			return true;
		}
		return false;
	}
}
