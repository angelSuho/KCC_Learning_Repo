package kosa.mission;

import java.util.Scanner;

public class Mission04 {

	public static void main(String[] args) {
		// 문자열 비교
//		String a = "abc";
//		String b = "abc";
//		
//		if (a == b) {
//			System.out.println("same");
//		} else {
//			System.out.println("different");
//		}
		
		// 두 정수와 연산자 문자열을 입력 받아
		// 사칙연산 결과를 출력하시오 (계산기)
		// ex)	정수1: 10
		//		정수2: 20
		// 		연산자: +
		// 		결과: 30
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("정수2 입력: ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("연산자 입력: ");
		String operater = sc.nextLine();
		
		if (operater.equals("+")) {
			System.out.println("결과: " + num1 + num2);
		} else if (operater.equals("-")) {
			System.out.println("결과: " + (num1 - num2));
		} else if (operater.equals("*")) {
			System.out.println("결과: " + num1 * num2);
		} else if (operater.equals("/")) {
			System.out.println("결과: " + num1 / num2);
		}
	}

}
