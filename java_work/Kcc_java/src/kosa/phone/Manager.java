package kosa.phone;

// 전화번호 관리 전반적인 기능
public class Manager {
	private PhoneInfo[] arr;
//	private Scanner sc;
	private int count = 0;
	
	public Manager() {
		arr = new PhoneInfo[100];
//		sc = new Scanner(System.in);
	}
	
	public void addPhoneInfo(String menu) {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력받아
		// phoneInfo 객체를 생성해서 배열에 추가하는 것
		try {
			System.out.print("이름: ");
			String name = DataInput.sc.nextLine();
			System.out.print("전화번호: ");
			String phoneNo = DataInput.sc.nextLine();
			System.out.print("생년월일: ");
			String birth = DataInput.sc.nextLine();
			
			PhoneInfo phoneInfo = generatePhoneInfo(menu, name, phoneNo, birth);
			arr[count++] = phoneInfo;
			System.out.println("전화번호가 등록 되었습니다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("허용된 등록 크기는 " + 10 + "명입니다.");
		}
			
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
	
	public void listPhoneInfo(String menu) {
		for (int i = 0; i < count; i++) {
			if (menu.equals("2") && arr[i] instanceof Company) {
				arr[i].show();
			} else if (menu.equals("3") && arr[i] instanceof Universe) {
				arr[i].show();
			} else if (menu.equals("1")) {
				arr[i].show();
			}
		}
	}
	
	public void searchPhoneInfo() throws Exception {
		// 검색하고자하는 이름으로 1개의 PhoneInfo 객체의 내용을 출력한다.
		System.out.print("검색 이름: ");
		String inputName = DataInput.sc.nextLine();
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
