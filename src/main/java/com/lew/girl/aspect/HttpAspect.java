package com.lew.girl.aspect;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

/*    @Before("execution(public * com.lew.girl.controller.GirlController.*(..))")
    public void log(){
        System.out.println(11111);
    }

    @After("execution(public * com.lew.girl.controller.GirlController.*(..))")
    public void doAfter(){
        System.out.println(22222222);
    }*/

    @Pointcut("execution(public * com.lew.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());


    }

    @After("log()")
    public void doAfter(){
        //System.out.println(222222);
        logger.info("2222222222");
    }

    @AfterReturning(returning = "object",pointcut="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());

    }
}
