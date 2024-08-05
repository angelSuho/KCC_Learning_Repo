package kosa.oop;

public class AccountMain {

	public static void main(String[] args) {
		Account account;	// 참조형(클래스 타입)
		account = new Account("1111-1111", "이수호", 23000);	// 객체 생성(메모리 할당)

		
		
//		account.accountNo = "111-111";
//		account.ownerName = "이수호";
//		account.balance = 10000;
		
//		account.deposit(5000);
		try {
			account.withdraw(13000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("계좌번호: " + account.accountNo);
		System.out.println("계좌주: " + account.ownerName);
		System.out.println("잔액: " + account.balance);
		
		
		
		
		
	}

}
