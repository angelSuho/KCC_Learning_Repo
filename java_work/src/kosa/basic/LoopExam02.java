package kosa.basic;

public class LoopExam02 {
	public static void main(String[] args) {
		// 중첩 for문
		// ex) 전체 구구단 출력
//		for (int i = 2; i <= 9; i++) {
//			for (int j = 1; j < 10; j++) {
//				System.out.println(i + " * " + j + " = " + j*i);
//			}
//		}
//		
		// 퀴즈 > 4x + 5y = 60 -> x, y의 해 구하기 (모든 경우의 수) 
//		outerLabel:
//		for (int i = 0; i <= 15; i++) {
//			for (int j = 0; j <= 12; j++) {
//				if (4 * i + 5 * j == 60) {
//					System.out.print(4 * i + " + " + 5 * j + " = " + "60 / ");
//					System.out.println("x: " + i + ", y: " + j);
//					break outerLabel;
//				}
//			}
//		}
		
	// 퀴즈 > 
	// *
	// **
	// ***
	// ****
	// *****
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		System.out.println();
		
		for (int i = 5; i > 0; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		
	}
}
