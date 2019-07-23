/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */

/*
 * Print below pattern: This is one of the best programs to learn loop
 * 
 * 1 12 123 1234 12345
 */

public class SeriesLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.println("j" + j);
			}
			System.out.println();
		}

	}

}
