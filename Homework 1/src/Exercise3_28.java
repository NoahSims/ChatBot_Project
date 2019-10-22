/* Author:     Noah Sims
 * Program:    Homework 1 - Exercise 3.22
 * Date:	   9/1/2019
 * Comments:
 * 		This program prompts the user to enter the center (x,y) coordinates and the height and width of two
 * 		rectangles, then determines if the second rectangle is inside or overlapping the first.
 */

import java.util.Scanner;

public class Exercise3_28 
{
	public static void main(String [] args) 
	{
		Scanner input = new Scanner(System.in);
		double r1X, r1Y, r1W, r1H;
		double r2X, r2Y, r2W, r2H;
		
		System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
		r1X = input.nextDouble();
		r1Y = input.nextDouble();
		r1W = input.nextDouble();
		r1H = input.nextDouble();
		
		System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
		r2X = input.nextDouble();
		r2Y = input.nextDouble();
		r2W = input.nextDouble();
		r2H = input.nextDouble();
		
		if((r2Y - r2H / 2 > r1Y + r1H / 2) || // if r2 is above r1
		   (r2X - r2W / 2 > r1X + r1W / 2) || // if r2 is to the right of r1
		   (r2Y + r2H / 2 < r1Y - r1H / 2) || // if r2 is bellow r1
		   (r2X + r2W / 2 < r1X - r1W / 2))   // if r2 is to the left of r1
		{
			System.out.print("r2 does not overlap r1");
		}
		else if((r2Y + r2H / 2 <= r1Y + r1H / 2) && // if r2's top is below r1's top
		   (r2X + r2W / 2 <= r1X + r1W / 2) && // if r2's right is to the left of r1's right
		   (r2Y - r2H / 2 >= r1Y - r1H / 2) && // if r2's bottom is above r1's bottom
		   (r2X - r2W / 2 >= r1X - r1W / 2))   // if r2's left is to the right of r1's left
		{
			System.out.print("r2 is inside r1");
		}
		else
		{
			System.out.print("r2 overlaps r1");
		}
	} // end main
} // end Exercise3_28
