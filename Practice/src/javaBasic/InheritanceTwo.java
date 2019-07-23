/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class InheritanceTwo extends InheritanceTest{

	int a = 50;
	String inheri_name = "This Second Name";
	
	public void showName() {
		System.out.println(a);
		System.out.println(super.a);
	}
	
	public void getIntData() {
		
		System.out.println(inheri_name);
	}
	

}
