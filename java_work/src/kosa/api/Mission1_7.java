package kosa.api;

import java.util.Scanner;

public class Mission1_7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		boolean isPalindrome = true;
		for (int i = 0; i < input.length() / 2; i++) {
			char c1 = Character.toLowerCase(input.charAt(i));
			char c2 = Character.toLowerCase(input.charAt(input.length()-1-i));
			if (c1 != c2)
				isPalindrome = false;
		}
		
		if (isPalindrome)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
