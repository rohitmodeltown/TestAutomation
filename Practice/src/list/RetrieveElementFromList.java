package list;

import java.util.List;

import org.openqa.selenium.remote.server.handler.GetAlertText;

import java.util.LinkedList;

public class RetrieveElementFromList {

	public static void main(String[] args) {
	
		List<String> retrieve = new LinkedList<>();
		retrieve.add("23");
		retrieve.add("Angadh");
		retrieve.add("Sagar");
		retrieve.add("786345");
		retrieve.add("Mohit");
		retrieve.add("Raushan");
		retrieve.add("Vishal");
		retrieve.add("Meenakshi");
		
		System.out.println(retrieve);
		
		
		System.out.println(retrieve.get(5));
		
		
		String num = retrieve.get(3);
		
		System.out.println(num);
		

	}

}
