package kosa.video;

public class Main {
	
	public static void main(String[] args) {
		Video video1 = new Video(1L, "트랜스포머", "서봉수");
		Video video2 = new Video(2L, "쿵더펜더2", "지성민");
		
		GeneralMember generalMember1 = new GeneralMember("aaa", "홍길동", "동탄");
		GeneralMember generalMember2 = new GeneralMember("bbb", "김철수", "서울");
		
		generalMember1.rental(video1);
		generalMember2.rental(video2);
		
		generalMember1.printVideos();
		System.out.println("-----------------------------");
		generalMember2.printVideos();
	}
}
