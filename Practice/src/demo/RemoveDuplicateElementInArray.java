package demo;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateElementInArray {

	public static void main(String[] args) {
		
		int a[] = { 1, 2, 34, 2, 35, 8, 4, 4, 8, 3, 9, 34 };

		int len = a.length;

		 System.out.println("The lenght of an array is:" +" "+len);

		Set<Integer> duplicate = new HashSet<Integer>();

		for (int i : a) {

			duplicate.add(i);
		

		}
		for (int du : duplicate) {

			System.out.println(du + ",");

		}

		ArrayList<Integer> b = new ArrayList<>();

		b.addAll(duplicate);
		Collections.sort(b);
		System.out.println(b);
		
		
		/*
		 * Arrays.sort(); System.out.println(b);
		 * //System.out.println("modified"+Arrays.toString(a));
		 */

	}

}
