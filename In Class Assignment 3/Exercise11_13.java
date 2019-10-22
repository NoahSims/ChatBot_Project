/* Author:     Noah Sims
 * Program:    In Class Assignment 3 - Exercise 11.13
 * Date:	   10/2/2019
 * Comments:
 * 		This program prompts the user to enter 10 integers, stores the integers in an arrayList, then
 * 		removes each duplicate number from the arrayList and returns the distinct integers to the user
 */

import java.util.*;

public class Exercise11_13 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<>();
		
		System.out.print("Enter 10 integers: ");
		for(int i = 0; i < 10; i++)
		{
			numList.add(input.nextInt());
		}
		
		removeDuplicate(numList);
		
		System.out.print("The distinct integers are");
		for(int i = 0; i < numList.size(); i++)
		{
			System.out.print(" " + numList.get(i));
		}
	} // end main
	
	// removes each duplicate number from an array of integers
	public static void removeDuplicate(ArrayList<Integer> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			int j = i + 1;
			while(j < list.size())
			{
				if(list.get(i) == list.get(j))
					list.remove(j);
				else
					j++;
			} // end while
		} // end for
	} // end removeDuplicates
} // end Exercise11_13
