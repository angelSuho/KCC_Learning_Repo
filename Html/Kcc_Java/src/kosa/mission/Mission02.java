package kosa.mission;

import java.util.Scanner;

public class Mission02 {

	public static void main(String[] args) {
		// �������� ����
		// ����, ����, ���� ������ Ű����κ��� �Է¹ް�
		// ������ ����� ����ϼ���. (��, ����� �Ǽ���)
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է�: ");
		int language = Integer.parseInt(sc.nextLine());
		System.out.print("���� ���� �Է�: ");
		int english = Integer.parseInt(sc.nextLine());
		System.out.print("���� ���� �Է�: ");
		int math = Integer.parseInt(sc.nextLine());
		
		int sum = language + english + math;
		float average = sum / 3f;
		int averageInt = (int) (sum / 3f);
		System.out.println("����: " + sum);
		System.out.println("���: " + averageInt);
		byte d = 10;
		int a = 1 + d;
		byte qwe = (byte) (d + d);
		float b = d  +a;
		
		// ������ 90�̻� -> a
		// 80�̻� -> b
		// 70�̻� -> c
		// 60�̻� -> d
		// 60���� -> f
		
//		if (average >= 90) System.out.println("a");
//		else if (average >= 80) System.out.println("b");
//		else if (average >= 70) System.out.println("c");
//		else if (average >= 50) System.out.println("d");
//		else System.out.println("f");
		
		switch(averageInt / 10) {
			case 10:
			case 9:
				System.out.println("a");
			case 8:
				System.out.println("b");
			case 7:
				System.out.println("c");
			case 6:
				System.out.println("d");
			default:
				System.out.println("f");
				
		}
	}

}
