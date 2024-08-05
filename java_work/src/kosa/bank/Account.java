package kosa.bank;

public class Account {
	private String id;
	private long balance;
	
	public Account() {}
	public Account(String id, long balance) {
		this.id = id;
		this.balance = balance;
	}
	
	public void deposit(long amount) {
		this.balance += amount;
	}
	
	public boolean withdraw(long amount) {
		if (amount > this.balance) {
			return false;
		} 
		this.balance -= amount;
		return true;
	}
	
	public String getId() {
		return this.id;
	}
	
	public long getBalance() {
		return this.balance;
	}
}
