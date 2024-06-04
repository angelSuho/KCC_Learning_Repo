package kosa.api;

public class Person {
	private String name;
	private int age;
	
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object o) {
		Person p = (Person) o;
		if (this.name.equals(p.getName()) && 
				this.age == p.getAge()) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
