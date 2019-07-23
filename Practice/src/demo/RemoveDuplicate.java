/**
 * 
 */
package demo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.util.*;



/**
 * @author A1SKIVA4
 *
 */
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[]num  = {1,3,4,654,6,7,4,8,97,8,9,5,3,2};
		
		int len = num.length;
		
		System.out.println(len);
		
		Set<Integer> duplicate = new HashSet<Integer>();
		
		for(int a : num) {
			
			duplicate.add(a);
			
		}
		for(int du : duplicate) {
			
			System.out.println(du);
			
		}
		
		ArrayList <Integer> allList = new ArrayList<>();
		allList.addAll(duplicate);
		System.out.println(allList);
		
	

	}

}
