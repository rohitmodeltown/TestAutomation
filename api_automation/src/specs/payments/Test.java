package specs.payments;

import helpers.GlobalHelper;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		
		GlobalHelper global = new GlobalHelper();
		String abc = global.readFromPropertiesFile("./src/utility/test.properties", "name");
		
		System.out.println("properties test: "+abc);
		
		

	}

}
