/* Author:     Noah Sims
 * Program:    In Class Assignment 3 - Exercise 11.11
 * Date:	   10/1/2019
 * Comments:
 * 		This program prompts the user to enter 5 integers, stores those integers in an arrayList, sorts
 * 		the arrayList, then returns the sorted integers to the user
 */

import java.util.*;

public class Exercise11_11 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<>();
		
		System.out.print("Enter 5 integers: ");
		for(int i = 0; i < 5; i++)
		{
			numList.add(input.nextInt());
		}
		
		sort(numList);
		
		System.out.println("Sorted into increasing order: ");
		for(int i = 0; i < numList.size(); i++)
		{
			System.out.print(numList.get(i) + " ");
		}
	} // end main
	
	// sorts an array of integers into ascending order
	public static void sort(ArrayList<Integer> list)
	{
		int i = 0;
		while(i < list.size())
		{
			int num = list.get(i);
			int pos = 0;
			for(int j = 0; j < list.size(); j++)
			{
				if(num > list.get(j))
					pos++;
			}
			list.set(i, list.get(pos));
			list.set(pos, num);
			
			if(pos == i)
				i++;
		} // end while
	} // end sort
} // end Exercise11_11