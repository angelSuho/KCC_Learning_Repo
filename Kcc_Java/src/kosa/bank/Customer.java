package kosa.bank;

public class Customer {
	private String id;
	private String name;
	private Account account;
	
	public Customer() {}
	public Customer(String id, String name, long balance) {
		this.id = id;
		this.name = name;
		setAccount(new Account(id, balance));
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return this.account;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
