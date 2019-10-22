/* Author:     Noah Sims
 * Program:    In Class Assignment 3 - Exercise 11.2
 * Date:	   10/3/2019
 * Comments:
 * 		This program defines a Person, Student, Employee, Faculty, and Staff class. Student and Employee
 * 		are children of the Person class. Faculty and Staff are children of the Employee class. The
 * 		program then demonstrates each class's class specific toString method.
 */

import java.util.*;

public class Exercise11_2 {
	public static void main(String [] args)
	{
		Person testPerson = new Person();
		System.out.println("Person.toString = " + testPerson.toString());
		
		Student testStudent = new Student();
		System.out.println("Student.toString = " + testStudent.toString());
		
		Employee testEmployee = new Employee();
		System.out.println("Employee.toString = " + testEmployee.toString());
		
		Faculty testFaculty = new Faculty();
		System.out.println("Faculty.toString = " + testFaculty.toString());
		
		Staff testStaff = new Staff();
		System.out.println("Staff.toString = " + testStaff.toString());
	} // end main
} // end Exercise11_2

class Person
{
	String name;
	String address;
	String phoneNumber;
	String emailAddress;
	
	public Person()
	{
	}
	
	public Person(String name, String address, String phoneNumber, String emailAddress)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public String toString()
	{
		return "Person";
	}
} // end Person

class Student extends Person
{
	public final String STATUS;
	
	public Student()
	{
		this.STATUS = "";
	}
	
	public Student(String name, String address, String phoneNumber, String emailAddress, String status)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.STATUS = status;
	}
	
	public String toString()
	{
		return "Student";
	}
} // end Student

class Employee extends Person
{
	String office;
	double salary;
	Date dateHired;
	
	public Employee()
	{
	}
	
	public Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary, long dateHired)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.office = office;
		this.salary = salary;
		this.dateHired = new Date(dateHired);
	}
	
	public String toString()
	{
		return "Employee";
	}
} // end Employee

class Faculty extends Employee
{
	String officeHours;
	String rank;
	
	public Faculty()
	{
	}
	
	public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary, long dateHired, String officeHours, String rank)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.office = office;
		this.salary = salary;
		this.dateHired = new Date(dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	public String toString()
	{
		return "Faculty";
	}
} // end Faculty

class Staff extends Employee
{
	String title;
	
	public Staff()
	{
	}
	
	public Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary, long dateHired, String title)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.office = office;
		this.salary = salary;
		this.dateHired = new Date(dateHired);
		this.title = title;
	}
	
	public String toString()
	{
		return "Staff";
	}
} // end Staff