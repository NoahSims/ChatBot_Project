import java.util.Scanner;
import java.lang.System;
import java.lang.String; //added by java by default

//OR
//import java.util.*;
//import java.lang.*;

public class Exercise3_1 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		double a, b, c;
		double disc;
		
		System.out.print("Enter a, b, c: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		disc = b* b - 4 * a * c;
		if (disc < 0){
			System.out.println("The equation has no real roots");
		}
		else if (disc == 0) {
			double r1 = -b / (2 * a);
			System.out.println("The equation has one real root " + r1);
		}
		else {
			double r1 = (-b + Math.pow(disc,  0.5)) / (2 * a);
			double r2 = (-b - Math.pow(disc,  0.5)) / (2 * a);
			System.out.println("The equation has two real roots " + r1 + "and" + r2);
		}
	}
}
