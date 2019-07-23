package javaBasic;

import java.util.Scanner;

public class DecimalToBinery {

	public static void main(String[] args) {

		int num, newnum,j, i = 1;
		int bina[] = new int[60];

		Scanner convert = new Scanner(System.in);
		System.out.print("Input a Decimal Number : ");
		int acceptnum = convert.nextInt();

		newnum = acceptnum;

		while (acceptnum != 0) {

			bina[i++] = newnum % 2;
			newnum = newnum / 2;

		}
		System.out.println("BInary number is");
		
		for(j=i-1;j>0;j--) {
			
			System.out.println(bina[j]);
		}
		System.out.println("\n");
	}

}
