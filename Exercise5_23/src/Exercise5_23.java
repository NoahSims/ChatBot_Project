/* Author:     Noah Sims
 * Program:    Homework 2 - Exercise 5.23
 * Date:	   9/6/2019
 * Comments:
 * 		This program demonstrates a cancellation error, an error that may cause a loss in accuracy when
 * 		adding very small numbers to very large numbers, unless you select the order of computation carefully.
 * 		Here, when calculating the sum 1 + 1/2 + 1/3 + 1/4 + . . . + 1/n, it can be seen that calculating
 * 		from right to left gives a more accurate answer than calculating from left to right.
 */

public class Exercise5_23 {
	public static void main(String [] args)
	{
		double n = 50000;
		double leftToRight = 0;
		double rightToLeft = 0;
		System.out.println("n = " + n);
		
		for(double i = 0; i < n; i++)
		{
			leftToRight += 1 / (i + 1);
			rightToLeft += 1 / (n - i);
		}
		System.out.println("computing from left to right = " + leftToRight);
		System.out.println("computing from right to left = " + rightToLeft);
	}
}
