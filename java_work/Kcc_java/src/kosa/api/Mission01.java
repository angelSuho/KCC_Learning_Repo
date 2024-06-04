package kosa.api;

import java.util.Scanner;

public class Mission01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		char correct = sc.nextLine().charAt(0);
		
		int result = solution(input, correct);
		System.out.println(result);
	}
	
	public static int solution(String str, char c) {
		int answer = 0;
		
		str = str.toUpperCase();
		c = Character.toUpperCase(c);
		
		for (char ch: str.toCharArray()) {
			if (ch == c) answer++;
		}
		
		return answer;
	}
}
