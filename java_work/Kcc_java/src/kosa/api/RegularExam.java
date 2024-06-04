package kosa.api;

import java.util.Scanner;

public class RegularExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		String str = sc.nextLine();
		
		// abc 문자 포함 여부 체크
//		if (str.matches(".*abc.*")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}
		
		// 숫자만 3자리 유무 판단 -> \\
//		if (str.matches("[\\d]{3}")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}
		
		// 알파벳, 숫자만 5자리 이상
//		if (str.matches("[\\w]{5,}")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}
		
		// 한글 3~5자리
//		if (str.matches("[가-힣]{3, 5}")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}
		
		// 이메일 검증
		if (str.matches("^[\\p{Alpha}][\\w]*@[\\p{Alpha}]{1,5}+(\\.[com|net]+)$")) {
			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}
	}
}
