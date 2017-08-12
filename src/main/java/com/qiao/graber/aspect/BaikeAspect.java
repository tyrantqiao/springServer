package com.qiao.graber.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 * 19:02
 */
@Aspect
@Component
public class BaikeAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(BaikeAspect.class);

    public BaikeAspect() {
    }

    @Pointcut("execution(public * com.qiao.graber.controller.BaikeController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint jointPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("class={}" + jointPoint.getSignature().getDeclaringTypeName());
        LOGGER.info("method={}" + request.getMethod());
//        LOGGER.info("you are using the graber");
    }

    @After("log()")
    public void doAfter() {
        LOGGER.info("done");
    }
}
