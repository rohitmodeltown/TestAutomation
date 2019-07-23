package javaBasic;


/*13. Write a Java program to print the area and perimeter of a rectangle. Go to the editor
Test Data:
Width = 5.5 Height = 8.5

Expected Output
Area is 5.6 * 8.5 = 47.60
Perimeter is 2 * (5.6 + 8.5) = 28.20
*/

public class AreaParimeterRectangle {

	public static void main(String[] args) {
		
		double length = 5.5;
		double width =  8.5;
		
		System.out.println(length*width);
		System.out.println(2*(length+width));
		

	}

}
