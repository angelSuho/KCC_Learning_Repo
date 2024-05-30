package kosa.phone;

import java.util.Scanner;

import kosa.task.PhoneInfo;

public class Main {
	
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("1.추가 2.전체출력 3.검색 4.수정 5.삭제 6.종료");
			System.out.print("메뉴 입력: ");
			String menu = sc.nextLine();
			
			switch(menu) {
				case "1":
					manager.addPhoneInfo();
					break;
				case "2":
					manager.listPhoneInfo();
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
						String name = sc.nextLine();
						System.out.print("전화번호 입력: ");
						String phoneNo = sc.nextLine();
						
						manager.updatePhoneInfo(name, phoneNo);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "5":
					try {
						System.out.print("이름 입력: ");
						String name = sc.nextLine();
						manager.deletePhoneInfo(name);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "6":
					System.out.println("프로그램 종료");
					return;
			}
		}
	}
}
