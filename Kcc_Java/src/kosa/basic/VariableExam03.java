package kosa.basic;

public class VariableExam03 {

	public static void main(String[] args) {
		// ����(local)���� Ư¡
		// 1. �ݵ�� �ʱ�ȭ �� ���
		// 2. ����� ������ ���ǵ� ���� �ȿ����� ��� ����
		
		int num = 0;
		num = num + 1;
		System.out.println(num);
		
		int a = 0;
		if (num == 1) {
			a = 100;
		}
		
		System.out.println("a: " + a);
		
		int i = 1;
		for (;i <= 10; i++) {
			System.out.print(i + ", ");
		}
		System.out.println("���� i: " + i);
		
		// ���� ���� ���
		// 1. � ������ ������ -> ������Ÿ�� ���� ���� 
		// 2. ������ ��� ���� ��� -> ���� ���� ��ġ ����
		
		// ������ %
		System.out.println(10%3);
		
		if (11 % 2 == 0) {
			System.out.println("2�� ���");
		} else {
			System.out.println("2�� ��� �ƴ�");
		}
		
		int num2 = 1;
		num2++;
		
		System.out.println(num2);
		
		double d = 3.14 + 1;
		System.out.println(d);
		if (d == 4.14) {
			System.out.println("����");
		} else {
			System.out.println("�ٸ���.");
		}
		
		
	}
}
