package kosa.thread;

public class TransferThread extends Thread {
	SharedArea sharedArea;

	public TransferThread() {}
	public TransferThread(SharedArea sharedArea) {
		this.sharedArea = sharedArea;
	}
	
	@Override
	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {
			synchronized (sharedArea) {
				try {
					sharedArea.account1.withdraw(1_000_000);
					System.out.print("이몽룡 계좌: 100만원 인출,");
					sharedArea.account2.deposit(1_000_000);
					System.out.println("성충향 계좌: 100만원 입금");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
