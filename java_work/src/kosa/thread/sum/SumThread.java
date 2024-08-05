package kosa.thread.sum;

public class SumThread extends Thread {
	private int x;
	private int y;
	private int sum;
	
	public SumThread(int x, int y) {
		this.x = x;
		this.y = y;
		this.sum = 0;
	}
	
	public int getSum() {
		return this.sum;
	}
	
	@Override
	public void run() {
		for (int i = this.x; i <= this.y; i++) {
			this.sum += i;
		}
	}
}
