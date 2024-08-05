package kosa.mission;

import java.util.Scanner;

public class Mission2_1 {

	public static void main(String[] args) {
		// 국어, 영어, 수학 -> 키보드로 입력받아 배열로 구현하자.
		// 총점, 평균 구하기 -> 메소드 정의 구현
		Scanner sc = new Scanner(System.in);
		
		String subject[] = {"국어", "영어", "수학"};
		int arr[] = new int[5];
		
		for (int i = 0; i < 3; i++) {
			System.out.print(subject[i] + "입력: ");
			arr[i] = Integer.parseInt(sc.nextLine());
			arr[3] += arr[i];
		}
		
//		int language;
//		int english;
//		int math;
		
//		System.out.print("국어: ");
//		language = Integer.parseInt(sc.nextLine());
//		System.out.print("영어: ");
//		english = Integer.parseInt(sc.nextLine());
//		System.out.print("수학: ");
//		math = Integer.parseInt(sc.nextLine());
		
//		int[] grades = new int[] {language, english, math};
//		generateGrades(grades);
		generateGrades(arr);
		System.out.println("국어\t영어\t수학\t총점\t평균");
		for (int n: arr) {
			System.out.print(n + "\t");
		}
		
	}
	
	private static void generateGrades(int[] grades) {
//		int sum = 0;
//		for (int grade: grades) {
//			sum += grade;
//		}
//		System.out.println("총점: " + sum);
//		System.out.println("평균: " + sum / (float) grades.length);	
		grades[4] = grades[3] / 3;
	}

}
