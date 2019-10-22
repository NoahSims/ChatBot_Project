/* Author:     Noah Sims
 * Program:    In Class Assignment 3 - Exercise 11.12
 * Date:	   10/2/2019
 * Comments:
 * 		This program prompts the user to enter 5 doubles, stores the doubles in an arrayList, then outputs
 * 		the sum of the doubles to the user
 */

import java.util.*;

public class Exercise11_12 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Double> numList = new ArrayList<>();
		
		System.out.print("Enter 5 numbers: ");
		for(int i = 0; i < 5; i++)
		{
			numList.add(input.nextDouble());
		}
		
		System.out.println("Sum of numbers =  " + sum(numList));
	} // end main
	
	// returns the sum of each value in an array of doubles
	public static double sum(ArrayList<Double> list)
	{
		double sum = 0;
		for(int i = 0; i < list.size(); i++)
		{
			sum += list.get(i);
		}
		return sum;
	} // end sum
} // end Exercise11_12