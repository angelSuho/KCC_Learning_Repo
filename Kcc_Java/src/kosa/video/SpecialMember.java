package kosa.video;

public class SpecialMember extends GeneralMember {
	private int bonusPoint;
	
	public SpecialMember() {}
	public SpecialMember(int bonusPoint,
			String id, String name, String address) {
		super(id, name, address);
		this.bonusPoint = bonusPoint;
	}
	
	@Override
	public void rental(Video video) {
		super.rental(video);
		this.bonusPoint += 10;
	}
	
	@Override
	public void printVideos() {
		super.printVideos();
		System.out.println("회원의 보너스 포인터 적립: " + this.bonusPoint);
	}
	
	public void specialPrint() {
		System.out.println("스페셜 멤버");
	}
}
