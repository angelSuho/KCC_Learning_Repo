package kosa.oop4;

public class Main {

	public static void main(String[] args) {
		Object[] obj = {
				new Reader("둘리"),
				new Work("길동"),
				new Student("마이콜")
		};
		
		for (Object man : obj) {
			if (man instanceof Speakable) {
				Speakable speakable = (Speakable) man;
				System.out.println(speakable.speak());
			}
		}
	}
}
