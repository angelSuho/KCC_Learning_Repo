package kosa.thread.sum;

public class SumMain {
	
	public static void main(String[] args) {
		// t1: 1~50 합 을구하는 스레드
		// t2: 51~100 합을 구하는 스레드
		// main: t1합 + t2합 -> 합: 5050
		SumThread t1 = new SumThread(1, 50);
		SumThread t2 = new SumThread(51, 100);
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("합: " + (t1.getSum() + t2.getSum()));
	}
}
