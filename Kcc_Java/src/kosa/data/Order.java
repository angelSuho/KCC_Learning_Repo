package kosa.data;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Food> foods;
	private long amount;
	
	public Order() {
		foods = new ArrayList<>();
		amount = 0;
	}

	public void addOrder(Food food) {
		foods.add(food);
		amount += food.getPrice();
	}
	
	public void printOrder() {
		System.out.println("주문 내역");
		for (Food food : foods) {
			System.out.println("메뉴이름: " + food.getFoodName());
		}
		System.out.println("주문 금액: " + amount + "원");
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
}
