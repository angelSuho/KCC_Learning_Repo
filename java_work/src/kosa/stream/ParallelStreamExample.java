package kosa.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("감자바");
		list.add("람다식");
		list.add("박병렬");
		
		Stream<String> stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		// 병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(name -> {
			System.out.println(name + ": " + Thread.currentThread().getName());
		});
		
		IntStream.of(2,4,5,6,8,10).boxed().collect(Collectors.toList());
		
		// 문자열 배열 -> List, Stream 변환
		String arr[] = {"BB", "CC", "AA"};
//		List<String>list3 = Arrays.asList(arr);
//		Stream<String> stream2 = list3.stream();
//		stream2.sorted().forEach(System.out::println);
		
		Stream<String> stream2 = Arrays.stream(arr);
		stream2.sorted().forEach(System.out::println);
	}
}
