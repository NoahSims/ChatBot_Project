/* Author:     Noah Sims
 * Program:    Homework 3 - Exercise 7.32
 * Date:	   9/13/2019
 * Comments:
 * 		This program takes in a list of integers from a user, then uses the first number from the list
 * 		as a pivot to partition the list
 */

import java.util.Scanner;

public class Exercise7_32 {
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
		
		// get the index of the pivot
		int pivotIndex = partition(list);
		
		// move the pivot to that position
		int temp = list[pivotIndex];
		list[pivotIndex] = list[0];
		list[0] = temp;
		
		// organize the list around the pivot
		int beforePivot = 0;
		int afterPivot = pivotIndex + 1;
		
		while(beforePivot < pivotIndex) // loop through the numbers before the pivot
		{
			if(list[beforePivot] > list[pivotIndex]) // if the number before the pivot needs to be moved
			{
				// if the number after the pivot doesn't need to be moved, skip it
				while(list[afterPivot] > list[pivotIndex]) 
				{
					afterPivot++;
				}
				// swap a number before the pivot and one after the pivot that both need to be moved
				temp = list[afterPivot];
				list[afterPivot] = list[beforePivot];
				list[beforePivot] = temp;
			} // end if
			
			beforePivot++;
		} // end while
		
		// print the organized list
		System.out.print("After the partition, the list is ");
		for(int i = 0; i < list.length; i++)
		{
			System.out.print(list[i] + " ");
		}
		
		input.close();
	} // end main
	
	public static int partition(int[] list) // returns the index of where the pivot belongs on the list
	{
		int pivot = list[0];
		int pivotIndex = 0;
		for(int i = 1; i < list.length; i++)
		{
			if(pivot > list[i])
				pivotIndex++;
		}
		
		return pivotIndex;
	} // end partition
}
