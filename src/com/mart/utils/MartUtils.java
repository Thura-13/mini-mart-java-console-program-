package com.mart.utils;

import java.util.Scanner;

public class MartUtils {

	private static Scanner sc = new Scanner(System.in);
	
	public static int readInt (String message) {

		for (;;) {
			try {
				return Integer.parseInt(readString(message));
			} catch (NumberFormatException e) {
				System.out.println("Please enter valid operatoin no: ");
			} 
		}
	}
	
	public static String readString(String message) {
		
		System.out.println(message);
		
		
		return sc.nextLine().trim();
	}
}
