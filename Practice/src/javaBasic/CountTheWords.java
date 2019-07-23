/**
 * 
 */
package javaBasic;

import java.util.Scanner;

/**
 * @author A1SKIVA4
 *
 */
public class CountTheWords {


    public static void main(String[] args)
    {
     /*   System.out.println("Enter the string");
 
        Scanner sc = new Scanner(System.in);
 
        String s=sc.nextLine();
 
        String[] words = s.trim().split(" ");
 
        System.out.println("Number of words in the string = "+words.length);
        */
        
    	System.out.println("Enter the string to be counted");
    	
    	Scanner scan = new Scanner(System.in);
    	
    	String input = scan.nextLine();
    	
    	String count[] = input.trim().split(" ");
    	
    	System.out.println(count.length);
        
    }
}
