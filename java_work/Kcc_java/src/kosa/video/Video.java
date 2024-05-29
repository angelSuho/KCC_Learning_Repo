package kosa.video;

public class Video {
	private Long videoNo;
	private String title;
	private String actor;
	
	public Video() {}
	public Video(Long videoNo, String title, String actor) {
		this.videoNo = videoNo;
		this.title = title;
		this.actor = actor;
	}
	
	public Long getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(Long videoNo) {
		this.videoNo = videoNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	public void printVideoInfo() {
		System.out.println("회원이 대여한 비디오 번호: " + this.videoNo);
		System.out.println("회원이 대여한 비디오 제목: " + this.title);
		System.out.println("회원이 대여한 비디오 주인공: " + this.actor);
	}
}
