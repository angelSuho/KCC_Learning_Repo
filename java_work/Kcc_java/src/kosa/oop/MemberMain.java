package kosa.oop;

public class MemberMain {

	public static void main(String[] args) {
		Member member = new Member("이수호", 26, "서울시 동작구");	// 객체 생성 -> 인스턴스화 : member -> 인스턴스 변수
		
		System.out.println(member.address);
		
		member.updateAddress("서울시 어디구");
		
		member.printMember();
	}

}
