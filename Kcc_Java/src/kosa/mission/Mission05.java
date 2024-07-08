package kosa.mission;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mission05 {

	public static void main(String[] args) {
		// 메뉴를 선택해서 해당 메뉴를 명령문으로 실행해보자.
		// 1.추가 2.출력 3.검색 4.종료: 
		List<String> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.println("1.추가 2.출력 3.검색 4.종료: ");
			System.out.print("입력: ");
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
				case 1:
					System.out.print("추가: ");
					String str1 = sc.nextLine();
					arr.add(str1);
					break;
				case 2:
					arr.forEach(str -> System.out.println(str));
					break;
				case 3:
					System.out.print("검색: ");
					System.out.println(arr.get(Integer.parseInt(sc.nextLine())));
					break;
				case 4:
					return;
			}
			//sc.nextLine();
		}
	}

}
