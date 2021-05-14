package com.acn.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Value("${username}")
	private String username;
	
	private static final Logger LOG= LogManager.getLogger(LoggingAspect.class);

	@Pointcut("execution(public * com.acn.service.CustomerService.save*(..))")
	private void logginSave(){}
	

	@Pointcut("execution(public * com.acn.service.CustomerService.del*(..))")
	private void logginDel(){}
	
	@Before("logginSave()")
	public void logJoinPoint(JoinPoint joinPoint) {
		
		String[] user=this.username.split("\\.");
		
		String mesage="Username: "+user[0]+" "+user[2]+" Signature name : ";
		
		
		LOG.info("LoggingAspect: {}{}{}",mesage,joinPoint,joinPoint.getArgs());
	}
	
	@Before("logginDel()")
	public void logJoinPoint2(JoinPoint joinPoint) {
		
		String[] user=this.username.split("\\.");
		
		String mesage="Username: "+user[0]+" "+user[2]+" Signature name : ";
		
		
		LOG.info("LoggingAspect: {}{}{}",mesage,joinPoint,joinPoint.getArgs());
	}

}
