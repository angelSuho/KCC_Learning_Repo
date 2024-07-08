package kosa.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExam02 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("김길동", 80));
		list.add(new Person("김길동", 20));
		list.add(new Person("김길동", 50));
		list.add(new Person("김길동", 23));
		list.add(new Person("김길동", 30));
		list.add(new Person("김길동", 60));
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// 이름을 기준으로 오름차순
				// String: 앞쪽문자열.compareTo(뒷쪽문자열)
				// 0 -> 앞쪽(AAA) == 뒷쪽(AAA)
				// -1 -> 앞쪽(AAA) < 뒷쪽(ABB)
				// 1 -> 앞쪽(ABB) > 뒷쪽(AAA)	
				System.out.println(o1.getName() + " " + o2.getName());
				if (o1.getName().compareTo(o2.getName()) > 0)
					return 1;
				return -1;
			}
		});
		
		System.out.println(list);
	}
}
