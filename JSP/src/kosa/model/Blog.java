package kosa.model;

public class Blog {
	private int id;
	private String title;
	private String content;
	private Author author;
	
	public Blog() {}
	public Blog(int id, String title, String content, Author author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
