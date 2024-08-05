package kosa.stream;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 85));
		students.add(new Student("홍길동", 92));
		students.add(new Student("홍길동", 87));
		
		// Student를 score 스트림으로 변환
		students.stream()
			.mapToInt(s -> s.getScore())
			.forEach(score -> System.out.println(score));
	}
}
