package kosa.basic;

public class MethodExam {

	// 메소드 정의
	// 접근제어자, (static), 리턴형(void), 메서드 이름(파라미터(인자))
	
	public static void main(String[] args) {
//		printToString('#', 10);
//		printToString('?', 20);
//		printToString('!', 30);
		int sum = add(10, 20);
		System.out.println(sum);	
	}
	
	private static void printToString(char inputChar, int repeat) {
		for (int i = 0; i < repeat; i++) {
			System.out.print(inputChar + " ");
		}
		System.out.println();
	}

	private static int add(int num1, int num2) {
		int sum = num1 + num2;
//		System.out.println(sum);
		return sum;
	}
}
