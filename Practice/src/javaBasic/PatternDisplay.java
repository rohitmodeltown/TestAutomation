package javaBasic;

/*Write a Java program to display the following pattern. Go to the editor
Sample Pattern :

   J    a   v     v  a                                                  
   J   a a   v   v  a a                                                 
J  J  aaaaa   V V  aaaaa                                                
 JJ  a     a   V  a     a
*/

public class PatternDisplay {

	public static void main(String[] args) {

		System.out.print(" " + " " + " " + "J" + " " + " " + " " + " " + " " + "a" + " " + " " + "v" + " " + " " + " "
				+ " " + " " + "v" + " " + " " + "a" + "\n");
		System.out.print(" " + " " + " " + "J" + " " + " " + " " + " " + "a" + " " + "a" + " " + " " + "v" + " " + " "
				+ " " + "v" + " " + " " + "a" + " " + "a" + "\n");
		System.out.print("J" + " " + " " + "J" + " " + " " + " " + "a" + "a" + "a" + "a" + "a" + " " + " " + "V" + " "
				+ "V" + " " + " " + "a" + "a" + "a" + "a" + "a" + "\n");
		System.out.print(" " + "J" + "J" + " " + " " + " " + "a" + " " + " " + " " + " " + " " + "a" + " " + " " + "V"
				+ " " + " " + "a" + " " + " " + " " + " " + " " + "a" + "\n");

		/*
		 * Write a Java program to compute the specified expressions and print the
		 * output. Go to the editor Test Data: 
		 * ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5))
		 * Expected Output 2.138888888888889
		 */

		System.out.println(((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));

		/*
		 * Write a Java program to compute a specified formula. Go to the editor
		 * Specified Formula : 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) -
		 * (1.0/11)) Expected Output 2.9760461760461765
		 */

		System.out.println(4.0 * (1 - (1.0 / 3)) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11));

	}

}
