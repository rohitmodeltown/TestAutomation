package list;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UpdateElement {

	public static void main(String[] args) {

		List<Integer> listnumber = new LinkedList<Integer>();
		listnumber.add(9);
		listnumber.add(2);
		listnumber.add(3);
		listnumber.add(3);
		listnumber.add(7);
		listnumber.add(4);

		// Set method is used to updated index value.

		listnumber.set(3, 19);
		listnumber.set(5, 22);

		System.out.println(listnumber);

		/* After updating the element lets sort it. */

		Set<Integer> sortElement = new TreeSet<Integer>(listnumber);

		for (int sort : sortElement) {
			
			System.out.println(sort);
		}

	}

}
