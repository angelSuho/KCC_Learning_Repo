package kosa.phone;

import java.util.Scanner;

// 전화번호 관리 전반적인 기능
public class Manager {
	private PhoneInfo[] arr;
	private Scanner sc;
	private int count;
	
	public Manager() {
		arr = new PhoneInfo[10];
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
}
