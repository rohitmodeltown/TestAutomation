package list;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterateList {

	public static void main(String[] args) {
	
	List<Integer> number = new LinkedList<>();
	
	number.add(6);
	number.add(9);
	number.add(5);
	number.add(7);
	number.add(1);
	
	//Collections.sort(number);
	Iterator<Integer> iterate = number.iterator();
	while(iterate.hasNext()) {
		System.out.println(iterate.next());
		
		System.out.println(number);
	}

	}

}
