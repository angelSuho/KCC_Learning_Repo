package kosa.di;

import org.springframework.stereotype.Service;

@Service
public class KosaService implements Kosa {

	// AOP�� ȣ�� �ȴ�. (service�� ���ԵǾ� �ֱ� ����)
	public void insertService() {
		System.out.println("Kosa insertService()");
	}

	// AOP�� ȣ�� ���� �ʴ´�. (service�� ���Ե��� �ʾұ� ����)
	public void list() {
		System.out.println("Kosa list");
	}

}
