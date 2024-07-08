package kosa.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyExam {
	
	public static void main(String[] args) throws IOException {
//		poem2.txt => poem3.txt
		FileReader reader = new FileReader("poem2.txt");
		FileWriter fw = new FileWriter("poem3.txt");
	
		try {
			while(true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				fw.write(ch);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				System.out.println("종료합니다.");
				reader.close();
				fw.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());				
			}
		}
	}

}
