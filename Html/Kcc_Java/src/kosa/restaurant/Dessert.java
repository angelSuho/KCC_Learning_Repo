package kosa.restaurant;

public class Dessert extends MenuItem {
	private boolean glutenFree;
	
	public Dessert() {}
	public Dessert(String name, long price, String description,
			boolean glutenFree) {
		super(name, price, description);
		this.glutenFree = glutenFree;
	}
	
	public boolean getGlutenFree() {
		return this.glutenFree;
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print("글루틴 여부: ");
		System.out.println(this.glutenFree == false ? "무" : "유");
	}
}
