/**
 * 
 */
package javaBasic;

import java.util.Scanner;

/**
 * @author A1SKIVA4
 *
 */
public class ReverseString {

	public static void main(String[]args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String ");
		char [] words = scan.nextLine().toCharArray();
		
		for(int i = words.length - 1; i >= 0; i--) {
			System.out.println(words[i]);
		} 
		
		System.out.println("\n");
		
	}
	
}
