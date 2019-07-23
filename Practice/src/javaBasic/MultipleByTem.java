package javaBasic;

import java.util.*;

/*Write a Java program that takes a number as input and prints its multiplication table upto 10. Go to the editor
Test Data:
Input a number: 8
Expected Output :
8 x 1 = 8
8 x 2 = 16
8 x 3 = 24
...
8 x 10 = 80*/


public class MultipleByTem {

	public static void main(String[] args) {
	
		Scanner acceptnum = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int num = acceptnum.nextInt();
		
		for(int x=1; x<=10 ; x++) {
			
			System.out.println(num+"*"+x+"= "+num*x);
			
		}

	}

}
