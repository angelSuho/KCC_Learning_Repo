package kosa.oop;

public class Account {
	// 계좌 객체 생성하기 위해 
	// 객체로부터 공통된 데이터 구조와 기능을 추출
	// 상태 (데이터): 계좌번호, 계좌주, 잔액 -> 멤버변수
	// 행동(기능): 입금한다, 출금한다 -> 멤버메소드
	String accountNo;	// 계좌번호
	String ownerName;	// 계좌주
	int balance;		// 잔액
	
	// 생성자, 오버로딩 
	// 생성자
	// 생성자 역할
	// 생성자 호출 시점
	// 생성자 구현 방법
	public Account() {} // default 생성자(기본적으로 아무런 생성자가 없다면,자동 생성됨)
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	// 입급한다.
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	// 출금한다.
	public int withdraw(int amount) throws Exception {
		if (balance < amount) {
			throw new Exception("잔액 부족");
		}
		
		this.balance -= amount;
		return amount;
	}
	
	
}
