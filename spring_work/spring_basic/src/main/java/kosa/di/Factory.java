package kosa.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Factory {
	
	@Bean
	public Dao oracleDao() {
		return new OracleDao();
	}
	
	@Bean
	public Service writerService2() {
		return new WriterService();
	}
}
