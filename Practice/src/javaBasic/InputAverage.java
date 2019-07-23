package javaBasic;

import java.util.*;

/*Write a Java program that takes three numbers as input to calculate and print the average of the numbers. */


public class InputAverage {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter First Number");
		int a = input.nextInt();
		System.out.println("Enter Second Number");
		int b = input.nextInt();
		System.out.println("Enter Third Number");
		int c = input.nextInt();
		int total = a+b+c;
		int average = total/3;
		
		System.out.println("Average of three number is"+" "+average);
	}

}
