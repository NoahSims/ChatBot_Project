/* Author:     Noah Sims
 * Program:    Homework 2 - Exercise 5.21
 * Date:	   9/6/2019
 * Comments:
 * 		This program prompts the user to enter the amount and loan period in years, then displays
 * 		several loan options with interest rates ranging from 5% to 8%, incrementing by 1/8
 */

import java.util.Scanner;

public class Exercise5_21 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int loanAmount, loanPeriod;
		double interestRate, monthlyPayment, totalPayment, monthlyInterestRate;
		
		// get loanAmount and loanPeriod
		System.out.print("Loan Amount: ");
		loanAmount = input.nextInt();
		System.out.print("Number of years: ");
		loanPeriod = input.nextInt();
		
		// display interest options
		System.out.printf("%-17s%-17s%-17s\n", "Interest Rate", "Monthly Payment", "Total Payment");
		for(interestRate = 5; interestRate <= 8; interestRate += .125)
		{
			monthlyInterestRate = interestRate / 1200; // interestRate is the annual interest as a percentage,
			// for the monthlyPayment equation, it needs to be converted to a monthly interest as a decimal
			monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,  loanPeriod * 12));
			totalPayment = monthlyPayment * loanPeriod * 12;
			
			System.out.printf("%.3f%-11% %-17.2f%-17.2f\n", interestRate, monthlyPayment, totalPayment);
		} // end for loop
	} // end main
}