package kosa.restaurant;

public class MenuItem {
	private String name;
	private long price;
	private String desription;
	
	public MenuItem() {}
	public MenuItem(String name, long price, String description) {
		this.name = name;
		this.price = price;
		this.desription = description;
	}
	
	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public String getDesription() {
		return desription;
	}
	
	public void print() {
		System.out.print("메뉴 이름: ");
		System.out.println(this.name);
		System.out.print("가격: ");
		System.out.println(this.price + "원");
		System.out.print("메뉴 설명: ");
		System.out.println(this.desription);
	}
}
