package kosa.mission2;

import java.util.Scanner;

public class Mission2_2 {

	public static void main(String[] args) {
		// 보이는 학생
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = generateBiggerStudentCount(arr);
		System.out.println(cnt);
	}

	private static int generateBiggerStudentCount(int[] arr) {
		int max = arr[0];
		int cnt = 1;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				cnt++;
			}
		}
		
		return cnt;
	}
}
