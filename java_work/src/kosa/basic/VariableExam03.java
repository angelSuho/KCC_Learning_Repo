package kosa.basic;

public class VariableExam03 {

	public static void main(String[] args) {
		// 지역(local)변수 특징
		// 1. 반드시 초기화 후 사용
		// 2. 선언된 변수는 정의된 범위 안에서만 사용 가능
		
		int num = 0;
		num = num + 1;
		System.out.println(num);
		
		int a = 0;
		if (num == 1) {
			a = 100;
		}
		
		System.out.println("a: " + a);
		
		int i = 1;
		for (;i <= 10; i++) {
			System.out.print(i + ", ");
		}
		System.out.println("최종 i: " + i);
		
		// 변수 사용시 고민
		// 1. 어떤 종류의 데이터 -> 데이터타입 선언 결정 
		// 2. 데이터 어디 범위 사용 -> 변수 선언 위치 결저
		
		// 연산자 %
		System.out.println(10%3);
		
		if (11 % 2 == 0) {
			System.out.println("2의 배수");
		} else {
			System.out.println("2의 배수 아님");
		}
		
		int num2 = 1;
		num2++;
		
		System.out.println(num2);
		
		double d = 3.14 + 1;
		System.out.println(d);
		if (d == 4.14) {
			System.out.println("같다");
		} else {
			System.out.println("다르다.");
		}
		
		
	}
}
