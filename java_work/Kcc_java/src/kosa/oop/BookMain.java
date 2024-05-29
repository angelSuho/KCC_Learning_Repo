package kosa.oop;

public class BookMain {

	public static void main(String[] args) {
		// 책값을 계산하는 프로그램을 만들어 보자
		Book[] arr = {
				new Book("JAVA", 30_000), 
				new Book("JSP", 20_000), 
				new Book("Oracle", 15_000)
			};

		int totalDiscountPrice = 0;
		for (Book book: arr) {
			book.generateDiscountedPrice();
			book.printBookPrice();
			totalDiscountPrice += book.getDiscountPrice();
		}
				
		System.out.println("총 금액: " + totalDiscountPrice + "원");
	}
}
