/* Author:     Noah Sims
 * Program:    Homework 2 - Exercise 9.10
 * Date:	   9/21/2019
 * Comments:
 * 		This program creates a QuadraticEquation class and implements a test QuadraticEquation object 
 * 		to demonstrate the class's function of calculating the roots of a quadratic equation
 */

import java.util.Scanner;

// QuadraticEquation class tester
public class Exercise9_10 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		double a, b, c;
		
		System.out.print("Enter a, b, c: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		QuadraticEquation quad1 = new QuadraticEquation(a, b, c);
		
		if(quad1.getDiscriminant() > 0)
		{
			System.out.println("Root 1 = " + quad1.getRoot1());
			System.out.println("Root 2 = " + quad1.getRoot2());
		}
		else if(quad1.getDiscriminant() == 0)
		{
			System.out.println("Root 1 = " + quad1.getRoot1());
		}
		else
		{
			System.out.println("The equation has no roots.");
		}
		
		input.close();
	} // end main
}

// QuadraticEquation class
class QuadraticEquation
{
	private double a, b, c;
	
	QuadraticEquation(double newA, double newB, double newC)
	{
		a = newA;
		b = newB;
		c = newC;
	}
	
	double getA() 
	{
		return a;
	}
	
	double getB() 
	{
		return b;
	}
	
	double getC() 
	{
		return c;
	}
	
	double getDiscriminant()
	{
		return b * b - 4 * a * c;
	}
	
	double getRoot1()
	{
		return (-b + Math.sqrt(this.getDiscriminant())) / (2 * a);
	}
	
	double getRoot2()
	{
		return (-b - Math.sqrt(this.getDiscriminant())) / (2 * a);
	}
} // end QuadraticEquation