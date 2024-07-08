package kosa.board;

public class Board {
	private int idx;
	private Post[] posts;
	
	public Board() {
		posts = new Post[10];
	}

	public Post[] getPosts() {
		return posts;
	}	
	
	public void insert(Post post) {
		try {
			posts[idx++] = post;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("최대 저장 게시물은 10개 입니다.");
		}
	}
	
	public void list() {
		for (int i = 0; i < idx; i++) {
			System.out.println("게시물 번호 " + (i + 1));
			posts[i].printPostInfo();
		}
	}
	
	public void update(Post post, int idx) {
		posts[idx].update(post);
	}
}
