package kosa.game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBallGame baseBall = new BaseBallGame();
		
		System.out.println("정답: " + baseBall.getRoundNumber());
		System.out.println("게임 도전");
		boolean isFlag = true;
		int idx = 0;
		while (isFlag) {
			idx++;
			System.out.print("숫자 입력(3자리): ");
			String number = sc.nextLine();

			RoundNumber inputNumber = new RoundNumber(number);
			isFlag = baseBall.isNumberEquals(inputNumber, isFlag);
		}
		
		System.out.println(idx + "번째 성공");
	}
}

