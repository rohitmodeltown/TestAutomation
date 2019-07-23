package javaBasic;

/*Write a Java program to print the area and perimeter of a circle:
	
Radius = 7.5 
Expected Output
Perimeter is = 47.12388980384689 
Area is = 176.71458676442586*/

/*formula of area = 3.14 * (R*R) */
/*formula of Parameter = 2 * 3.14 * R*/

public class AreaParameterCircle {

	public static void main(String[] args) {
	
	double ra = 7.5;
	double pai = 3.14;

/*
		double radius = 7.5;
		double pai = 3.14;
		double b =8;
		
		System.out.println("Perimeter of Circle"+" "+(2*radius*pai));
		System.out.println("Area of Circle is"+" "+ (pai*radius*radius));*/
		
/*		'
		 perimeter of circle is 2*pia*R
		Area of circle  is pai R square*/
	
		System.out.println("Perimeter of circl:"+ pai*(ra*ra));
		System.out.println();
		
		
		
	}

}
