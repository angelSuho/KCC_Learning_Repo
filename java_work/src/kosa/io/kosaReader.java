package kosa.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class kosaReader {
	public static void main(String[] args) {
		// 파일 (poem.txt)에 있는 문자열 데이터를 읽어오기
		FileReader fileReader = null;
		char[] arr = new char[10];
		
		try {
			fileReader = new FileReader("poem.txt");
			
			while (true) {
				Arrays.fill(arr, ' ');
				int data = fileReader.read();
				if (data == -1) break;
				System.out.print((char) data);
				
			}
			
//			while (true) {
//				int data = fileReader.read();
//				if (data == -1) break;
//				System.out.print((char) data);
//			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
