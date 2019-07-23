/**
 * 
 */
package stringDemo;

/**
 * @author A1SKIVA4
 *
 */
public class CountCharacterOccurence {

	public static void main(String[] args)
    {
       /* String s = "Java is java again java again";
 
        int count = s.length() - s.replace("a", "").length();
 
        System.out.println("Number of occurances of 'a' in "+s+" = "+count);*/
    
		
		String words = "My Name is Rohit and I am looking for job good automation opportunity";
    
		int count = words.length() - words.replace("o", "").length();
		
		System.out.println(count);
    
    
    }
	

}
