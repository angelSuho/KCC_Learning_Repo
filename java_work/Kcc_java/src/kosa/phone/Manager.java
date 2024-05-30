package kosa.phone;

import java.util.Arrays;
import java.util.Scanner;

// 전화번호 관리 전반적인 기능
public class Manager {
	private PhoneInfo[] arr;
	private Scanner sc;
	private int count = 0;
	
	public Manager() {
		arr = new PhoneInfo[100];
		sc = new Scanner(System.in);
	}
	
	public void addPhoneInfo() {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력받아
		// phoneInfo 객체를 생성해서 배열에 추가하는 것
		try {
			System.out.print("이름: ");
			String name = sc.nextLine();
			System.out.print("전화번호: ");
			String phoneNo = sc.nextLine();
			System.out.print("생년월일: ");
			String birth = sc.nextLine();
			
			PhoneInfo phoneInfo = new PhoneInfo(name, phoneNo, birth);
			arr[count++] = phoneInfo;
			System.out.println("전화번호가 등록 되었습니다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("허용된 등록 크기는 " + 10 + "명입니다.");
		}
			
	}
	
	public void listPhoneInfo() {
		for (int i = 0; i < count; i++) {
			arr[i].show();
		}
	}
	
	public void searchPhoneInfo() throws Exception {
		// 검색하고자하는 이름으로 1개의 PhoneInfo 객체의 내용을 출력한다.
		System.out.print("검색 이름: ");
		String inputName = sc.nextLine();
		for (int i = 0; i < count; i++) {
			if (inputName.equals(inputName) ) {
				arr[i].show();
				return;
			}
		}
		
		throw new Exception("검색 기록이 없습니다.");
	}

	public void updatePhoneInfo(String name, String phoneNo) throws Exception {
		// 이름을 입력 -> 해당 phoneInfo 추출 -> 수정 전화번호 입력 -> 전화번호 수정이 완료
		for (int i = 0; i < count; i++) {
			if (arr[i].getName().equals(name)) {
				arr[i].setPhoneNo(phoneNo);
				return;
			}
		}
		
		throw new Exception("이름에 맞는 조회 내용이 없습니다.");
	}

	public void deletePhoneInfo(String name) throws Exception {
		// 이름 입력 -> 대상 객체 검색 -> 인덱스 찾기 -> 해당 객체 삭제
		for (int i = 0; i < this.count; i++) {
			if (this.arr[i].getName().equals(name)) {
				if (arrIndexPull(i)) {
					this.count--;
					return;
				}
			}
		}
		throw new Exception("이름에 맞는 조회 내용이 없습니다.");
	}
	
	private boolean arrIndexPull(int idx) {
		if (idx == this.count - 1) {
			this.arr[idx] = null;
			return true;
		}
		
		for (int i = idx; i < this.count; i++) {
			this.arr[idx] = this.arr[idx + 1];
		}
		
		return true;
	}
}
