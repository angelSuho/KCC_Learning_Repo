package kosa.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListMission {
	public static void main(String[] args) {
		// List 자료구조를 활용하여 키보드로부터 문자열을 입력받아 처리하자.
		// 1. 데이터 추가 2. 데이터 삭제 3. 데이터 출력(for, Iterator) 4. 종료
		Scanner sc = new Scanner(System.in);
		
		List<String> lst = new LinkedList<>();
		while(true) {
			System.out.println("1.데이터 추가 2.데이터 삭제 3.데이터 출력(for, Iterator) 4.종료");
			System.out.print("입력: ");
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input) {
			case 1:
				System.out.print("문자열 입력: ");
				lst.add(sc.nextLine());
				break;
			case 2: 
				System.out.print("문자열 입력: ");
				lst.remove(lst.indexOf(sc.nextLine()));
				break;
			case 3:
				for (String str : lst) {
					System.out.println(str);
				}
				break;
			case 4:
				System.out.println("종료합니다.");
				return;
			}
		}
		
	}
}
