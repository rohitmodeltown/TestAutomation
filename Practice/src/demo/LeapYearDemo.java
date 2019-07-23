/**
 * 
 */
package demo;

/**
 * @author A1SKIVA4
 *
 */
public class LeapYearDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int year  = 1999;
		
		if ( year%4==0 && year%100 == 0 && year%400 ==0) {
			
			System.out.println(year+"This is leapyear");
		}else {
			System.out.println(year+"THis is not leap year.....");
		}

	}

}
