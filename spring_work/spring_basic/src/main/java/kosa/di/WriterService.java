package kosa.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class WriterService implements Service {
	
	@Autowired
	@Qualifier("mySQLDao")
	private Dao dao;
	
	public WriterService() {}
	public WriterService(Dao dao) {
		this.dao = dao;
	}
	
	public void insertService() {
		System.out.println("WriterService insertService »£√‚");
		dao.insertBoard();
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
