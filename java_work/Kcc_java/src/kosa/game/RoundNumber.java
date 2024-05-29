package kosa.game;

public class RoundNumber {
	int number[];
	
	public RoundNumber() {
		String randomNumber = String.valueOf((int) (Math.random() * 1000) + 100);
		this.number = new int[]{
				(int)(randomNumber.charAt(0)), 
				(int)(randomNumber.charAt(1)),
				(int)(randomNumber.charAt(2))
			};
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

}
