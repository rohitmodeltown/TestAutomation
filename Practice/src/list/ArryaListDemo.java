package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArryaListDemo {

	public static void main(String[] args) {
		
		List<Integer> listnum = new ArrayList<Integer>();
		listnum.add(5);
		listnum.add(0, 4);
		listnum.add(1, 7);
		listnum.add(3, 9);
	
	//	Collections.sort(listnum);
		System.out.println(listnum);
	}

}
