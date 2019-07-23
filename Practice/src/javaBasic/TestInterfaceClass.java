/**
 * 
 */
package javaBasic;

/**
 * @author A1SKIVA4
 *
 */
public class TestInterfaceClass implements TestInterface {

	@Override
	public void showName() {

		System.out.println("ShowNameResult");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaBasic.TestInterface#getData()
	 */
	@Override
	public void getData() {
		// TODO Auto-generated method stub

		System.out.println("GetDataResult");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaBasic.TestInterface#returnValue()
	 */
	@Override
	public void returnValue() {
		// TODO Auto-generated method stub

		System.out.println("returnValue Result");
	}

	public static void main(String[] args) {

		TestInterfaceClass olj = new TestInterfaceClass();
		olj.showName();
		olj.getData();
		olj.name();
		olj.global();
		olj.returnValue();
	}

/*	
	 * (non-Javadoc)
	 * 
	 * @see javaBasic.TestCheck#global()
	 
	public int global(int z) {
		return z;
	}

	public String name(String o) {

		return o;
	}*/

	/* (non-Javadoc)
	 * @see javaBasic.TestCheck#global()
	 */
	@Override
	public int global() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see javaBasic.TestCheck#name()
	 */
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return  null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javaBasic.TestCheck#global()
	 */

}
