package kosa.data;

import java.util.Scanner;
import java.util.Stack;

public class StackMission {
	public static void main(String[] args) {
		// 키보드로부터 수학수식을 입력
		// ((2+3)+10)) = 괄호 일치 / 불일치 판단
		Scanner sc = new Scanner(System.in);
	
		boolean isTrue = true;
		Stack<Character> stack = new Stack<>();
		
		System.out.print("수식 입력: ");
		String inputString = sc.nextLine();
		for (char ch : inputString.toCharArray()) {
			if (ch == '(') stack.push(ch);
			else if (ch == ')')
				if (stack.isEmpty()) {
					isTrue = false;
					break;
				} else if (stack.lastElement() == '(')
					stack.pop();
		}
		
		if (isTrue && stack.isEmpty())
			System.out.println("맞는 수식");
		else
			System.out.println("맞지 않은 수식");
	}
}
