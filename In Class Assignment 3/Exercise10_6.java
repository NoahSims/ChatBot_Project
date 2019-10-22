/* Author:     Noah Sims
 * Program:    In Class Assignment 3 - Exercise 10.6
 * Date:	   10/1/2019
 * Comments:
 * 		This program creates a stack of every prime less than 120 and displays them from highest to lowest
 */

public class Exercise10_6 {
	public static void main(String [] args)
	{
		int num = 120;
		StackOfIntegers primes = new StackOfIntegers(num);
		
		for(int i = 2; i <= num; i++) 
		{
			if(isPrime(i))
			{
				primes.push(i);
			}
		} // end for
		
		System.out.println("Prime numbers less than " + num + " in decreasing order:");
		while(primes.getSize() > 0)
		{
			System.out.println(primes.pop());
		}
	} // end main
	
	// returns true if an integer is a prime number 
	public static boolean isPrime(int num)
	{
		for(int i = 2; i < (num / 2); i++)
		{
			if(num % i == 0)
				return false;
		} // end for
		
		return true;
	} // end isPrime
} // end Exercise10_6


//copied from listing 10.8 in the textbook
class StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	
	/** Construct a stack with the default capacity 16 */
	public StackOfIntegers() {
	this (DEFAULT_CAPACITY);
	}
	
	/** Construct a stack with the specified maximum capacity */
	public StackOfIntegers(int capacity) {
	elements = new int[capacity];
	}
	
	/** Push a new integer to the top of the stack */
	public void push(int value) {
	if (size >= elements.length) {
	int[] temp = new int[elements.length * 2];
	System.arraycopy(elements, 0, temp, 0, elements.length);
	elements = temp;
	}
	
	elements[size++] = value;
	}
	
	/** Return and remove the top element from the stack */
	public int pop() {
	return elements[--size];
	}
	
	/** Return the top element from the stack */
	public int peek() {
	return elements[size - 1];
	}
	
	/** Test whether the stack is empty */
	public boolean empty() {
	return size == 0;
	}
	
	/** Return the number of elements in the stack */
	public int getSize() {
	return size;
	}
}