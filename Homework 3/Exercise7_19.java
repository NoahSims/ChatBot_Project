/* Author:     Noah Sims
 * Program:    Homework 3 - Exercise 7.19
 * Date:	   9/15/2019
 * Comments:
 * 		This program takes in a list of integers from the user and determines whether or not the list
 * 		is already sorted in order from least to greatest
 */

import java.util.Scanner;

public class Exercise7_19 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int listLength;
		
		// get the list from the user (the first number entered is the length of the list)
		System.out.print("Enter list: ");
		listLength = input.nextInt();
		int[] list = new int[listLength];
		for(int i = 0; i < listLength; i++)
		{
			list[i] = input.nextInt();
		}
		
		// determine if the list is sorted
		if(isSorted(list))
			System.out.println("The list is already sorted");
		else
			System.out.println("The list is not sorted");
		
		input.close();
	} // end main
	
	// returns true if the array is sorted from least to greatest
	public static boolean isSorted(int[] list)
	{
		for(int i = 0; i < list.length - 1; i++)
		{
			// if any number on the list is greater than the number after it, then the array is not sorted
			if(list[i] > list[i + 1]) 
				return false;
		}
		return true;
	} // end isSorted
}
