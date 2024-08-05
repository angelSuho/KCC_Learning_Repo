package kosa.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		 * Resource resource = new ClassPathResource("applicationContext.xml");
		 * 
		 * BeanFactory factory = new GenericXmlApplicationContext(resource);
		 */		
//		ApplicationContext factory = new AnnotationConfigApplicationContext(Factory.class);
//		
		
		String configuration[] = {
				"applicationContext.xml",
				"commonConcern.xml"
		};
		
		ApplicationContext factory = new ClassPathXmlApplicationContext(configuration);
		
		Service service = (Service) factory.getBean("writerService");
		service.insertService();
		
		Kosa kosa = (Kosa) factory.getBean("kosaService");
		kosa.list();
	}
}
