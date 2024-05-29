package kosa.oop;

public class Book {
	private String bookName;
	private int price;
	private int discountPrice;
	
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
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	
}
