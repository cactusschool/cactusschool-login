package com.ashish.jwt.token.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Around("execution(* com.ashish.poc.services..*(..)) || "
//			+ "execution(* com.ashish.poc.ws..*(..))")
	@Around("execution(* com.ashish.jwt.token.services.*.*(..)) || "
			+ "execution(* com.ashish.jwt.token.controller.*.*(..)))")
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		logger.debug(">>>>>>>>>>" + pjp.getSignature().toShortString()
				+ " START >>>>>>>>>>>>");
		Object retVal = pjp.proceed();
		long end = System.currentTimeMillis();
		logger.debug("[" + pjp.getSignature().toShortString()
				+ "] method Execution Time: " + (end - start) + " ms.");
		logger.debug("<<<<<<<<" + pjp.getSignature().toShortString()
				+ " END <<<<<<<<");
		return retVal;
	}
}