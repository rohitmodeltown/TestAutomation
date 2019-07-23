/**
 * 
 */
package demo;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author A1SKIVA4
 *
 */
public class RandomString {

	public static void main(String[] args) {
		
		String ALPHA_NUM ="ioieroj";
		int len = 5;
		
		String p="";

		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			int ndx = (int) (Math.random() * ALPHA_NUM.length());
		StringBuffer p1 = sb.append(ALPHA_NUM.charAt(ndx));
		System.out.println(p1);
		}
		/*
		 * String p = RandomStringUtils.randomAlphabetic(17); System.out.println(p);
		 */
	}

}
