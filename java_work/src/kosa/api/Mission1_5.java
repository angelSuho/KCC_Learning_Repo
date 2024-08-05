package kosa.api;

import java.util.Scanner;

public class Mission1_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] str = input.split("");
		for (int i = 0; i < str.length/2; i++) {
			if (str[i].matches("[\\p{Alpha}]{1}")) {
				str = swap(str, i);
			}
		}
		
		String result = generateString(str);
		System.out.println(result);
		
	}

	private static String generateString(String[] str) {
		StringBuilder sb = new StringBuilder();
		for (String s: str) {
			sb.append(s);
		}
		return sb.toString();
	}

	private static String[] swap(String[] str, int i) {
		String tmp = str[str.length-1 - i];
		str[str.length-1 - i] = str[i];
		str[i] = tmp;
		return str;
	}
}
