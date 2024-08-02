package kosa.model;

import java.io.Serializable;

public class Author implements Serializable {
	private int author_id;
	private String name;
	private String address;
	
	public Author() {}

	public Author(int author_id, String name, String address) {
		this.author_id = author_id;
		this.name = name;
		this.address = address;
	}
}
