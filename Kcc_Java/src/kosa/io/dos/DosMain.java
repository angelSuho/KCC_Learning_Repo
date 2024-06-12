package kosa.io.dos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DosMain {
	
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		while(true) {
			System.out.println(path);
			
			System.out.print(">");
			String input = bf.readLine();
			
			String[] split = input.split(" ");
			if (input.equals("ls")) {
				File file = new File(path);
				if (file.isDirectory() ) {
					for (File f: file.listFiles()) {
						if (f.isDirectory())
							System.out.println("**" + f.getName());
						else
							System.out.println("-" + f.getName());
					}
				}
			} else if (input.matches("cd\\s.*[가-힣\\dA-Za-z.].*$")) {
				if (!split[1].equals(".."))
					path += "\\" + split[1];
				else {
					int idx = path.lastIndexOf('\\');
					if (idx != -1)
						path = path.substring(0, idx);
		        }
			} else if (input.matches("mkdir\\s.*[가-힣\\dA-Za-z].*$")) {
				File file = new File(path + "\\" + split[1]);
				file.mkdir();
			} else if (split[0].equals("vi")) {
				FileWriter fw = new FileWriter(path + "\\" + split[1]);
				
				try {
					input = bf.readLine();
					while(!input.equals("q")) {
						fw.write(input);
						input = bf.readLine();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						fw.close();
						System.out.println("종료합니다.");
					} catch (Exception e2) {
						System.out.println(e2.getMessage());				
					}
				}
			}
				
		}
	}
}
