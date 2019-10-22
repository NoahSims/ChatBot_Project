/* Author:     Noah Sims
 * Program:    Homework 1 - Exercise 3.9
 * Date:	   9/1/2019
 * Comments:
 * 		This program prompts the user to enter the first 9 digits of an ISBN-10, then calculates the 10th
 * 		digit and outputs the full ISBN-10.
 * 		The 10th digit is calculated using the formula (d1 * 1 + d2 * 2 + d3 * 3 + d4 *4 + d5 * 5 + d6 * 6
 * 		+ d7 * 7 + d8 * 8 + d9 * 9), where 'd' is one digit from the first 9 digits of the ISBN-10.
 * 		If the 10th digit = 10, it is denoted as 'X' according to the ISBN-10 convention.
 */

import java.util.Scanner;

public class Exercise3_9 
{
	public static void main(String [] args) 
	{
		Scanner input = new Scanner(System.in);
		int isbnFirstNine, isbnTemp, isbn10;
		int isbn1, isbn2, isbn3, isbn4, isbn5, isbn6, isbn7, isbn8, isbn9;
		
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		isbnFirstNine = input.nextInt();
		
		//break isbnFirstNine into individual integers to calculate isbn10
		//This would be much easier with an array and some loops, but we're not in those chapters yet :(
		isbn9 = isbnFirstNine % 10;
		isbnTemp = isbnFirstNine / 10;
		
		isbn8 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn7 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn6 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn5 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn4 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn3 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn2 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn1 = isbnTemp % 10;
		isbnTemp = isbnTemp / 10;
		
		isbn10 = (isbn1 * 1 + isbn2 * 2 + isbn3 * 3 + isbn4 * 4 + isbn5 * 5 + isbn6 * 6 + isbn7 * 7 
					 + isbn8 * 8 + isbn9 * 9) % 11;
		
		System.out.print("The ISBN-10 number is " + isbnFirstNine);
		if(isbn10 == 10) {
			System.out.print("X");
		}
		else {
			System.out.print(isbn10);
		}
	} // end main
} // end Exercise9_3
