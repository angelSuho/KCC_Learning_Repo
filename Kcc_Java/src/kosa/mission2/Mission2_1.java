package kosa.mission2;

import java.util.Scanner;

public class Mission2_1 {

	public static void main(String[] args) {
		// 큰 수 출력하기
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		printBiggerNumber(n, arr);
	}

	private static void printBiggerNumber(int n, int[] arr) {
		int idx = 0;
		System.out.print(arr[idx++] + " ");
		for (int i = idx; i < n; i++) {
			if (arr[i] > arr[i-1]) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}
