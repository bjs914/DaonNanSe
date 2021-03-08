package user.aop.annot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component //@Component : <Bean class=“…”/>와 동일한 표현
@Aspect
public class LogginAspect {
	
	//@Before : 모든 실행이 시작 되기 전, 한번 출력
	// "execution(public * user..read*(..))" : public으로 선언된 모든 것들 중 user.로 시작하는 모든 클래스를 실행하라는 의미
	
	@Before("execution(public * user..read*(..))")
	public void before(JoinPoint joinPoint) {
		String singatureName = joinPoint.getSignature().getName();
		
		System.out.println("LogginAspect : @Before -> "+singatureName);
	}
	
	//모든 실행의 중간에 출력
	@Around("execution(public * user..*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureName = joinPoint.getSignature().getName();
		
		System.out.println("LogginAspect : @Around -> "+signatureName);
		
		try {
		return joinPoint.proceed();	//핵심기능을 호출
		}catch(Exception e) {
			return null;
		}
	}

	//@After : 모든 실행이 끝난 후, 마지막에 한번 출력
	// execution(public * user..*(..)) : user이름이 중간에 들어가는 메소드이름을 실행하라는 의미
	@After("execution(public * user..*(..))")
	public void afterFinally(JoinPoint joinPoint) {
		String signatureName = joinPoint.getSignature().getName();
		
		System.out.println("LogginAspect : @After -> "+signatureName);
	}
}
