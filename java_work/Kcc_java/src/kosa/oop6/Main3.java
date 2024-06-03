package kosa.oop6;

interface AA {
	BB abc(String string);
}

class BB {
	BB() {
		System.out.println("BB 생성자");
	}
}

class CC {
	BB get(AA aa) {
		return aa.abc("홍길동");
	}
}

public class Main3 {
	public static void main(String[] args) {
		// 1. 익명 내부 클래스 
//		AA a1 = new AA() {
//			
//			@Override
//			public BB abc() {
//				return new BB();
//			}
//		};
//		a1.abc();
//		
//		// 2. 람다식
//		AA a2 = () -> new BB();
//		a2.abc();
//		
//		// 3. 인스턴스 참조
//		AA a3 = BB::new;
//		a3.abc();
		CC cc = new CC();
		BB b = cc.get(BB::new);
	}
}
