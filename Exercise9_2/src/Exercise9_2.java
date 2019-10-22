/* Author:     Noah Sims
 * Program:    Homework 2 - Exercise 9.2
 * Date:	   9/21/2019
 * Comments:
 * 		This program creates a Stock class and creates a test Stock object to demonstrate the class's 
 * 		functionality of calculating the percent change of the stock's value from one day to the next
 */

// Stock class tester
public class Exercise9_2 {
	public static void main(String [] args)
	{
		Stock orcl = new Stock("ORCL", "Oracle Corporation");
		orcl.previousClosingPrice = 34.5;
		
		orcl.currentPrice = 34.35;
		System.out.printf("%s price-change percent: %.3f%%", orcl.symbol, orcl.getChangePercent());
	} // end main
}

// Stock class
class Stock
{
	String symbol, name;
	double previousClosingPrice, currentPrice;
	
	Stock(String newSymbol, String newName)
	{
		symbol = newSymbol;
		name = newName;
	}
	
	public double getChangePercent()
	{
		return 100 * (currentPrice - previousClosingPrice) / previousClosingPrice;
	}
} // end Stock