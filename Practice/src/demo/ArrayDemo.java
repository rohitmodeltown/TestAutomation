package demo;

public class ArrayDemo {
	
	String [] name = {"Ram","Shyam","Dinesh","Rahul"};
		
	public void returnArrayResult() {
		
		System.out.println(name);
		
		for(String arraynames : name) {

			arraynames.indexOf(arraynames);
		
			System.out.println(arraynames);
		}
		
	for(int i=1;i<=50; i++) {
		
		System.out.println(i);
		
	if (i%2 ==0) {
		System.out.println("This is even number"+ i);
	}
	else if (i%2==1) {
		
		System.out.println("This is odd"+i);
		
	}
	else {
		System.out.println("All are prime number");
	}
	}	
		
	}

	public static void main(String[] args) {
		
		ArrayDemo obj = new ArrayDemo();
		obj.returnArrayResult();
	}
}
