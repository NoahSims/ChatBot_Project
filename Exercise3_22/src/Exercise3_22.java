import java.util.Scanner;

public class Exercise3_22 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		double x, y;
		double distance;
		
		System.out.println("Enter a point with two coordinates: ");
		x = input.nextDouble();
		y = input.nextDouble();
		
		distance = Math.pow(x * x + y * y, 0.5);
		
		if(distance < 10) {
			System.out.println("Point (" + x + ", " + y + ") is in the circle");
			
			//System.out.printf("Point (%.2f, %.2f) is in the circle\n", x, y);
		}
		else {
			System.out.println("Point (" + x + ", " + y + ") is not in the circle");
		}
	}
}
