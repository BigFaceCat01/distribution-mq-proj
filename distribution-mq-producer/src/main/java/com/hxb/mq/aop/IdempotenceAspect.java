package com.hxb.mq.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-24 14:50:30
 */
@Aspect
@Component
public class IdempotenceAspect {
    public void idempotencePoint(){}
}
