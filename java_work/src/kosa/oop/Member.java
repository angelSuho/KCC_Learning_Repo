package kosa.oop;

public class Member {
	// 회원 정보에 대한 클래스와 객체를 생성후 출력해 봅시다.
	private String name;
	private int age;
	private String address;
	
	public Member() {}
	public Member(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void printMember() {
		System.out.println("이름: " + this.name);
		System.out.println("나이: " + this.age);
		System.out.println("주소: " + this.address);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void updateAddress(String address) {
		this.address = address;
	}
}
