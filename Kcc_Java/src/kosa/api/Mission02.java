package kosa.api;

import java.util.Scanner;

public class Mission02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		String[] arr = input.split(" ");
		
		String result = searchingMaxLengthStr(arr);
		System.out.println(result);
	}

	private static String searchingMaxLengthStr(String[] arr) {
		String result = "";
		for (String str: arr) {
			if (result.length() < str.length()) {
				result = str;
			}
		}
		
		return result;
	}
}
