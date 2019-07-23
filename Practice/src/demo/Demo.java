package demo;

public class Demo {

	int age;
	String name = "RamNath";
	boolean status = true;
	float bal = 49.0f;
	double money = 588;
	char variable;

	public int show(int b) {

		return b;

	}

	public void setAge(int a) {

		int age = a;
	}

	public int getAge() {

		return age;
	}

	public static void main(String []args) {

		Demo obj = new Demo();
		obj.setAge(12);
		obj.getAge();
		System.out.println(obj.getAge());

	}

}
