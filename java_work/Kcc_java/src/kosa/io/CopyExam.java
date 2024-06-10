package kosa.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CopyExam {
	public static void main(String[] args) {
		// poem2.txt -> poem3.txt: 복사를 구현해보자.
		FileWriter writer = null;	
		FileReader reader = null;
		char[] arr = new char[100];
		
		try {
			reader = new FileReader("poem2.txt");
			writer = new FileWriter("poem3.txt");
			
			while (true) {
	            Arrays.fill(arr, ' ');
	            int data = reader.read(arr);
	            if (data == -1) {
	               break;
	            }
	            writer.write(arr);
	         }
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				writer.close();
				reader.close();
				System.out.println("복사 완료");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
