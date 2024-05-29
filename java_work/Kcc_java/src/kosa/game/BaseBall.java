package kosa.game;

public class BaseBall {
	private int[] number;
	
	public BaseBall() {
		String randomNumber = String.valueOf((int) (Math.random() * 1000) + 100);
		number = new int[]{(int)(randomNumber.charAt(0)), 
				(int)(randomNumber.charAt(1)),
				(int)(randomNumber.charAt(2))};
	}
	
	public boolean isNumberEquals(String number, boolean isFlag) {
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < number.length(); i++) {
			if (!(this.number[i] == number.charAt(i))) {
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

	private boolean containsOtherPosition(String number, int i) {
		for (int num: this.number) {
			if (num == (int)number.charAt(i)) return true;
		}
		return false;
	}
}
