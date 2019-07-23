/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class SplitString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "RAKUAMR";

		/*System.out.println(name);

		String[] newtxt = name.split("");
		
		System.out.println("\n");
		
		for (String newstring : newtxt) {
			
			System.out.println(newstring);
		}*/
		
		System.out.println(name);
		
		String [] a = name.split("");
		
		for(String newver : a) {
			
			System.out.println(newver);
		}
		

	}

}
