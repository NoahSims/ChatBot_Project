/* This program checks for the validity of a credit card number based on 3 criteria:
 * 		1) a credit card number must be between 13 and 16 digits long
 * 		2) a credit card number must begin with 37, 4, 5, or 6
 * 		3) a credit card must pass the Luhn check, aka the Mod 10 check
*/
import java.util.Scanner;

public class Exercise6_31 {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		long creditCardNumber;
		
		System.out.print("Enter a credit card number as a long integer: ");
		creditCardNumber = input.nextLong();
		
		if(isValid(creditCardNumber)) {
			System.out.print(creditCardNumber + " is valid");
		}
		else {
			System.out.print(creditCardNumber + " is invalid");
		}
	}
	
	// return true if the card number is valid
	public static boolean isValid(long number)
	{
		if(getSize(number) > 12 && getSize(number) < 17) {
			if(prefixMatched(number, 37) || prefixMatched(number, 4) ||
			   prefixMatched(number, 5) || prefixMatched(number, 6)) {
				if((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	// double every second digit from left to right, then sum those numbers and return the sum
	public static int sumOfDoubleEvenPlace(long number)
	{
		long creditNum = number;
		int numLength = getSize(number);
		int sum = 0;
		
		for(int i = 0; i < numLength; i++)
		{
			creditNum = creditNum / 10;
			sum += getDigit((int)((creditNum % 10) * 2));
		}
		
		return sum;
	}
	
	// return the number if it is a single digit, otherwise add the seperate digits of a two digit number
	public static int getDigit(int number)
	{
		if(number > 9) {
			int first = number % 10;
			int second = number / 10;
			return first + second;
		}
		else {
			return number;
		}
	}
	
	// return sum of odd placed digits in the number
	public static int sumOfOddPlace(long number)
	{
		long creditNum = number;
		int numLength = getSize(number);
		int sum = 0;
		
		for(int i = 0; i < numLength; i++)
		{
			sum += creditNum % 10;
			creditNum = creditNum / 10;
		}
		
		return sum;
	}
	
	// returns true if the d is the first digit (or digits) in number
	public static boolean prefixMatched(long number, int d)
	{
		int dSize = getSize(d);
		if(getPrefix(number, dSize) == d){
			return true;
		}
		else{
			return false;
		}
	}
	
	// returns the number of digits in d
	public static int getSize(long d)
	{
		long num = d;
		int count = 0;
		
		while(num > 0)
		{
			num = num / 10;
			count++;
		}
		
		return count;
	}
	
	// if number is longer than k digits, returns the first k digits of number
	public static long getPrefix(long number, int k)
	{
		long creditNum = number;
		
		while(getSize(creditNum) > k)
		{
			creditNum = creditNum / 10;
		}
		
		return creditNum;
	}
}
