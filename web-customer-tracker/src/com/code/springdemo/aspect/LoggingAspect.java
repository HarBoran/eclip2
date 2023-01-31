package com.code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//Logger setting up
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
   //괄호 안의 (* com.code~) 이 부분에서 *은 리턴 타입임. void를 쓸 수도 있음. 따라서 *을 쓰고 띄워야 함. 
   //controller 패키지에 있는 모든 파일의 모든 타입의 모든 메서드에 적용한다는 의미.
	@Pointcut("execution(* com.code.springdemo.controller.*.*(..))")
	//Pointcut : aspect를 나눠주는 분기점. 기준은 패
	private void forContrtrollerPackage() {}
	
	@Pointcut("execution(* com.code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forContrtrollerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();	
	 //기호로 나타내고 모든 메시지를 단축해서 내보내달라
		myLogger.info("========> in @Before:calling method: " + theMethod);
	}
	
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("========>> in @AfterReturning:from method: " + theMethod);
		myLogger.info("========>> result: " + theResult);
	}
	
}
