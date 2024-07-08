package kosa.game;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
	private RoundNumber roundNumber;
	List<Integer> successIdx = new ArrayList<>();
	
	public BaseBallGame() {
		roundNumber = new RoundNumber();
	}
	
	public String getRoundNumber() {
		return this.roundNumber.printNum();
	}
	
	public boolean isNumberEquals(RoundNumber number, boolean isFlag) {
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < number.getNumber().length; i++) {
			if (!(this.roundNumber.getNumber()[i] == number.getNumber()[i] - 48)) {
				if (containsOtherPosition(number, i)) {
					ball++;
				}
			} else {
				strike++;
				successIdx.add(number.getNumber()[i]);
			}
		}
		
		isFlag = printGameResult(isFlag, strike, ball);
		return isFlag;
	}

	private boolean printGameResult(boolean isFlag, int strike, int ball) {
		if (strike == 3) {
			System.out.println(strike + "S" + ball + "B");
			System.out.println("3Strike");
			isFlag = false;
		} else {
			System.out.println(strike + "S" + ball + "B");
		}
		return isFlag;
	}

	private boolean containsOtherPosition(RoundNumber number, int i) {
		for (int num: this.roundNumber.getNumber()) {
			if (num == (int)number.getNumber()[i] && !successIdx.contains(num)) return true;
		}
		return false;
	}
}
