package kosa.task;

import java.util.Scanner;

public class PhoneInfoMain {
	
	private static final int INFO_LIMIT = 10;
	private static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		PhoneInfo[] Manager = new PhoneInfo[INFO_LIMIT];
		int idx = 0;
		
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("1.추가 2.전체출력 3.검색 4.종료");
			System.out.print("메뉴: ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
				case 1:
					idx = addPhoneInfo(Manager, idx);
					break;
				case 2:
					listPhoneInfo(Manager, idx);
					break;
				case 3:
					try {
						searchPhoneInfo(Manager, idx);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("프로그램 종료");
					return;
			}
		}
	}
	
	private static int addPhoneInfo(PhoneInfo[] Manager, int idx) {
		try {
			System.out.print("이름: ");
			String name = sc.nextLine();
			System.out.print("전화번호: ");
			String phoneNo = sc.nextLine();
			System.out.print("생년월일: ");
			String birth = sc.nextLine();
			Manager[idx++] = new PhoneInfo(name, phoneNo, birth);
			System.out.println("전화번호가 등록 되었습니다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("허용된 등록 크기는 " + INFO_LIMIT + "명입니다.");
		}
		
		return idx;
	}
	
	private static void listPhoneInfo(PhoneInfo[] Manager, int idx) {
		for (int i = 0; i < idx; i++) {
			System.out.println("이름:" + Manager[i].name);
			System.out.println("전화번호:" + Manager[i].phoneNo);
			System.out.println("생년월일:" + Manager[i].birth);
		}
	}
	
	private static void searchPhoneInfo(PhoneInfo[] Manager, int idx) throws Exception {
		System.out.print("검색 이름: ");
		String inputName = sc.nextLine();
		for (int i = 0; i < idx; i++) {
			if (Manager[i].name.equals(inputName) ) {
				System.out.println("이름:" + Manager[i].name);
				System.out.println("전화번호:" + Manager[i].phoneNo);
				System.out.println("생년월일:" + Manager[i].birth);
				return;
			}
		}
		

		throw new Exception("검색 기록이 없습니다.");
	}
}
