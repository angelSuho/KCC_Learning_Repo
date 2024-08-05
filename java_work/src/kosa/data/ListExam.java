package kosa.data;

import java.util.Set;
import java.util.TreeSet;

public class ListExam {
	public static void main(String[] args) {
		// 1~45 중복되지 않은 로또 번호 6개를 출력하자.
		// 1. 배열로 구분
//		int[] n = new int[6];
//		
//		for (int i = 0; i < 6; i++) {
//			n = generateRandomNum(n, i);
//		}
//		System.out.println(Arrays.toString(n));
		
		// 2. List 구현
//		List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < 6; i++) {
//			int rn = (int)(Math.random() * 45) + 1;
//			while (list.contains(rn)) {
//				rn = (int)(Math.random() * 45) + 1;
//			}
//			list.add(rn);
//		}
//		
//		Collections.sort(list);
//		System.out.println(list.toString());
		
		// 3. Set 구현 (TreeSet) --> 중복 허용 X
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 0; set.size() < 6; i++) {
			set.add((int)(Math.random()*45) + 1 );
		}
		
		System.out.println(set);
	}

	private static int[] generateRandomNum(int[] n, int i) {
		boolean isTrue = true;
		while(isTrue) {
			int rn = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i+1; j++) {
				if (n[j] == rn) {
					break;
				} else if (j == i && n[j] != rn) {
					n[i] = rn;
					isTrue = false;
				}
			}
		}
		return n;
	}
}
