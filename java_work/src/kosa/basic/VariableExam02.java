package kosa.basic;

import java.io.IOException;
import java.util.Scanner;

public class VariableExam02 {
	
	private static final Scanner sc = new Scanner(System.in);
			

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char ch = 'A';
		
		for (int i = 0; i < 26; i++) {
			System.out.print((char)(ch + i));
		}
		int num = 4;
		
		String num2 = num + "";
		System.out.println();
		
		sc.close();
	}

}
