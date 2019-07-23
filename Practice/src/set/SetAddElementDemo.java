package set;

import java.util.HashSet;
import java.util.Set;

public class SetAddElementDemo {

	public static void main(String[] args) {

		Set<Integer> added = new HashSet<Integer>();
		added.add(5);
		added.add(7);
		added.add(5);
		added.add(8);
		added.add(7);
		added.add(9);

		System.out.println(added);

		for (int show : added) {

			System.out.println(show);
		}

	}

}
