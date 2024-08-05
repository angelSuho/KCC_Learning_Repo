package kosa.di;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 공통 관심 사항
public class LoggingAspect {
	// 행식 관심 사항 (insertService()) -> 공통 관심 사항 함께 호출 (핵심 관심 메소드가 호출될 때, 호출 시간을 측정)
	// 타이머 생성 -> 타이머 작동 -> 실제 메서드 호출 -> 타이머 종료 -> 로그 출력
	private Log log = LogFactory.getLog(getClass());
	
	// 공통 관심 메소드
	// 언제 호출 (advice: around)
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("로그 시작");
		StopWatch watch = new StopWatch();
		Object obj = null;
		
		try {
			watch.start();
			
			// 이 AOP 클래스를 호출할 실제 호출 메소드
			obj = joinPoint.proceed(); // ex) insertService() 호출
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			watch.stop();
			log.info(joinPoint.getSignature().getName() + "메소드 실행 시 : " + 
			watch.getTotalTimeMillis());
		}
		
		return obj;
	}
}