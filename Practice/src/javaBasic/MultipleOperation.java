package javaBasic;

import java.util.*;

/*
Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of two numbers. Go to the editor
Test Data:
Input first number: 125
Input second number: 24
Expected Output :
125 + 24 = 149
125 - 24 = 101
125 x 24 = 3000
125 / 24 = 5
125 mod 24 = 5*/

public class MultipleOperation {

	public static void main(String[] args) {

		// first Method to solve this problem
		
		int a = 125;
		int b = 24;

		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);

		// Second Method to solve this problem
		
		Scanner amsdr = new Scanner(System.in);
		System.out.println("Enter First Number");
		int x = amsdr.nextInt();
		System.out.println("Enter Second Number");
		int y = amsdr.nextInt();
		
		
		System.out.println("Sum is" +(x+y)); 
		//System.out.println("Subtract is" +x-y);
		System.out.println("Multiple is" +" " +(x*y));
		System.out.println("Divide is" +" " +(x/y));
		System.out.println("Mod is" +" " +(x%y));
		System.out.println("Subtract is" +" " +(x-y));

	}

}
