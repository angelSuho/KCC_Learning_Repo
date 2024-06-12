package kosa.mission;

import java.util.Scanner;

public class Mission03 {

	public static void main(String[] args) {
		// 임의의 정수값에 대해서 전체 자리수 중 짝수, 홀수의 개수를 구하자
		// ex) 5자리 -> 12345
		// 짝수의 개수: 2개
		// 홀수의 개수: 3개
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		int cnt = 10;
		int even = 0;
		int odd = 0;

		int i = 0;
		int lgth = String.valueOf(num).length();
		while(lgth > i) {
			int currentNum = num % cnt;
			
			if (currentNum % 2 == 1) {
				odd++; 
			} else if (currentNum % 2 == 0) {
				even++;
			}
			num /= cnt;
			i++;
			
		}
		System.out.println("짝수: " + even);
		System.out.println("홀수: " + odd);

	}

}
