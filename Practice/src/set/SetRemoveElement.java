package set;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class SetRemoveElement {

	public static void main(String[] args) {
		
		int[] a = { 56,6,7,8,5,3,76,47,4,1,2,7,8,93};
		
		Set<Integer> data = new HashSet<Integer>();
		
		data.remove(a);
		
		//System.out.println(data.remove(a));
		
		System.out.println(data);
		
		
		

	}

}
