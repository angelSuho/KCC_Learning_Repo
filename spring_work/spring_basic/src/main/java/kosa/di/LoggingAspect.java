package kosa.di;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// ���� ���� ����
public class LoggingAspect {
	// ��� ���� ���� (insertService()) -> ���� ���� ���� �Բ� ȣ�� (�ٽ� ���� �޼ҵ尡 ȣ��� ��, ȣ�� �ð��� ����)
	// Ÿ�̸� ���� -> Ÿ�̸� �۵� -> ���� �޼��� ȣ�� -> Ÿ�̸� ���� -> �α� ���
	private Log log = LogFactory.getLog(getClass());
	
	// ���� ���� �޼ҵ�
	// ���� ȣ�� (advice: around)
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("�α� ����");
		StopWatch watch = new StopWatch();
		Object obj = null;
		
		try {
			watch.start();
			
			// �� AOP Ŭ������ ȣ���� ���� ȣ�� �޼ҵ�
			obj = joinPoint.proceed(); // ex) insertService() ȣ��
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			watch.stop();
			log.info(joinPoint.getSignature().getName() + "�޼ҵ� ���� �� : " + 
			watch.getTotalTimeMillis());
		}
		
		return obj;
	}
}