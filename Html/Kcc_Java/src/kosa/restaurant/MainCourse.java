package kosa.restaurant;

public class MainCourse extends MenuItem {
	private boolean vegetarian;
	
	public MainCourse() {}
	public MainCourse(String name, long price, String description,
			boolean vegetarian) {
		super(name, price, description);
		this.vegetarian = vegetarian;
	}
	
	public boolean getVegetarian() {
		return this.vegetarian;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("채식 여부: ");
		System.out.println(this.vegetarian);
	}
}
