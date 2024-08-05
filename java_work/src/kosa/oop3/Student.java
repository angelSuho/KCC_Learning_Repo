package kosa.oop3;

public class Student implements Role {
	
	public Student() {}
	
	@Override
	public void doing() {
		System.out.println("공부를 하다.");
	}
}
