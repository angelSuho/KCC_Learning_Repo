package kosa.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyUtil {
	
	//디렉토리 복사(해당 폴더 복사해서 새로운 디렐토리를 새엇ㅇ 후 모든 파일을 복사)
	public static void copyDirectory(File source, File dest) {
		if(source.isDirectory()) {
			dest.mkdirs();
			
			File files[] = source.listFiles();
			for (File f : files) {
				if(f.isDirectory()) {
					//new File(디렉토리 경로, 파일이름);
					copyDirectory(f, dest);
				} else {
					copyFile(f, new File(dest, f.getName()));
				}
			}
		}
	}
	
	//바이트 값을 가진 파일 1개를 복사하는 메서드
	//source 원본 dest 복사한걸 넣을 파일
	public static void copyFile(File source, File dest) {
		
		FileInputStream input = null;
		FileOutputStream output = null;
		
		try {
			
			input = new FileInputStream(source);
			output = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			
		    int readData;
		    while ((readData = input.read(buf)) > 0){
		    	output.write(buf, 0, readData);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				input.close();
				output.close();				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
