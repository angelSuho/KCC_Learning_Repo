package kosa.board;

public class Post {
	private String title;
	private String content;
	private String writer;
	
	public Post() {}
	public Post(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void update(Post post) {
		setTitle(post.getTitle());
		setContent(post.getContent());
		setWriter(post.getWriter());
	}
	
	public void printPostInfo() {
		System.out.println("제목: " + title);
		System.out.println("내용: " + content);
		System.out.println("작성자: " + writer);
	}
}
