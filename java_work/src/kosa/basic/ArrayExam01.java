package kosa.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayExam01 {

	public static void main(String[] args) {
		// 1. 배열 선언, 생성 분리
		int arr[];			// 배열 선언
		arr = new int[5];	// 배열 생성(초기화: 메모리 할당)

		// 2. 배열 선언, 생성 동시에
		int arr2[] = new int[5];
		arr2[0] = 10;
		arr2[1] = 20;
		
		// 3. 배열 선언, 생성, 초기화 함께
		int arr3[] = {1, 2, 3, 4, 5};
		
		// 배열에 있는 내용 전체 출력 for(0 ~ 4)
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "]=" + arr3[i]);
		}
		
		// 향상된 for문
		for (int n: arr3) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		/**
		 * 배열 사용 방법
		 * 1. 배열에 사용될 데이터 타입을 결정
		 * 2. 배열의 크기르 결정(초기화) -> ArrayIndexOfBoundsException 예외 발생
		 * 3. 배열 생성 방법 선택 -> 1, 2, 3
		 * 4. 배열은 어떻게 초기화 -> 직접 인덱스 접근, for문, 생성과 초기화
		 * 5. 배열의 데이터 어떻게 출력 -> for문, 향상된 for문, 직접 인덱스
		 * 
		 * */
		
		// 퀴즈 > 키보드로부터 문자열을 입력받아 배열에 추가한 후, 전체를 출력하자.
		// "q"를 입력할 때까지 입력 받는다.
		String[] array = new String[100];
		Scanner sc = new Scanner(System.in);
		
		int arrIdx = 0;
		while(true) {
			System.out.print("입력: ");
			String input = sc.nextLine();
			
			if (input.equals("q")) break;
			array[arrIdx++] = input;
		}
		
		for (int i = 0; i < arrIdx; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
