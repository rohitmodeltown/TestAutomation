package javaBasic;

import java.util.*;
/*Write a Java program that takes two numbers as input and display the product of two numbers. Go to the editor
Test Data:
Input first number: 25
Input second number: 5
Expected Output :
25 x 5 = 125*/

public class ProductOfTwoNum {

	public static void main(String[] args) {
		
		Scanner product = new Scanner(System.in);
		System.out.println("Enter First Number");
		int firstnum = product.nextInt();
		System.out.println("Enter Second Number");
		int secondnum = product.nextInt();
		int multiple = firstnum*secondnum;
		System.out.println(multiple);

	}

}
