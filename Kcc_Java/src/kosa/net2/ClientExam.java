package kosa.net2;

import java.net.Socket;

public class ClientExam {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.249", 9000);
			System.out.println("서버 실행 중.....");

			Thread receive = new ClientReceive(socket);
			Thread sender = new ClientSender(socket);
			
			receive.start();
			sender.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
