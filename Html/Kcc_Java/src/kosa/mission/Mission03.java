package kosa.mission;

import java.util.Scanner;

public class Mission03 {

	public static void main(String[] args) {
		// ������ �������� ���ؼ� ��ü �ڸ��� �� ¦��, Ȧ���� ������ ������
		// ex) 5�ڸ� -> 12345
		// ¦���� ����: 2��
		// Ȧ���� ����: 3��
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		int cnt = 10;
		int even = 0;
		int odd = 0;

		int i = 0;
		int lgth = String.valueOf(num).length();
		while(lgth > i) {
			int currentNum = num % cnt;
			
			if (currentNum % 2 == 1) {
				odd++; 
			} else if (currentNum % 2 == 0) {
				even++;
			}
			num /= cnt;
			i++;
			
		}
		System.out.println("¦��: " + even);
		System.out.println("Ȧ��: " + odd);

	}

}
