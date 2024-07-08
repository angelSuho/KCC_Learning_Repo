package kosa.oop2;

public class MySQLDao extends Dao {

	@Override
	public void insert() {
		System.out.println("MySQL Dao Insert 호출");
	}
}
