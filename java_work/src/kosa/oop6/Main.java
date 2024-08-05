package kosa.oop6;

public class Main {
	public static void main(String[] args) {
		MyType myType = new MyType() {
			
			@Override
			public void hello() {
				// TODO Auto-generated method stub
				System.out.println("안녕하세요. 감사해요~ 잘있어요. 다시만나요!");
			}
		};
		myType.hello();
		
		// 람다식으로 구현
		MyType mytypeLambda = () -> {
			System.out.println("람다) 안녕하세요. 감사해요~ 잘있어요. 다시만나요!");
		};

		mytypeLambda.hello();
		
		MyType myType2 = () -> System.out.println("람다2) 안녕하세요. 감사해요~ 잘있어요. 다시만나요!");
		myType2.hello();
		
		YourType yourType = (String message) -> {
			System.out.println("메세지: " + message);
		};
		yourType.talk("안녕하세요");
		
		MyNumber myNumber = (int a, int b) -> {
			System.out.println(Math.max(a, b));
		};
		
		myNumber.max(3, 5);
		
		Runnable run = () -> {
			for (int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(i);
			}
		};
		Thread t = new Thread(run);
		t.start();
	}
}
