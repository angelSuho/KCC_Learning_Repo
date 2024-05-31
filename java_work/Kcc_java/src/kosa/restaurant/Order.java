package kosa.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<MenuItem> menuItems;
	private static long dayTotalPrice = 0;
	
	public Order() {
		menuItems = new ArrayList<>();
	}
	
	public void addOrder(MenuItem menuItem) {
		menuItems.add(menuItem);
	}
	
	public void removeOrder(String name) {
		for (MenuItem menuItem: menuItems) {
			if (menuItem.getName().equals(name)) {
				menuItems.remove(menuItem);
			}
		}
	}
	
	public boolean pay() {
		for (MenuItem menuItem: menuItems) {
			setDayTotalPrice(getDayTotalPrice() + menuItem.getPrice());
		}
		
		menuItems.clear();
		return true;
	}

	public static long getDayTotalPrice() {
		return dayTotalPrice;
	}

	public static void setDayTotalPrice(long dayTotalPrice) {
		Order.dayTotalPrice = dayTotalPrice;
	}
}
