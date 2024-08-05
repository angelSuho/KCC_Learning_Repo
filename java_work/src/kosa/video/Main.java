package kosa.video;

public class Main {
	
	public static void main(String[] args) {
		Video[] videos = new Video[] {
				new Video(1L, "트랜스포머", "서봉수"),
				new Video(2L, "쿵더펜더2", "지성민")
		};
		
//		GeneralMember generalMember = new GeneralMember("aaa", "홍길동", "동탄");
//		SpecialMember specialMember = new SpecialMember(10, "bbb", "김철수", "서울");
//		
//		generalMember.rental(videos[0]);
//		specialMember.rental(videos[1]);
//		
//		generalMember.printVideos();
//		System.out.println("-----------------------------");
//		specialMember.printVideos();
		
		// GeneralMember와 SpecialMember를 함께 배열에 넣고 
		// 각각의  rental(), show() 호출 출력
		// 특히 SpecialMember는 specialPrint() 호출되도록 하여라.
		GeneralMember[] members = new GeneralMember[] {
				new GeneralMember("aaa", "홍길동", "동탄"),
				new SpecialMember(10, "bbb", "김철수", "서울")
		};
		
		for (int i = 0; i < members.length; i++) {
			members[i].rental(videos[i]);
			members[i].printVideos();
			
			if (members[i] instanceof SpecialMember) {
				SpecialMember sMember = (SpecialMember) members[1];
				sMember.specialPrint();
			}
		}
	}
}
