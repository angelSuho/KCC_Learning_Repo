package kosa.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class FileMission {
	
	public static void main(String[] args) throws IOException {
		//1. 바이트스트림을 이용하여 이미지 파일을 복사해 보자
//		String source = "C:\\New_KCC\\Java\\다운로드.PNG";
//		String dest = "C:\\New_KCC\\Java\\upload\\다운로드.PNG";
		
//		File sourceFile = new File(source);
//		File destFile = new File(dest);
//		CopyUtil.copyFile(sourceFile, destFile);
//		Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		//2. 디렉토리 복사를 구현하자.
		String source = "C:\\Users\\KOSA\\KCC\\work\\java_work\\Kcc_java\\src\\kosa\\mission04";
		String dest = "C:\\Users\\KOSA\\KCC\\upload\\mission04";
		File sourceDirectory = new File(source);
		File destDirectory = new File(dest);
		
		CopyUtil.copyDirectory(sourceDirectory, destDirectory);
		System.out.println("완료");
		
	}

}
