package kosa.phone;

import java.util.Collections;
import java.util.Comparator;

public class Main {
	
//	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("1.추가 2.전체출력 3.검색 4.수정 5.삭제 6.정렬 7.종료");
			System.out.print("메뉴 입력: ");
			String input = DataInput.sc.nextLine();
			String menu = input;
			
			switch(menu) {
				case "1":
					System.out.println("1.일반 2.회사 3.동창");
					System.out.print("번호 입력: ");
					menu = DataInput.sc.nextLine();
					manager.addPhoneInfo(menu);
					break;
				case "2":
					System.out.println("1.일반 2.회사 3.동창");
					System.out.print("번호 입력: ");
					menu = DataInput.sc.nextLine();
					manager.listPhoneInfo(menu);
					break;
				case "3":
					try {
						manager.searchPhoneInfo();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "4":
					try {
						System.out.print("이름 입력: ");
						String name = DataInput.sc.nextLine();
						System.out.print("전화번호 입력: ");
						String phoneNo = input;
						
						manager.updatePhoneInfo(name, phoneNo);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "5":
					try {
						System.out.print("이름 입력: ");
						String name = DataInput.sc.nextLine();
						manager.deletePhoneInfo(name);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "6":
					System.out.println("정렬 기준을 선택하세요. 1.생년월일 2.이름순 3.번호순");
					System.out.print("입력: ");
					int inputMenu = Integer.parseInt(DataInput.sc.nextLine());
					manager.calculateSortArray(inputMenu);
					System.out.println("정렬이 완료 되었습니다.");
					break;
				case "7":
					System.out.println("프로그램 종료");
					return;
			}
		}
	}
}
