package kosa.oop5;

public class MyTread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		MyTread myTread = new MyTread();
		Thread thread = new Thread(myTread);
		thread.run();
	}
}

