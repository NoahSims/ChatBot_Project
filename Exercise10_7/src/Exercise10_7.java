/* Author:     Noah Sims
 * Program:    In Class Assignment 3 - Exercise 10.7
 * Date:	   10/3/2019
 * Comments:
 * 		This program creates an array of Account objects and uses an ATM-like menu system to access and
 * 		alter those accounts
 */

import java.util.*;

public class Exercise10_7 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		Account[] accountList = new Account[10];
		for(int i = 0; i < accountList.length; i++)
		{
			accountList[i] = new Account(i, 100.0);
		}
		
		boolean systemExit = false;
		boolean menuExit;
		int userId;
		
		do
		{
			userId = getUserId(accountList, input);
			do
			{
				menuExit = false;
				
				displayMenu();
				int userChoice = input.nextInt();
				
				switch(userChoice) {
				case 1: // display balance
					System.out.println("The balance is " + accountList[userId].getBalance());
					break;
				case 2: // withdraw
					System.out.print("Enter an ammount to withdraw: ");
					accountList[userId].withdraw(Math.abs(input.nextDouble()));
					break;
				case 3: // deposit
					System.out.print("Enter an ammount to deposit: ");
					accountList[userId].deposit(Math.abs(input.nextDouble()));
					break;
				case 4: // exit
					menuExit = true;
					break;
				default:
					System.out.println("Invalid input");
				} // end switch
			}while(!menuExit);
			
			System.out.println();
			
		} while(!systemExit);
	} // end main
	
	// returns the position of account userId if it exists in the array, otherwise returns -1
	public static int validateId(Account[] accountList, int userId)
	{
		for(int i = 0; i < accountList.length; i++)
		{
			if(accountList[i].getId() == userId)
				return i;
		}
		return -1;
	} // end validateId
	
	// prompts the user to enter their id and validate's the user's input, returning array position of the user's id
	public static int getUserId(Account[] accountList, Scanner input)
	{
		int userId, accountNum;
		do
		{
			userId = -1;
			accountNum = -1;
			
			System.out.print("Enter an id: ");
			userId = input.nextInt();
			accountNum = validateId(accountList, userId);
			
			if(accountNum == -1)
				System.out.println("Invalid id\n");
		} while(accountNum == -1);
		
		return accountNum;
	} // end getUserId
	
	// displays the menu to the user and prompts for an input
	public static void displayMenu()
	{
		System.out.println("\nMain menu");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4: exit");
		System.out.print("Enter a choice: ");
	} // end displayMenu
} // end Exercise10_7


// given by Professor Khan
class Account 
{
	private int id;
	private double balance;
	private static double annualInterestRate;
	private java.util.Date dateCreated;

	public Account()
	{
		dateCreated = new java.util.Date();
	}

	public Account(int newId, double newBalance) 
	{
		id = newId;
	    balance = newBalance;
	    dateCreated = new java.util.Date();
	}

	public int getId() 
	{
		return this.id;
	}

	public double getBalance() 
	{
		return balance;
	}

	public static double getAnnualInterestRate() 
	{
		return annualInterestRate;
	}

	public void setId(int newId) 
	{
		id = newId;
	}

	public void setBalance(double newBalance) 
	{
		balance = newBalance;
	}

	public static void setAnnualInterestRate(double newAnnualInterestRate) 
	{
		annualInterestRate = newAnnualInterestRate;
	}

	public double getMonthlyInterest() 
	{
		return balance * (annualInterestRate / 1200);
	}

	public java.util.Date getDateCreated() 
	{
	    return dateCreated;
	}

	public void withdraw(double amount) 
	{
	    balance -= amount;
	}

	public void deposit(double amount) 
	{
	    balance += amount;
	}
}