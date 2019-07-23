package list;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.scene.chart.PieChart.Data;

import java.util.LinkedList;

public class LinklistAddElement {

	public static void main(String[] args) {

		List<Integer> listnumber = new LinkedList<Integer>();
		listnumber.add(9);
		listnumber.add(2);
		listnumber.add(3);
		listnumber.add(3);
		listnumber.add(7);
		listnumber.add(4);

		// This is unordered list

		System.out.println(listnumber);
		
		List<String> str  = new LinkedList<>();
		
		str.add(0, "abc");
		str.add(1, "xyz");
		str.add(2, "lmn");
		str.add(3, "gsd");
	
		
		
		System.out.println(str);


		// This is sorted list with the help Set Interface and Treeset Class sort the data
		Set<String> sort = new TreeSet<>(str);

		System.out.println(sort);
		
	
	}

}
