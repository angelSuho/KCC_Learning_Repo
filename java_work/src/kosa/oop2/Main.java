package kosa.oop2;

public class Main {
	
	public static void main(String[] args) {
		OracleDao dao = new OracleDao();
		MySQLDao mySQLDao = new MySQLDao();
		
		MyService myService = new MyService(mySQLDao);
		MyService myServiceInner = new MyService(
				new Dao() {
					
					@Override
					public void insert() {
						System.out.println("inner class 호출");
					}
				});
		myService.insertService();
		myServiceInner.insertService();
	}
}
