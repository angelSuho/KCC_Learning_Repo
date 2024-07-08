package kosa.net1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExam {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("112.221.184.60", 9000);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			String message = "지승용지승용지승용지승용지승용지승용지승용지승용지승용지승용지승용지승용지승용지승용지승용";
			out.write(message.getBytes());
			
			byte[] arr = new byte[100];
			in.read(arr);
			System.out.println("서버에서 보낸 메세지: " + new String(arr));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
