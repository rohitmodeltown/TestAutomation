/**
 * 
 */
package javaBasic;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

/**
 * @author A1SKIVA4
 *
 */
public class FiboniccSeries {

	public static void main(String[] args) {
		
		int a = 0, b=1, c;
		
		System.out.println("curent value of a is "+ a +"and B is "+b);
		
		for(int i=0; i<= 5 ; i++) {
			
			c=a+b;
			System.out.println("current value of C is " +c);
			
			a = b;
			System.out.println("Latest value of a is " +a);
			
			b = c;
			System.out.println("New Value of b is " +b);
		}
		
		
	
		
		/*
		 * int count = 8; int num1 = 0; int num2 = 1; int sumOfTwoNum;
		 * 
		 * for (int i = 0; i <= count; ++i) {
		 * 
		 * // System.out.println("Total count is:"+ count);
		 * 
		 * System.out.println(num1);
		 * 
		 * sumOfTwoNum = num1 + num2; num1 = num2; num2 = sumOfTwoNum;
		 * 
		 * }
		 */

		int count1 = 9;
		int num1 = 0;
		int num2 = 1;
		int sumofcount;
		int count;

		Scanner scan = new Scanner(System.in);

		count = scan.nextInt();

		for (int i = 0; i <= count; ++i) {
			// System.out.println(count);

			sumofcount = num1 + num2;

			num1 = num2;

			num2 = sumofcount;

			System.out.println(num2);
		}

	}

/*	public void failTestCase(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
		
		try {
			
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, "./screenshot/.png");
		
		}catch(Exception e){
			
		}
			
		}
		
	}*/
}
