package kosa.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 70),
				new Student("홍용동", 80),
				new Student("김길동", 90)
		);
		
		/*
		// 방법 1
		Stream<Student> studentStream = list.stream();
		// 중간 처리 (학생 객체를 점수로 매핑)
		IntStream scoreSteam = studentStream.mapToInt(student -> student.getScore());
		// 최종 처리 (평균 점수)
		double avg = scoreSteam.average().getAsDouble();
		*/
		list.stream().mapToInt(s -> s.getScore())
		.forEach(score -> System.out.println(score));
		
		list.stream().map(Student::getName)
		.forEach(name -> System.out.println(name));
	
		list.stream().filter(s -> s.getName().startsWith("홍"))
			.forEach(s -> System.out.println(s.getName()));
		
		// 방법 2
		double avg = list.stream()
				.mapToInt(student -> student.getScore())
				.average().getAsDouble();
		
		System.out.println("평균 점수: " +avg);
		
	}
}
