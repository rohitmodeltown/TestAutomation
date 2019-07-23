/**
 * 
 */
package demo;

/**
 * @author A1SKIVA4
 *
 */
public class SplitURL {
	
	public static void main(String []args) {
		
		String url = "https://apbuat.airtelbank.com/Cybersafe";
		
		String []x= url.split("/");
		
		
		for(String y : x) {
			
			System.out.println(y);
		}
	}
	

}
