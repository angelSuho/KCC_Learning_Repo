package kosa.thread;

public class DigitThread extends Thread {
	@Override
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1_000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
