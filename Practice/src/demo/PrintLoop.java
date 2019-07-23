/**
 * 
 */
package demo;

/**
 * @author A1SKIVA4
 *
 */
public class PrintLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int n = 0; n < 7; ++n) {

			if (n == 2) {

				System.out.println(n);
				continue;
				// break;
			}
			System.out.println("break lin");
			System.out.println("in loop1: " + n);

			/*
			 * System.out.println ("in loop2: " + n); System.out.println ("in loop3: " + n);
			 * System.out.println ("in loop4: " + n); System.out.println ("in loop5: " + n);
			 * System.out.println ("in loop6: " + n);
			 */

		}

	}

}
