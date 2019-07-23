/**
 * 
 */
package javaBasic;

import java.io.*;

/**
 * @author A1SKIVA4
 *
 */
public class ReadTextFile {

	public static void main(String[] args) throws Exception  {
		
	/*	FileReader textfile = new FileReader("D:\\Airtel\\API Specs\\CYS_To_PG.txt");
		BufferedReader read = new BufferedReader(textfile);
		
		String plainfile = null;
		
	//	System.out.println(plainfile);
		
		while((plainfile = read.readLine()) != null) {
			
			System.out.println(plainfile);
		}
		
		textfile.close();
		read.close();*/
	
	
	
/*	
	FileReader reading = new FileReader("D:\\Airtel\\testtemp.txt");
	
	BufferedReader bf = new BufferedReader(reading);
	
	
	System.out.println(bf.readLine());*/
		
		
		FileReader readfile = new FileReader("D:\\Airtel\\testtemp.txt");
		
		BufferedReader read = new BufferedReader(readfile);
		
		System.out.println(read.readLine());
	
	
	
	}
	
}
