package com.hxb.mq.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.sql.rowset.serial.SerialException;
import java.lang.reflect.Method;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 14:50:30
 */
@Aspect
@Component
@Slf4j
public class ParamLogAspect {

    @Pointcut("@annotation(com.hxb.mq.aop.ParamLog)")
    public void paramLogPointcut(){}

    @Around(value = "paramLogPointcut()")
    public Object processAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();

        JSONObject jsonObject = new JSONObject();
        for (int i=0;i<args.length;i++) {
            jsonObject.put("arg"+i,args[i]);
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        ParamLog paramLog = methodSignature.getMethod().getAnnotation(ParamLog.class);

        log.info("\r\n>>>params log: {}>>>>{}:{}",paramLog.message(),methodSignature.getName(),jsonObject.toJSONString());

        Object result = joinPoint.proceed(args);

        log.info("\r\n>>>result: {}", JSON.toJSONString(result));

        return result;
    }
}
