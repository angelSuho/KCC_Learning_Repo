package kosa.game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBallGame baseBall = new BaseBallGame();
		
		boolean isFlag = true;
		int idx = 0;
		while (isFlag) {
			idx++;
			String number = sc.nextLine();
			RoundNumber inputNumber = new RoundNumber(number);
			isFlag = baseBall.isNumberEquals(inputNumber, isFlag);
		}
		
		System.out.println(idx + "번째 성공");
	}
}

