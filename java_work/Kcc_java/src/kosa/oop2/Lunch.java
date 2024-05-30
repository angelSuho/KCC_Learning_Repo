package kosa.oop2;

public class Lunch {
	private String name;
	private Long price;
	
	public Lunch() {}
	public Lunch(String name, Long price) {
		this.name = name;
		this.price = price;
	}
	
	public void printLunch() {
		System.out.println("메뉴 이름: " + this.name);
		System.out.println("가격: " + this.price + "원");
		System.out.println();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Long getPrice() {
		return this.price;
	}
}
