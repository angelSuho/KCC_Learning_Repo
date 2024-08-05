package kosa.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 30));
		students.add(new Student("신용권", 10));
		students.add(new Student("유미선", 20));
		
		// 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		students.stream().sorted().forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();
		
		// 점수를 기준으로 내림차순으로 정렬한 새스트림 얻기
		students.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();
		
		// 점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
		students.stream()
			.sorted((s1,s2) -> Integer.compare(s1.getScore(), s2.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
			
		// 점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
		students.stream()
			.sorted((s1,s2) -> Integer.compare(s2.getScore(), s1.getScore()))
			.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
