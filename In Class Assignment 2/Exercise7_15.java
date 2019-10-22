/* This program asks the user to input 10 integers. The integers are put into an array, then
 * any duplicates in the array are removed
 */

import java.util.Scanner;

public class Exercise7_15 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int[] list = new int[10];
		
		System.out.print("Enter ten numbers: ");
		for(int i = 0; i < 10; i++)
		{
			list[i] = input.nextInt();
		}
		
		int[] listNoDupes = eliminateDuplicates(list);
		
		System.out.print("The distinct numbers are: ");
		for(int i = 0; i < listNoDupes.length; i++)
		{
			System.out.print(listNoDupes[i] + " ");
		}
		
	}
	
	// returns an array without any duplicates
	public static int[] eliminateDuplicates(int[] list)
	{
		int[] temp = new int[list.length];
		int count = 0;
		
		for(int i = 0; i < list.length; i++)
		{
			Boolean isDistinct = true;
			for(int j = i - 1; j >= 0; j--)
			{
				if(list[i] == list[j])
				{
					isDistinct = false;
				}
			}
			if(isDistinct)
			{
				temp[count] = list[i];
				count++;
			}
		}
		
		int[] result = new int[count];
		for(int i = 0; i < count; i++)
		{
			result[i] = temp[i];
		}
		return result;
	}
}
