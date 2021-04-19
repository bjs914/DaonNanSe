package user.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	//모든 실행이 시작되고 종료되기까지의 시간을 확인하기 위한 클래스
	//또한 AOP와 연결하기 위한 것, 핵심기능을 호출 하는 것 (실행의 흐름에 끼어드는 것을 확인하기 위한 클래스)

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		long starttm = System.currentTimeMillis();
		System.out.printf("PerformanceTraceAdvice : start(%d)...\n",starttm);
		
		try {
		return joinPoint.proceed();	//핵심기능을 호출하는 직접적인 부분
		//LogginAspect 클래스의 함수를 실행
		}
		finally {
			long endtm = System.currentTimeMillis();
			System.out.printf("PerformanceTraceAdvice : end(%d) (%d)ms...\n",endtm,(endtm-starttm));
		}
		
	}
}
