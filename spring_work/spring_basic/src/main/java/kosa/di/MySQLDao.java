package kosa.di;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLDao implements Dao {

	public void insertBoard() {
		System.out.println("MySQLDao insertBoard() ȣ��");
	}

}
