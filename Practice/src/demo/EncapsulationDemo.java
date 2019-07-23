package demo;

public class EncapsulationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emp obj = new Emp();
		obj.setAbc(6);
		obj.setXyz("HCL");
		
		System.out.println(obj.getAbc());
		System.out.println(obj.getXyz());
		

	}
}
	class Emp {

		private int i;
		private String name;

		public void setAbc(int ii) {
			i=ii;
		}

		public int getAbc() {
			return i;	
			
		}
		
		public void setXyz(String namei) {
			name = namei;
		}
		public String getXyz() {
			return name;
		}

	}

