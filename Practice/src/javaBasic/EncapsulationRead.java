/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class EncapsulationRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EncapsulationTest en = new EncapsulationTest();
		en.setName("Ram Ratan");
		en.setRollNum(44);
		en.setStuClass("VI");
		
		System.out.println(en.getName());
		System.out.println(en.getRollNum());
		System.out.println(en.getStuClass());
		
		System.out.println(en.getName()+en.getRollNum()+en.getStuClass());
		

	}

}
