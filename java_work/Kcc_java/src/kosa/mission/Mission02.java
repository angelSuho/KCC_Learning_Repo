package kosa.mission;

import java.util.Scanner;

public class Mission02 {

	public static void main(String[] args) {
		// 성적관리 구현
		// 국어, 영어, 수학 점수를 키보드로부터 입력받고
		// 총점과 평균을 출력하세요. (단, 평균은 실수형)
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 입력: ");
		int language = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수 입력: ");
		int english = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수 입력: ");
		int math = Integer.parseInt(sc.nextLine());
		
		int sum = language + english + math;
		float average = sum / 3f;
		int averageInt = (int) (sum / 3f);
		System.out.println("총점: " + sum);
		System.out.println("평균: " + averageInt);
		byte d = 10;
		int a = 1 + d;
		byte qwe = (byte) (d + d);
		float b = d  +a;
	}

}
