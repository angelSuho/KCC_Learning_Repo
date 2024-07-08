package kosa.oop;

public class MinusAccount extends Account {
	private int creditLine;	// 마이너스 한도
	
	public MinusAccount() {}
	public MinusAccount(String accountNo, String ownerName, int balance,
			int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	// 오버라이딩
	// 1. 상속관계
	// 2. 메소드 시그너처 (접근제어자, 리턴형, 이름, 파라미터) 일치
	// 3. 메소드의 내용 불일치 (재정의)
	@Override
	public int withdraw(int amount) throws Exception {
		if (getBalance() + this.creditLine < amount) {
			throw new Exception("한도 초과");
		}
		setBalance(this.balance - amount);
		
		return amount;
	}

}
