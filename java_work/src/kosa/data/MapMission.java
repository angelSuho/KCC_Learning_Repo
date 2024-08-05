package kosa.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapMission {
	public static void main(String[] args) {
		// 이름, 점수를 한쌍으로 Map 자료구조로 구현하시오. ex) 김자바: 90, 박자바: 60
		// 1. 시험 응시자만 출력
		// 2. 총점, 평균, 최고점수, 최저점수 출력 Collections -> max(), min()
		
		Map<String, Integer> map = new HashMap<>();
		map.put("김자바", 90);
		map.put("나자바", 80);
		map.put("박자바", 70);
		map.put("손자바", 60);
		map.put("이자바", 50);
		
		int sum = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("시험 응시자: " + entry.getKey());
			sum += entry.getValue();
		}
		
		float avg = sum / map.size();
		Integer maxValue = Collections.max(map.values());
		Integer minValue = Collections.min(map.values());
		
		System.out.println("총점: " + sum + "점");
		System.out.println("평균: " + avg + "점");
		System.out.println("최고 점수: " + maxValue + "점");
		System.out.println("최저 점수: " + minValue + "점");
		
	}
}
