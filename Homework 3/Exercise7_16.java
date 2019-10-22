/* Author:     Noah Sims
 * Program:    Homework 3 - Exercise 7.16
 * Date:	   9/14/2019
 * Comments:
 * 		This program demonstrates the difference in execution times for a linear search on an unsorted list 
 * 		vs. a binary search on a sorted list. This is done by first generating an array of 100,000 random
 * 		integers, then searching the array using both methods and calculating the time it took to execute.
 */

public class Exercise7_16 {
	public static void main(String[] args)
	{
		// generate an array of 100,000 random ints and a random number to search the list for
		int[] randomList = new int[100000];
		for(int i = 0; i < randomList.length; i++)
		{
			randomList[i] = (int)(Math.random() * 100000);
		}
		int key = (int)(Math.random() * 100000);
		
		// get the execution time of linear search
		long startTime = System.nanoTime();
		int keyIndex = linearSearch(randomList, key);
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("Execution time for linear search of 100000 items = " + executionTime + " nanoseconds");
		
		// get the execution time of binarry search
		startTime = System.nanoTime();
		keyIndex = binarySearch(randomList, key);
		endTime = System.nanoTime();
		executionTime = endTime - startTime;
		System.out.println("Execution time for binary search of 100000 sorted items = " + executionTime + " nanoseconds");
	} // end main
	
	// performs a linear search on an array and returns the index of the position of the key (-1 if not found)
	public static int linearSearch(int[] list, int key)
	{
		for(int i = 0; i < list.length; i++)
		{
			if(key == list[i])
				return i;
		}
		return -1;
	} // end linearSearch
	
	// Sorts an array into least to greatest order
	public static void selectionSort(int[] list)
	{
		for(int i = 0; i < list.length; i++)
		{
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for(int j = i + 1; j < list.length; j++)
			{
				if(currentMin > list[j])
				{
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			if(currentMinIndex != i)
			{
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	} // end selectionSort
	
	// performs a binary search on a sorted array and returns the index of the position of the key (-1 if not found)
	public static int binarySearch(int[] list, 	int key)
	{
		int low = 0;
		int high = list.length - 1;
		
		while (high >= low)
		{
			int mid = (low + high) / 2;
			if(key < list[mid])
				high = mid - 1;
			else if(key == list[mid])
				return mid;
			else
				low = mid + 1;
		}
		
		return -low - 1;
	} // end binarySearch
}
