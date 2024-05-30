package kosa.oop2;

public class User {
	private String name;
	private Long balance;
	
	public User() {}
	public User(String name, Long balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public boolean validateLunchPrice(Long price) {
		if (this.balance < price) {
			System.out.println("소지한 돈보다 높은 가격입니다.");
			return false;
		} else
			System.out.println("주문 가능합니다.");
		return true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Long getBalance() {
		return this.balance;
	}
}
