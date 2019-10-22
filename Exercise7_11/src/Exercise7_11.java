/* Author:     Noah Sims
 * Program:    Homework 3 - Exercise 7.11
 * Date:	   9/14/2019
 * Comments:
 * 		This program takes in a list of 10 doubles from the user, then calculates the mean
 * 		and standard deviation of the list
 */

import java.util.Scanner;

public class Exercise7_11 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double[] list = new double[10];
		
		// get the list from the user
		System.out.print("Enter ten numbers: ");
		for(int i = 0; i < list.length; i++)
		{
			list[i] = input.nextDouble();
		}
		
		// calculate the mean
		double listMean = mean(list);
		System.out.println("The mean is " + listMean);
		
		// calculate the standard deviation
		double listDeviation = deviation(list);
		System.out.println("The standard deviation is " + listDeviation);
		
		input.close();
	} // end main
	
	// Compute the standard deviation of an array of doubles
	public static double deviation(double[] x)
	{
		double xMean = mean(x);
		double sum = 0;
		for(int i = 0; i < x.length; i++)
		{
			sum += Math.pow(x[i] - xMean, 2);
		}
		
		return Math.sqrt(sum / (x.length - 1));
	} // end deviation
	
	// Compute the mean of an array of double values
	public static double mean(double[] x)
	{
		double sum = 0;
		for(int i = 0; i < x.length; i++)
		{
			sum += x[i];
		}
		
		return sum / x.length;
	} // end mean
}
