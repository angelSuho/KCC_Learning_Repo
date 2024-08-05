package kosa.data;

public class Food {
	private String foodName;
	private long price;
	
	public Food() {}
	public Food(String foodName, long price) {
		this.foodName = foodName;
		this.price = price;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}	
	
	public void printFood() {
		System.out.print("메뉴: " + foodName + ", 가격: " + price + "원");
		System.out.println();
	}
}
