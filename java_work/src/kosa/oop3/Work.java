package kosa.oop3;

public class Work implements Role {
	
	public Work() {}
	
	@Override
	public void doing() {
		System.out.println("일을 하다.");
	}
}
