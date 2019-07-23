package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIterator {

	public static void main(String[] args) {
		
		Map<String, String> mapcodes = new HashMap<>();
		
		mapcodes.put("2","Tutorials");
		mapcodes.put("4", "Classes");
		mapcodes.put("1", "Night");
		mapcodes.put("8", "Day");
		
		System.out.println("Current code 1: "+mapcodes);
		
		Set<String> code = mapcodes.keySet();
		
		System.out.println("After putting into set 2:"+code);
		
		Iterator<String> iterator = code.iterator();
		
		System.out.println("Iteration result 3:"+iterator);
		
		while(iterator.hasNext()) {
			
			String newcode = iterator.next();
			String tuto = mapcodes.get(newcode);
			
			System.out.println(newcode + tuto);
		}
		
		
		

	}

}
