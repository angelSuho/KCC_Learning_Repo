package kosa.api;

public class PersonMain {
	
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("홍길동", 20);
		
		if (p1.equals(p2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		System.out.println(p1);
		Integer integer = 1;
		System.out.println(integer.toString());
		Double d = 3.14;
		System.out.println(d.toString());
		if (integer == Integer.parseInt(new Integer(1).toString()))
			System.out.println("Qwe");
	}
}
