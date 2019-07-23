/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class PrintTriangle {

	public static void main(String[] args) {

		int row = 5;
		int rows = 6;

		for (int i = 0; i <= row; ++i) {

			for (int k = row; k >= i; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; ++j) {

				System.out.print("* ");
			}

			System.out.println("*");
		}

		for (int x = 1; x <= rows; ++x) {
			
			for (int f = rows; f >= x; f--) {
				System.out.print(" ");
			}
			for (int y = 1; y <= x; ++y) {

				System.out.println(y + " ");
			}

			System.out.println(x);
		}

	}

}
