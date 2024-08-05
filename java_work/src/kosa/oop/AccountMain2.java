package kosa.oop;

public class AccountMain2 {
	
	public static void main(String[] args) {
//		CheckingAccount checkingAccount = new CheckingAccount(
//					"111-111", "홍길동", 10000, "222-222"
//				);
//		
//		try {
//			checkingAccount.pay("222-222",  3000);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println(checkingAccount.getBalance());
		
//		MinusAccount minusAccount = new MinusAccount("111-111", "홍길동", 10000, 10000);
//		
//		try {
//			int amount = minusAccount.withdraw(15000);
//			System.out.println(minusAccount.getBalance());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		// 업캐스팅
		// 부모로 형변환
//		Account account = new CheckingAccount("111-111", "홍길동", 10000, "222-222");
		// 다운캐스팅
//		CheckingAccount checkingAccount = (CheckingAccount) account;
		
//		Account account = new Account("111", "김길동", 1000);
//		CheckingAccount ca = (CheckingAccount) account;	// 예외 발생
//		try {
//			if (account instanceof CheckingAccount)
//				((CheckingAccount) account).pay("222-222",  3000);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println(account.getBalance());
		
		Account[] arr = {
				new Account("111-111", "홍길동", 10000),
				new CheckingAccount("111-111", "홍길동", 20000, "222-222"),				
				new MinusAccount("111-111", "홍길동", 30000, 20000)
		};
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof CheckingAccount) {
				try {
					CheckingAccount ca = (CheckingAccount) arr[i];
					ca.pay("222-222", 5000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		System.out.println(arr[1].getBalance());
	}
}