/* Author:     Noah Sims
 * Program:    Homework 2 - Exercise 9.1
 * Date:	   9/21/2019
 * Comments:
 * 		This program creates a Rectangle class and creates two test Rectangle objects to demonstrate
 * 		the class's function
 */

// Rectangle class tester
public class Exercise9_1 {
	public static void main(String [] args)
	{
		Rectangle r1 = new Rectangle(4, 10);
		System.out.println("R1: width =     " + r1.width +
						 "\n    height =    " + r1.height +
						 "\n    area =      " + r1.getArea() +
						 "\n    perimeter = " + r1.getPerimeter() + "\n");
		
		Rectangle r2 = new Rectangle(3.5, 35.9);
		System.out.println("R2: width =     " + r2.width +
				 		 "\n    height =    " + r2.height +
				 		 "\n    area =      " + r2.getArea() +
				 		 "\n    perimeter = " + r2.getPerimeter());
	} // end main
}

// Rectangle class
class Rectangle 
{
	double width = 1;
	double height = 1;
	
	Rectangle(){
	}
	
	Rectangle(double newWidth, double newHeight)
	{
		width = newWidth;
		height = newHeight;
	}
	
	public double getArea()
	{
		return width * height;
	}
	
	public double getPerimeter()
	{
		return (2 * width) + (2 * height);
	}
} // end Rectangle