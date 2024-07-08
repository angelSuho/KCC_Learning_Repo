package kosa.io;

import java.io.File;

public class FileExam {
	
	public static void main(String[] args) {
		
		String path ="C:\\New_KCC\\work\\java_work\\Kcc_java";
		
		File file = new File(path);
		
		printAll(file);
		
	}
	
	public static void printAll(File file) {
		if (file.isFile() || (file.listFiles().length == 0)) {
			System.out.println(file.getName());
			return;
		} else{
			System.out.println("** " + file.getName());
			File[] listFiles = file.listFiles();
			for (File f : listFiles) {
				printAll(f);
			}
			return;
		}
	}

}
