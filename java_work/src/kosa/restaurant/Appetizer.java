package kosa.restaurant;

public class Appetizer extends MenuItem {
	private double calories;
	
	public Appetizer() {}
	public Appetizer(String name, long price, String description, 
			double calories) {
		super(name, price, description);
		this.calories = calories;
	}
	
	public double getCalories() {
		return this.calories;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("칼로리: ");
		System.out.println(this.calories + " cal");
	}
}
