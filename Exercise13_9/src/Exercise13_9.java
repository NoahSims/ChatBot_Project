/* Author:     Noah Sims
 * Program:    Homework 6 - Exercise 13_9
 * Date:	   10/5/2019
 * Comments:
 * 		This program gives a Circle class that extends from the GeometricObject class and implements the
 * 		Comparable interface
 */

class Circle extends GeometricObject implements Comparable<Circle>
{
	private double radius;
	
	public Circle()
	{
	}
	
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) 
	{
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double getArea()
	{
		return radius * radius * Math.PI;
	}
	
	public double getPerimeter()
	{
		return 2 * Math.PI * radius;
	}
	
	// two circles are equal if their radii are equal
	public boolean equals(Circle circle2)
	{
		return this.radius == circle2.getRadius();
	}

	// returns +1 if this circle is larger than the one compared to, -1 if this circle is smaller than the
	// one compared to, or 0 if this circle is equal to the one compared to 
	public int compareTo(Circle circle2) 
	{
		if(this.radius > circle2.getRadius())
			return 1;
		else if(this.radius < circle2.getRadius())
			return -1;
		else
			return 0;
	}
} // end Circle

// copied from the textbook
abstract class GeometricObject 
{
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	protected GeometricObject() 
	{
		dateCreated = new java.util.Date();
	}

	/** Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) 
	{
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() 
	{
		return color;
	}

	/** Set a new color */
	public void setColor(String color) 
	{
		this.color = color;
	}

	/** Return filled. Since filled is boolean,
	 * the get method is named isFilled */
	public boolean isFilled() 
	{
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) 
	{
		this.filled = filled;
	}

	/** Get dateCreated */
	public java.util.Date getDateCreated() 
	{
		return dateCreated;
	}

	@Override
	public String toString() 
	{
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}

	/** Abstract method getArea */
	public abstract double getArea();

	/** Abstract method getPerimeter */
	public abstract double getPerimeter();
} // end GeometricObject