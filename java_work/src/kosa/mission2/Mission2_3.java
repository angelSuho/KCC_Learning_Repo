package kosa.mission2;

import java.util.Scanner;

public class Mission2_3 {

	public static void main(String[] args) {
		// 격자판 최대합
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int maxTotal = calculateMaxTotal(arr);
		System.out.println(maxTotal);

	}
	
	private static int calculateMaxTotal(int[][] arr) {
		int maxTotal = Integer.MIN_VALUE;
		
		// 가로 세로
		for (int i = 0; i < arr.length; i++) {
			int rowSum = 0;
			int colSum = 0;
			for (int j = 0; j < arr.length; j++) {
				rowSum += arr[i][j];
				colSum += arr[j][i];
				
			}
//			System.out.println(rowSum);
//			System.out.println(colSum);
			if (maxTotal < rowSum) maxTotal = rowSum;
			if (maxTotal < colSum) maxTotal = colSum;
		}
		
		// 왼쪽, 오른쪽 대각선
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					leftSum += arr[i][j];
				}
				
				if (i + j == arr.length - 1) {
					rightSum += arr[i][j];
				}
			}
		}
//		System.out.println(leftSum);
//		System.out.println(rightSum);
		if (maxTotal < leftSum) maxTotal = leftSum;
		if (maxTotal < rightSum) maxTotal = rightSum;
		
		return maxTotal;
	}
}

