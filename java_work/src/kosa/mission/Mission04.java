package kosa.mission;

import java.util.Scanner;

public class Mission04 {

	public static void main(String[] args) {
		// ���ڿ� ��
//		String a = "abc";
//		String b = "abc";
//		
//		if (a == b) {
//			System.out.println("same");
//		} else {
//			System.out.println("different");
//		}
		
		// �� ������ ������ ���ڿ��� �Է� �޾�
		// ��Ģ���� ����� ����Ͻÿ� (����)
		// ex)	����1: 10
		//		����2: 20
		// 		������: +
		// 		���: 30
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����1 �Է�: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("����2 �Է�: ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("������ �Է�: ");
		String operater = sc.nextLine();
		
		if (operater.equals("+")) {
			System.out.println("���: " + num1 + num2);
		} else if (operater.equals("-")) {
			System.out.println("���: " + (num1 - num2));
		} else if (operater.equals("*")) {
			System.out.println("���: " + num1 * num2);
		} else if (operater.equals("/")) {
			System.out.println("���: " + num1 / num2);
		}
	}

}
