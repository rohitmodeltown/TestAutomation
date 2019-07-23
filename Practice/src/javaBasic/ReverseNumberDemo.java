/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class ReverseNumberDemo {
	
	public static void main(String []args) {
		
		int number = 5432;
		int reminder, reverse = 0;
		
	/*	while(number!=0) {
			
			reminder = number%10;
			reverse = reverse*10+reminder;
			number = number/10;
		}
		
		System.out.println(reverse);*/
		
		while(number !=0) {
			
			reminder = number%10;
			reverse = reverse*10+reminder;
			number= number/10;
			
		}
		System.out.println(reverse);
		
	}

}
