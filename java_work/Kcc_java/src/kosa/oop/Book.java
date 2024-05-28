package kosa.oop;

public class Book {
	String bookName;
	int price;
	int discountPrice;
	
	public Book() {}
	public Book(String bookName, int balance) {
		this.bookName = bookName;
		this.price = balance;
	}
	
	public void generateDiscountedPrice() {
		if (this.price >= 30_000) {
			this.discountPrice = (int) (this.price * 0.75f);
		} else if (this.price >= 20_000) {
			this.discountPrice = (int) (this.price * 0.80f);
		} else if (this.price >= 15_000) {
			this.discountPrice = (int) (this.price * 0.85f);
		}
	}
	
	public void printBookPrice() {
		System.out.println(this.bookName + " 교재는 정가는 " + 
				this.price + "원 할인된 가격은 " + this.discountPrice + "원 입니다.");
	}
}
