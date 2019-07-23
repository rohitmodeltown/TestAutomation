package list;

import java.util.LinkedList;
import java.util.List;

public class SearchElement {

	public static void main(String[] args) {

		List<String> retrieve = new LinkedList<>();
		retrieve.add("23");
		retrieve.add("Angadh");
		retrieve.add("Sagar");
		retrieve.add("786345");
		retrieve.add("Mohit");
		retrieve.add("Raushan");

		if (retrieve.contains("Sagar")) {
			
		} if (retrieve.contains("Mohit")) {
			
			System.out.println("Value contains" + " " + retrieve.contains("Sagar"));
		}

		else {

			System.out.println("Value not present");
			System.out.println("Value contains" + " " + retrieve.contains("MOhit"));
		}
		
		int value = retrieve.indexOf("Sagar");
		
		System.out.println(value);

	}

}
