package kosa.oop4;

public class Reader extends Man implements Speakable {
	
	public Reader() {}
	public Reader(String name) {
		super(name);
	}
	
	@Override
	public String speak() {
		return this.getName() + "자바화이팅";
	}
}
