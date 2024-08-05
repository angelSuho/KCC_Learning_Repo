package kosa.di;

import org.springframework.stereotype.Service;

@Service
public class KosaService implements Kosa {

	// AOP가 호출 된다. (service가 포함되어 있기 때문)
	public void insertService() {
		System.out.println("Kosa insertService()");
	}

	// AOP가 호출 되지 않는다. (service가 포함되지 않았기 때문)
	public void list() {
		System.out.println("Kosa list");
	}

}
