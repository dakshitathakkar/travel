package com.triptrace.travel.core.logging;

import com.triptrace.travel.core.constants.ApplicationConstant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class APILoggable {

    @Before(value = "execution(* com.triptrace.travel..*(..))")
    public void loggingBeforeMethodExecution(JoinPoint joinPoint){
        Class<?> className = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(String.format(ApplicationConstant.PRE_MESSAGE,className.getSimpleName(),methodName));
    }

    @AfterReturning(value = "execution(* com.triptrace.travel..*(..))")
    public void loggingAfterMethodExecution(JoinPoint joinPoint){
        Class<?> className = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Logger logger = LoggerFactory.getLogger(className);
        logger.info(String.format(ApplicationConstant.POST_MESSAGE,className.getSimpleName(),methodName));
    }

}
