package kosa.basic;

import java.util.Scanner;

public class LoopExam01 {

	public static void main(String[] args) {
		// while: 초기식 -> 조건식 -> 명령문 -> 증감식: 수직방향
		// 1~10까지 합
//		int sum = 0;
//		
//		int i = 1;
//		while (i <= 10) {
//			sum += i;
//			i++;
//		}
//		
//		System.out.println("1~10까지의 합: " + sum);
		
		// 퀴즈 > 구구단 7단 출력
//		int multipleNum = 7;
//		int i = 1;
//		while(i <= 9) {
//			System.out.println(multipleNum + " * " + i + " = " + multipleNum*i);
//			i++;
//		}
//		
		// 퀴즈 > 1~100까지 2의 배수와 3의 배수가 아닌 숫자만 출력하시오
//		for (int i = 1; i <= 100; i++) {
//			if (!(i % 2 == 0 || i % 3 == 0))
//				System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		for (int i = 1; i <= 100; i++) {
//			if (i % 2 == 0 || i % 3 == 0) { 
//				continue;
//			}
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		// do-while 문: 명령문을 한번은 시작되어야할 때,
		// ex) 음수를 입력받아서 다시 입력을 받아야할 때,
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
//		do {
//			System.out.print("입력: ");
//			n = Integer.parseInt(sc.nextLine());
//		} while(n <= 0);
//		
//		System.out.println("입력 결과: " + n);
//		
		// 퀴즈 > 2개의 정수를 입력 받아 b - a 결과 출력 하자.
		// b > a 되도록 입력 -> a가 b보다 크면 새로 입력 받도로 하자.
//		int a;
//		int b;
//		do {
//			System.out.print("a 입력: ");
//			a = Integer.parseInt(sc.nextLine());
//			System.out.print("b 입력: ");
//			b = Integer.parseInt(sc.nextLine());
//		} while (a >= b);
//		
//		System.out.println("a: " + a);
//		System.out.println("b: " + b);
		
		// 퀴즈 > 1 ~ 9
//		int num = (int) (Math.random() * 9) + 1;
//		System.out.println(num);
		
		// 퀴즈 > 임의의 난수 3개 받아서 서로 중첩되지 않고 출력하기
		int a, b, c;
		a = (int) (Math.random() * 9) + 1;
		do {
			b = (int) (Math.random() * 9) + 1;
			c = (int) (Math.random() * 9) + 1;
		} while (a == b || a == c || b == c);
		
		System.out.println("a: " + a + ", b: " + b + ", c:  " + c);
		
		
	}

}
