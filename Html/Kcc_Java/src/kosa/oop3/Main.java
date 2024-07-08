package kosa.oop3;

public class Main {
	public static void main(String[] args) {
		Role role = new Student();
		
		Person person = new Person("수호", 
					new Role() {
						
						@Override
						public void doing() {
							// TODO Auto-generated method stub
							System.out.println("드라이빙 역할");
						}
					}
				);
		person.doit();
	}
}
