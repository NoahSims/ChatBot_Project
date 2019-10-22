import java.util.Scanner;

public class mipsSucks {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		int x, y, s;
		
		System.out.print("Enter an integer X: ");
		x = input.nextInt();
		System.out.print("Enter an integer Y: ");
		y = input.nextInt();
		s = x + y;
		System.out.print("The sum of X and Y (X + Y) is " + s);
	}

}
