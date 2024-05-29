package kosa.game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBall baseBall = new BaseBall();
		
		boolean isFlag = true;
		while (isFlag) {
			String number = sc.nextLine();
			
			isFlag = baseBall.isNumberEquals(number, isFlag);
		}
	}
}

