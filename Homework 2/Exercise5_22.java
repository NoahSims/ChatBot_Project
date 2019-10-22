/* Author:     Noah Sims
 * Program:    Homework 2 - Exercise 5.22
 * Date:	   9/6/2019
 * Comments:
 * 		This program prompts the user to enter the loan amount, loan period in years, and annual interest
 * 		rate, then displays an amortization schedule based on those values
 */

import java.util.Scanner;

public class Exercise5_22 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int loanAmount, loanPeriod;
		double annualInterestRate, monthlyInterestRate, monthlyPayment, totalPayment;
		
		// get loanAmount, loanPeriod, and annualInterestRate
		System.out.print("Loan Amount: ");
		loanAmount = input.nextInt();
		System.out.print("Number of years: ");
		loanPeriod = input.nextInt();
		System.out.print("Annual Interest Rate: ");
		annualInterestRate = input.nextDouble();
		
		// calculate monthlyPayment and totalPayment
		monthlyInterestRate = annualInterestRate / 1200;
		monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,  loanPeriod * 12));
		totalPayment = monthlyPayment * loanPeriod * 12;
		
		System.out.printf("\nMonthly Payment: %.2f\n", monthlyPayment);
		System.out.printf("Total Payment: %.2f\n\n", totalPayment);
		
		// create and display the amortization table
		System.out.printf("%-13s%-13s%-13s%-13s\n", "Payment#", "Interest", "Principal", "Balance");
		double interest, principal;
		double balance = loanAmount;
		for(int month = 1; month <= loanPeriod * 12; month++)
		{
			interest = monthlyInterestRate * balance;
			principal = monthlyPayment - interest;
			balance = balance - principal;
			
			System.out.printf("%-13d%-13.2f%-13.2f%13.2f\n", month, interest, principal, balance);
		} // end for loop
	} // end main
}
