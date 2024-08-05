package kosa.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class kosaWriter {
	public static void main(String[] args) {
		// 키보드로부터 문자열을 입력 받아 파일에 쓰는 예제를 구현하자.
		// 'q'를 입력하기 ㅈ전까지 문자열을 파일에 쓰도록 하자.
		// FileWriter: writer(문자열)
		// 파일명: poem2.txt: 미리생성x
		// 코드 실행 후 리프래쉬 -> 파일 생성 확인 O
		// close() 구현
		Scanner sc = new Scanner(System.in);
		FileWriter writer = null;	
		
		try {
			writer = new FileWriter("poem2.txt");
			
			while(true) {
				System.out.print("입력: ");
				String input = sc.nextLine();
				if (input.equals("q")) break;
				writer.write(input + "\n");	
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				writer.close();
				System.out.println("파일 저장 완료");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
