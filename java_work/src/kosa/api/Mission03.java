package kosa.api;

import java.util.Scanner;

public class Mission03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		int result = generateNumber(input);
		System.out.println(result);
	}

	private static int generateNumber(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c: input.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		
		int result = Integer.parseInt(sb.toString());
		return result;
	}
}
