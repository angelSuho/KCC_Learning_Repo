package kosa.board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		
		System.out.println("kcc 게시판");
		while(true) {
			System.out.println("1.추가 2.전체출력 3.수정 4.종료");
			System.out.print("메뉴 입력: ");
			String menu = sc.nextLine();
			
			switch(menu) {
				case "1":
					board.insert(generatePost(sc));
					break;
				case "2":
					board.list();
					break;
				case "3":
					System.out.print("수정할 게시물 번호 입력: ");
					int idx = Integer.parseInt(sc.nextLine());
					board.update(generatePost(sc), idx - 1);
					break;
				case "4":
					System.out.println("프로그램 종료");
					return;
			}
		}
	}

	private static Post generatePost(Scanner sc) {
		System.out.print("제목 입력: ");
		String title = sc.nextLine();
		System.out.print("내용 입력: ");
		String content = sc.nextLine();
		System.out.print("작성자 입력: ");
		String writer = sc.nextLine();
		return new Post(title, content, writer);
	}
}
