package kosa.thread;

public class MultiThreadExample {
	public static void main(String[] args) {
		DigitThread thread = new DigitThread();
		thread.start();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
			try {
				Thread.sleep(1_000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

