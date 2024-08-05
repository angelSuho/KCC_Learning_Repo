package kosa.mission2;

import java.util.Scanner;

public class Mission2_4 {

	public static void main(String[] args) {
		// 갤러그 문제
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		for (int task = 0; task < t; task++) {
			int jonghyun = sc.nextInt();
			int jongwon = sc.nextInt();
			
			int day = calculateOverDate(jonghyun, jongwon);
			System.out.println("#" + (task + 1) + " " + day);
		}

	}
	
	private static int calculateOverDate(int a, int b) {
		int day = 1;
		while(true) {
			a *= 2;
			b *= 3;
			if (a < b) return day;
			day++;
		}
	}

}
