package kosa.game;

import java.util.Arrays;

public class RoundNumber {
	int number[];
	
	public RoundNumber() {
		this.number = generateRandomNumber();
	}
	
	public RoundNumber(String number) {
		this.number = new int[]{
				(int)(number.charAt(0)), 
				(int)(number.charAt(1)),
				(int)(number.charAt(2))
			};
	}

	public int[] getNumber() {
		return this.number;
	}
	
	public String printNum() {
		return Arrays.toString(number);
	}
	
	private int[] generateRandomNumber() {
		int[] tmp = new int[3];
		tmp[0] = (int) (Math.random() * 9) + 1;
		do {
			tmp[1] = (int) (Math.random() * 9) + 1;
		} while(tmp[0] == tmp[1]);
		do {
			tmp[2] = (int) (Math.random() * 9) + 1;
		} while(tmp[0] == tmp[2] && tmp[1] == tmp[2]);
		
		return tmp;
		
	}

}
