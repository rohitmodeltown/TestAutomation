package javaBasic;

import java.util.Scanner;

public class ComputeDigit {

	public static void main(String[] args) {

		long num;
		Scanner comp = new Scanner(System.in);

		System.out.println("Enter the number to compute");
		num = comp.nextInt();

		System.out.println("The sum of digit" + computedigit(num));

	}

	public static int computedigit(long num) {

		int a = 0;
		while (num != 0) {
			a += num % 10;
			num /= 10;

		}

		return a;

	}

}
