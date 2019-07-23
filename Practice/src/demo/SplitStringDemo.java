package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SplitStringDemo {

	public static void main(String[] args) {

		String a = "abcdefe";

		/*
		 * ArrayList<String> suut = new ArrayList<>();
		 * 
		 * suut.add(a);
		 */

		String[] arr = a.split("");

		for (String b : arr) {
		
			System.out.println(b);

		}
		
		  Set<String> unique = new HashSet<>();
		  
		  unique.add(a);
		  
		  for (String alp : unique) {
		  
		  System.out.println(alp); }
		 

	}

}
