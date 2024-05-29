package kosa.game;

public class BaseBallGame {
	private RoundNumber roundNumber;
	
	public BaseBallGame() {
		roundNumber = new RoundNumber();
	}
	
	public boolean isNumberEquals(RoundNumber number, boolean isFlag) {
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < number.getNumber().length; i++) {
			if (!(this.roundNumber.getNumber()[i] == number.getNumber()[i])) {
				if (containsOtherPosition(number, i)) {
					ball++;
				}
			} else {
				strike++;
			}
		}
		
		isFlag = printGameResult(isFlag, strike, ball);
		return isFlag;
	}

	private boolean printGameResult(boolean isFlag, int strike, int ball) {
		if (strike == 3) {
			System.out.println("3Strike");
			isFlag = false;
		} else {
			System.out.println(strike + "S" + ball + "B");
		}
		return isFlag;
	}

	private boolean containsOtherPosition(RoundNumber number, int i) {
		for (int num: this.roundNumber.getNumber()) {
			if (num == (int)number.getNumber()[i]) return true;
		}
		return false;
	}
}
