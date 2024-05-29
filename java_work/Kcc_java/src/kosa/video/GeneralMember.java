package kosa.video;

public class GeneralMember {
	private String id;
	private String name;
	private String address;
	private Video rentalVideo;
	
	public GeneralMember() {}
	public GeneralMember(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public void rental(Video video) {
		this.rentalVideo = video;
	}
	
	public void remove(Video video) {
		this.rentalVideo = null;
	}
	
	public void printVideos() {
		System.out.println("회원의 아이디: " + this.id);
		System.out.println("회원의 이름: " + this.name);
		System.out.println("회원의 주소: " + this.address);	
		if (this.rentalVideo != null) {
			this.rentalVideo.printVideoInfo();
		}
	}
}
