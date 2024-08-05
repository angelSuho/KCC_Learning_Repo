package kosa.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 전화번호 관리 전반적인 기능
public class Manager {
	private List<PhoneInfo> arr;
	private int maxCount = 10;
	
	public Manager() {
		arr = new ArrayList<PhoneInfo>();
	}
	
	public void addPhoneInfo(String menu, String name, String phoneNo, String birth) {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력받아
		// phoneInfo 객체를 생성해서 배열에 추가하는 것
		if (arr.size() > maxCount)
			throw new ArrayIndexOutOfBoundsException("허용된 등록 크기는 " + maxCount + "명입니다.");
			
		arr.add(generatePhoneInfo(menu, name, phoneNo, birth));
		System.out.println("전화번호가 등록 되었습니다.");		
	}
	
	public void addPhoneInfos(List<PhoneInfo> phoneInfos) {
		arr.addAll(phoneInfos);
	}

	private PhoneInfo generatePhoneInfo(String menu, String name, String phoneNo, String birth) {
		PhoneInfo phoneInfo = null;
		switch(menu) {
			case "1":
				phoneInfo = new PhoneInfo(name, phoneNo, birth);
				break;
			case "2":
				System.out.print("부서: ");
				String dept = DataInput.sc.nextLine();
				System.out.print("직책: ");
				String position = DataInput.sc.nextLine();
				phoneInfo = new Company(name, phoneNo, birth, dept, position);
				break;
			case "3":
				System.out.print("전공: ");
				String major = DataInput.sc.nextLine();
				System.out.print("학번: ");
				String year = DataInput.sc.nextLine();
				phoneInfo = new Universe(name, phoneNo, birth, major, year);
				break;
		}
		
		return phoneInfo;
	}
	
	public void deleteAll() {
		arr.clear();
	}
	
	public List<PhoneInfo> getArr() {
		return arr;
	}

	public void setArr(List<PhoneInfo> arr) {
		this.arr = arr;
	}

	public void listPhoneInfo(String menu) {
		for (int i = 0; i < arr.size(); i++) {
			if (menu.equals("2") && arr.get(i).getClass().equals(Company.class)) {
				arr.get(i).show();
			} else if (menu.equals("3") && arr.get(i).getClass().equals(Universe.class)) {
				arr.get(i).show();
			} else if (menu.equals("1")) {
				arr.get(i).show();
			}
		}
	}
	
	public void searchPhoneInfo() throws Exception {
		// 검색하고자하는 이름으로 1개의 PhoneInfo 객체의 내용을 출력한다.
		System.out.print("검색 이름: ");
		String inputName = DataInput.sc.nextLine();
		for (int i = 0; i < arr.size(); i++) {
			if (inputName.equals(inputName) ) {
				arr.get(i).show();
				return;
			}
		}
		
		throw new Exception("검색 기록이 없습니다.");
	}

	public void updatePhoneInfo(String name, String phoneNo) throws Exception {
		// 이름을 입력 -> 해당 phoneInfo 추출 -> 수정 전화번호 입력 -> 전화번호 수정이 완료
		for (int i = 0; i < this.arr.size(); i++) {
			if (arr.get(i).getName().equals(name)) {
				arr.get(i).setPhoneNo(phoneNo);
				return;
			}
		}
		
		throw new Exception("이름에 맞는 조회 내용이 없습니다.");
	}

	public void deletePhoneInfo(String name) throws Exception {
		// 이름 입력 -> 대상 객체 검색 -> 인덱스 찾기 -> 해당 객체 삭제
		for (int i = 0; i < this.arr.size(); i++) {
			if (this.arr.get(i).getName().equals(name)) {
				arr.remove(i);
				return;
			}
		}
		throw new Exception("이름에 맞는 조회 내용이 없습니다.");
	}
	
	public void calculateSortArray(int input) {	
		switch(input) {
		case 1:
			Collections.sort(this.arr, new Comparator<PhoneInfo>() {

				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					if (o1.getBirth().compareTo(o2.getBirth()) > 0)
						return 1;
					return -1;
				}
			});
		case 2:
			Collections.sort(this.arr, new Comparator<PhoneInfo>() {

				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					if (o1.getName().compareTo(o2.getName()) > 0)
						return 1;
					return -1;
				}
			});
		case 3:
			Collections.sort(this.arr, new Comparator<PhoneInfo>() {
				
				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					if (o1.getPhoneNo().compareTo(o2.getPhoneNo()) > 0)
						return 1;
					return -1;
				}
			});
		}
	}
}
