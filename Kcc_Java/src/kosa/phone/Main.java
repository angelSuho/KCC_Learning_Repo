package kosa.phone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = DataInput.sc;
		Manager manager = new Manager();
		
		while(true) {
			System.out.println("1.추가 2.전체출력 3.검색 4.수정 5.삭제 6.정렬 7.전화번호 저장 8.전화번호 불러오기 9.종료");
			System.out.print("메뉴 입력: ");
			String input = sc.nextLine();
			String menu = input;
			
			switch(menu) {
				case "1":
					insertPhoneInfo(sc, manager);
					break;
				case "2":
					showPhoneInfo(sc, manager);
					break;
				case "3":
					try {
						manager.searchPhoneInfo();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case "4":
					updatePhoneInfo(sc, manager);
					break;
				case "5":
					deletePhoneInfo(sc, manager);
					break;
				case "6":
					sortPhoneInfo(sc, manager);
					break;
				case "7":
					savePhoneInfos(manager);
					break;
				case "8":
					reloadPhoneInfos(manager);
					break;
				case "9":
					System.out.println("프로그램 종료");
					return;
			}
		}
	}

	private static void sortPhoneInfo(Scanner sc, Manager manager) {
		System.out.println("정렬 기준을 선택하세요. 1.생년월일 2.이름순 3.번호순");
		System.out.print("입력: ");
		int inputMenu = Integer.parseInt(sc.nextLine());
		manager.calculateSortArray(inputMenu);
		System.out.println("정렬이 완료 되었습니다.");
	}

	private static void deletePhoneInfo(Scanner sc, Manager manager) {
		try {
			System.out.print("이름 입력: ");
			String name = sc.nextLine();
			manager.deletePhoneInfo(name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void updatePhoneInfo(Scanner sc, Manager manager) {
		try {
			System.out.print("이름 입력: ");
			String updateName = sc.nextLine();
			System.out.print("전화번호 입력: ");
			String updatePhoneNo = sc.nextLine();
			
			manager.updatePhoneInfo(updateName, updatePhoneNo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void showPhoneInfo(Scanner sc, Manager manager) {
		System.out.println("1.일반 2.회사 3.동창");
		System.out.print("번호 입력: ");
		String printInput = sc.nextLine();
		manager.listPhoneInfo(printInput);
	}

	private static void insertPhoneInfo(Scanner sc, Manager manager) {
		System.out.println("1.일반 2.회사 3.동창");
		System.out.print("번호 입력: ");
		String kind = sc.nextLine();
		
		System.out.print("이름: ");
		String insertName = DataInput.sc.nextLine();
		System.out.print("전화번호: ");
		String insertPhoneNo = DataInput.sc.nextLine();
		System.out.print("생년월일: ");
		String insertBirth = DataInput.sc.nextLine();
		
		manager.addPhoneInfo(kind, insertName, insertPhoneNo, insertBirth);
	}

	private static void savePhoneInfos(Manager manager) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("phoneInfo.ser"));
			oos.writeObject(manager.getArr());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				oos.close();
				manager.deleteAll();
				System.out.println("저장 완료");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void reloadPhoneInfos(Manager manager) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("phoneInfo.ser"));
			manager.addPhoneInfos((List<PhoneInfo>) ois.readObject());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ois.close();
				System.out.println("불러오기 완료");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
