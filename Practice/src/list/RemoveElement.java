package list;

import java.util.LinkedList;
import java.util.List;

public class RemoveElement {

	public static void main(String[] args) {
		
		List<String> str = new LinkedList<>();

		str.add(0, "abc");
		str.add(1, "xyz");
		str.add(2, "lmn");
		str.add(3, "gsd");
		
		System.out.println(str.size());
		
		str.remove(1);
		
		if(str.remove("abc")) {
			System.out.println("Removed Element");
			
			System.out.println(str);
			
		}else {
			System.out.println("Element Not find to removed.");
		}
		
		for(String a : str) {
			str.clear();
		System.out.println(a);
		}

	}

}
