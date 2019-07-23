package set;

import java.util.HashSet;
import java.util.Set;

public class SetAddString {

	public static void main(String[] args) {
	
		Set<String> added = new HashSet<String>();
		added.add("Ram");
		added.add("Shyam");
		added.add("Daam");
		
		System.out.println(added.size());
		
		if(!added.add("Ram")) {
			System.out.println("This is set with name Ram");
		}
		

	}

}
