package javaBasic;

import java.util.Scanner;

/*Write a Java program to compare two numbers. Go to the editor
Input Data:
Input first integer: 25
Input second integer: 39
*/

public class CompareTwoNumber {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter First Number");
		
		int num1 = input.nextInt();
		
		System.out.println("Enter Second Number");
		
		int num2 = input.nextInt();
		
		if(num1>num2){
			
			System.out.println("Frist num is greater"+num1);
			
			System.out.println(num1>num2);
			
		}else if(num1<=num2){
			
			System.out.println("Second num is equal"+num2);
			
			System.out.println(num1<=num2);
		}
		else {
			System.out.println(num2);
		}
		
		
		
		
		
		
		
		
		}
		
		

		

	}


