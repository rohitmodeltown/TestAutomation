/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class EncapsulationTest {
	
	private String name;
	private String stu_class;
	private int rollno;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setStuClass(String stu_class) {
		this.stu_class = stu_class;
		
	}
	
	public void setRollNum(int roll) {
		
		this.rollno = roll;
	}
	
	public int getRollNum() {
		return rollno;
	}
	

	public String getName() {
		
		return name;
	}
	
	public String getStuClass() {
		
		return stu_class;
	}
}

